package mx.com.sw.services;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import mx.com.sw.exceptions.GeneralException;

public abstract class ResponseHandler<T> {
    public abstract T HandleException(Throwable ex);
    public T PostHTTPJson(String url, String path, HashMap<String, String> headers, String jsonBody, RequestConfig configHTTP, Class<T> contentClass){
        CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
        try{
            client.start();
            HttpPost request = new HttpPost(url + path);
            if(headers != null){
                for(Map.Entry<String, String> entry : headers.entrySet()){
                    request.addHeader(new BasicHeader(entry.getKey(), entry.getValue()));
                }
            }
            if(configHTTP != null){
                request.setConfig(configHTTP);
            }
            if(jsonBody != null){
                StringEntity sEntity = new StringEntity(jsonBody);
                request.setEntity(sEntity);
            }
            Future<HttpResponse> future = client.execute(request, null);
            HttpResponse response = future.get(5, TimeUnit.MINUTES);
            if (response.getStatusLine() != null && response.getStatusLine().getStatusCode() < 500) {
                HttpEntity responseEntity = response.getEntity();
                String responseBody = new String();
                if (responseEntity != null) {
                    responseBody = EntityUtils.toString(responseEntity);
                    return deserialize(responseBody, contentClass);
                }
                else{
                    throw new GeneralException(response.getStatusLine() != null ? response.getStatusLine().getStatusCode() : 444, "Can´t get body from the request made.");
                }
            } else {
                throw new GeneralException(response.getStatusLine() != null ? response.getStatusLine().getStatusCode() : 500, "Error 500 calling the service.");
            }
        }
        catch(Exception e){
            return HandleException(e);
        }
        finally{
            try {
                client.close();
            } catch (IOException e) {
                return HandleException(e);
            }
        }
    }

    public T PostHTTPMultipart(String url, String path, HashMap<String, String> headers, String body, RequestConfig configHTTP, Class<T> contentClass){
        CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
        try{
            client.start();
            HttpPost request = new HttpPost(url + path);
            if(headers != null){
                for(Map.Entry<String, String> entry : headers.entrySet()){
                    request.addHeader(new BasicHeader(entry.getKey(), entry.getValue()));
                }
            }
            if(configHTTP != null){
                request.setConfig(configHTTP);
            }
            if(body != null){
                MultipartEntityBuilder builder = MultipartEntityBuilder.create();
                builder.setCharset(Charset.forName("UTF-8"));
                builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
                builder.addTextBody("xml", body, ContentType.DEFAULT_BINARY);
                request.setEntity(builder.build());
            }
            Future<HttpResponse> future = client.execute(request, null);
            HttpResponse response = future.get(5, TimeUnit.MINUTES);
            if (response.getStatusLine() != null && response.getStatusLine().getStatusCode() < 500) {
                HttpEntity responseEntity = response.getEntity();
                String responseBody = new String();
                if (responseEntity != null) {
                    responseBody = EntityUtils.toString(responseEntity);
                    return deserialize(responseBody, contentClass);
                }
                else{
                    throw new GeneralException(response.getStatusLine() != null ? response.getStatusLine().getStatusCode() : 444, "Can´t get body from the request made.");
                }
            } else {
                throw new GeneralException(response.getStatusLine() != null ? response.getStatusLine().getStatusCode() : 500, "Error 500 calling the service.");
            }
        }
        catch(Exception e){
            return HandleException(e);
        }
        finally{
            try {
                client.close();
            } catch (IOException e) {
                return HandleException(e);
            }
        }
    }

    public T GetHTTP(String url, String path, HashMap<String, String> headers, RequestConfig configHTTP, Class<T> contentClass){
        CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
        try{
            client.start();
            HttpPost request = new HttpPost(url + path);
            if(headers != null){
                for(Map.Entry<String, String> entry : headers.entrySet()){
                    request.addHeader(new BasicHeader(entry.getKey(), entry.getValue()));
                }
            }
            if(configHTTP != null){
                request.setConfig(configHTTP);
            }
            Future<HttpResponse> future = client.execute(request, null);
            HttpResponse response = future.get(5, TimeUnit.MINUTES);
            if (response.getStatusLine() != null && response.getStatusLine().getStatusCode() < 500) {
                HttpEntity responseEntity = response.getEntity();
                String responseBody = new String();
                if (responseEntity != null) {
                    responseBody = EntityUtils.toString(responseEntity, "UTF-8");
                    return deserialize(responseBody, contentClass);
                }
                else{
                    throw new GeneralException(response.getStatusLine() != null ? response.getStatusLine().getStatusCode() : 444, "Can´t get body from the request made.");
                }
            } else {
                throw new GeneralException(response.getStatusLine() != null ? response.getStatusLine().getStatusCode() : 500, "Error 500 calling the service.");
            }
        }
        catch(Exception e){
            return HandleException(e);
        }
        finally{
            try {
                client.close();
            } catch (IOException e) {
                return HandleException(e);
            }
        }
    }

    public T deserialize(String json, Class<T> contentClass) throws IOException {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, contentClass);
    }
}