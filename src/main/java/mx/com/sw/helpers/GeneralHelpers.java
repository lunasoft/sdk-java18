package mx.com.sw.helpers;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig.Builder;

import mx.com.sw.exceptions.GeneralException;

public class GeneralHelpers {
    public static void setProxy(Builder build, String host, int port) throws GeneralException {
		if(!stringEmptyOrNull(host)){
			try {
				HttpHost proxy = new HttpHost(host, port);
				build.setProxy(proxy);
			} catch (Exception e) {
				throw new GeneralException(400, e.getMessage());
			}
		}
    }
    public static boolean stringEmptyOrNull(String st) {
	    return st == null || st.trim().isEmpty();
    }
    public static String noralizeUrl(String url){
        return !url.endsWith("/") ? url + "/" : url;
    }
}