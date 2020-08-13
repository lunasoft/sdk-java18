package mx.com.sw.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import mx.com.sw.entities.IResponse;
import mx.com.sw.exceptions.GeneralException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
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

/**
 * ResponseHandler Clase mediante la cual se hacen las peticiones y
 * des-serializaciones de respuestas.
 * @param <T> IResponse subclasses
 * @author Juan Gamez
 * @version 0.0.0.1
 * @since 2020-08-01
 * @see IResponse
 */
public abstract class ResponseHandler<T> {
    private static final int MAX_EXECUTION_TIME = 5;

    public abstract T handleException(Throwable ex);

    /**
     * Este método realiza un HTTP POST con la configuracion enviada.
     * @param url String url o host.
     * @param path String path
     * @param headers Map String String con headers.
     * @param jsonBody String body
     * @param configHTTP RequestConfig objeto de configuración.
     * @param contentClass Clase de respuesta esperada.
     * @return T
     */
    public T postHTTPJson(String url, String path, Map<String, String> headers, String jsonBody,
            RequestConfig configHTTP, Class<T> contentClass) {
        CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
        try {
            client.start();
            HttpPost request = new HttpPost(url + path);
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    request.addHeader(new BasicHeader(entry.getKey(), entry.getValue()));
                }
            }
            if (configHTTP != null) {
                request.setConfig(configHTTP);
            }
            if (jsonBody != null) {
                StringEntity sEntity = new StringEntity(jsonBody);
                request.setEntity(sEntity);
            }
            Future<HttpResponse> future = client.execute(request, null);
            HttpResponse response = future.get(MAX_EXECUTION_TIME, TimeUnit.MINUTES);
            if (response.getStatusLine() != null
                    && response.getStatusLine().getStatusCode() < HttpStatus.SC_INTERNAL_SERVER_ERROR) {
                HttpEntity responseEntity = response.getEntity();
                String responseBody = new String();
                if (responseEntity != null) {
                    responseBody = EntityUtils.toString(responseEntity);
                    return deserialize(responseBody, contentClass);
                } else {
                    throw new GeneralException(
                            response.getStatusLine() != null ? response.getStatusLine().getStatusCode()
                                    : HttpStatus.SC_UNPROCESSABLE_ENTITY,
                            "Can´t get body from the request made.");
                }
            } else {
                throw new GeneralException(response.getStatusLine() != null ? response.getStatusLine().getStatusCode()
                        : HttpStatus.SC_INTERNAL_SERVER_ERROR, "Error > 500 calling the service.");
            }
        } catch (IllegalArgumentException e) {
            return handleException(e);
        } catch (GeneralException e) {
            return handleException(e);
        } catch (IOException e) {
            return handleException(e);
        } catch (InterruptedException e) {
            return handleException(e);
        } catch (ExecutionException e) {
            return handleException(e);
        } catch (TimeoutException e) {
            return handleException(e);
        } catch (JsonSyntaxException e) {
            return handleException(e);
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                return handleException(e);
            }
        }
    }

    /**
     * Este método realiza un HTTP POST (modo Multipart form data) con la configuracion enviada.
     * @param url String url o host.
     * @param path String path.
     * @param headers Map String String con headers.
     * @param body String formato Multipart con body a enviar.
     * @param configHTTP RequestConfig objeto de configuración.
     * @param contentClass Clase esperada de respuesta.
     * @return T
     */
    public T postHTTPMultipart(String url, String path, Map<String, String> headers, String body,
            RequestConfig configHTTP, Class<T> contentClass) {
        CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
        try {
            client.start();
            HttpPost request = new HttpPost(url + path);
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    request.addHeader(new BasicHeader(entry.getKey(), entry.getValue()));
                }
            }
            if (configHTTP != null) {
                request.setConfig(configHTTP);
            }
            if (body != null) {
                MultipartEntityBuilder builder = MultipartEntityBuilder.create();
                builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
                builder.addTextBody("xml", body, ContentType.TEXT_PLAIN.withCharset("UTF-8"));
                request.setEntity(builder.build());
            }
            Future<HttpResponse> future = client.execute(request, null);
            HttpResponse response = future.get(MAX_EXECUTION_TIME, TimeUnit.MINUTES);
            if (response.getStatusLine() != null
                && response.getStatusLine().getStatusCode() < HttpStatus.SC_INTERNAL_SERVER_ERROR) {
                HttpEntity responseEntity = response.getEntity();
                String responseBody = new String();
                if (responseEntity != null) {
                    responseBody = EntityUtils.toString(responseEntity);
                    return deserialize(responseBody, contentClass);
                } else {
                    throw new GeneralException(
                            response.getStatusLine() != null
                                ? response.getStatusLine().getStatusCode() : HttpStatus.SC_UNPROCESSABLE_ENTITY,
                            "Can´t get body from the request made.");
                }
            } else {
                throw new GeneralException(
                        response.getStatusLine() != null
                            ? response.getStatusLine().getStatusCode() : HttpStatus.SC_INTERNAL_SERVER_ERROR,
                        "Error > 500 calling the service.");
            }
        } catch (IllegalArgumentException e) {
            return handleException(e);
        } catch (GeneralException e) {
            return handleException(e);
        } catch (IOException e) {
            return handleException(e);
        } catch (InterruptedException e) {
            return handleException(e);
        } catch (ExecutionException e) {
            return handleException(e);
        } catch (TimeoutException e) {
            return handleException(e);
        } catch (JsonSyntaxException e) {
            return handleException(e);
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                return handleException(e);
            }
        }
    }

    /**
     * Este método realiza un HTTP GET con la configuracion enviada.
     * @param url String url o host.
     * @param path String path.
     * @param headers Map String String con headers.
     * @param configHTTP RequestConfig objeto de configuración.
     * @param contentClass Clase esperada de respuesta.
     * @return T
     */
    public T getHTTP(String url, String path, Map<String, String> headers, RequestConfig configHTTP,
            Class<T> contentClass) {
        CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
        try {
            client.start();
            HttpPost request = new HttpPost(url + path);
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    request.addHeader(new BasicHeader(entry.getKey(), entry.getValue()));
                }
            }
            if (configHTTP != null) {
                request.setConfig(configHTTP);
            }
            Future<HttpResponse> future = client.execute(request, null);
            HttpResponse response = future.get(MAX_EXECUTION_TIME, TimeUnit.MINUTES);
            if (response.getStatusLine() != null
                && response.getStatusLine().getStatusCode() < HttpStatus.SC_INTERNAL_SERVER_ERROR) {
                HttpEntity responseEntity = response.getEntity();
                String responseBody = new String();
                if (responseEntity != null) {
                    responseBody = EntityUtils.toString(responseEntity, "UTF-8");
                    return deserialize(responseBody, contentClass);
                } else {
                    throw new GeneralException(
                            response.getStatusLine() != null
                            ? response.getStatusLine().getStatusCode() : HttpStatus.SC_UNPROCESSABLE_ENTITY,
                            "Can´t get body from the request made.");
                }
            } else {
                throw new GeneralException(
                        response.getStatusLine() != null
                        ? response.getStatusLine().getStatusCode() : HttpStatus.SC_INTERNAL_SERVER_ERROR,
                        "Error > 500 calling the service.");
            }
        } catch (IllegalArgumentException e) {
            return handleException(e);
        } catch (GeneralException e) {
            return handleException(e);
        } catch (IOException e) {
            return handleException(e);
        } catch (InterruptedException e) {
            return handleException(e);
        } catch (ExecutionException e) {
            return handleException(e);
        } catch (TimeoutException e) {
            return handleException(e);
        } catch (JsonSyntaxException e) {
            return handleException(e);
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                return handleException(e);
            }
        }
    }

    /**
     * Este método realiza una deserializacion de un JSON al tipo de clase T.
     * @param json String json.
     * @param contentClass Clase esperada de respuesta.
     * @return T
     * @throws JsonSyntaxException en caso de error.
     */
    public T deserialize(String json, Class<T> contentClass) throws JsonSyntaxException {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, contentClass);
    }
}
