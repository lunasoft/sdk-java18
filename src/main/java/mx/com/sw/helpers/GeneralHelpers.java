package mx.com.sw.helpers;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;

import mx.com.sw.exceptions.GeneralException;

public class GeneralHelpers {
	public static RequestConfig setProxyAndTimeOut(String host, int port) throws GeneralException {
		RequestConfig.Builder options = RequestConfig.custom();
		if (!stringEmptyOrNull(host)) {
			try {
				HttpHost proxy = new HttpHost(host, port);
				options.setProxy(proxy);
			} catch (Exception e) {
				throw new GeneralException(400, e.getMessage());
			}
		}
		options.setSocketTimeout(420000).setConnectTimeout(120000).setConnectionRequestTimeout(300000);
		return options.build();
	}

	public static boolean stringEmptyOrNull(String st) {
		return st == null || st.trim().isEmpty();
	}

	public static String noralizeUrl(String url) {
		return !url.endsWith("/") ? url + "/" : url;
	}

	public static String decodeBase64(String base64) {
		byte[] bytes = Base64.getDecoder().decode(base64);
		try {
			return new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static String encodeBase64(byte[] bytes){
		return Base64.getEncoder().encodeToString(bytes);
	}
}