package org.bs.web.config;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.sun.net.httpserver.HttpPrincipal;

/**
 * 
 * Copyright 漏 2017 閲戠鏁欒偛. All rights reserved. <br>
 * 绫�: HttpClient <br>
 * 鎻忚堪: httpclient宸ュ叿绫� <br>
 * 浣滆��: Teacher song<br>
 * 鏃堕棿: 2017骞�7鏈�21鏃� 涓嬪崍3:15:27
 */
public class HttpClientUtil {
	
	static CloseableHttpClient client = null;
	static {
		client = HttpClients.createDefault();
	}
	
	/**
	 * 
	 * 鏂规硶: get <br>
	 * 鎻忚堪: get璇锋眰 <br>
	 * 浣滆��: Teacher song<br>
	 * 鏃堕棿: 2017骞�7鏈�21鏃� 涓嬪崍3:15:25
	 * @param url
	 * @param params
	 * @return
	 * @throws Exceptionm
	 */
	public static String get(String url,HashMap<String, Object> params) throws Exception {
		HttpGet httpGet = new HttpGet();
		Set<String> keySet = params.keySet();
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(url).append("?t=").append(System.currentTimeMillis());
		for (String key : keySet) {
			stringBuffer.append("&").append(key).append("=").append(params.get(key));
		}
		httpGet.setURI(new URI(stringBuffer.toString()));
		CloseableHttpResponse execute = client.execute(httpGet);
		int statusCode = execute.getStatusLine().getStatusCode();
		if (200 != statusCode) {
			return "";
		}
		return EntityUtils.toString(execute.getEntity(), "utf-8");
	}
	
	public static String get2(String url,String params) throws Exception {
		HttpGet httpGet = new HttpGet();
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(url).append("/").append(params);
		httpGet.setURI(new URI(stringBuffer.toString()));
		CloseableHttpResponse execute = client.execute(httpGet);
		int statusCode = execute.getStatusLine().getStatusCode();
		if (200 != statusCode) {
			return "";
		}
		return EntityUtils.toString(execute.getEntity(), "utf-8");
	}
	/**
	 * 
	 * 鏂规硶: post <br>
	 * 鎻忚堪: post璇锋眰 <br>
	 * 浣滆��: Teacher song<br>
	 * 鏃堕棿: 2017骞�7鏈�21鏃� 涓嬪崍3:20:31
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String post(String url,HashMap<String, Object> params) throws Exception {
		HttpPost httpPost = new HttpPost();
		httpPost.setURI(new URI(url));
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			NameValuePair e = new BasicNameValuePair(key, params.get(key).toString());
			parameters.add(e);
		}
		HttpEntity entity = new UrlEncodedFormEntity(parameters , "utf-8");
		httpPost.setEntity(entity );
		CloseableHttpResponse execute = client.execute(httpPost);
		int statusCode = execute.getStatusLine().getStatusCode();
		if (200 != statusCode) {
			return "";
		}
		return EntityUtils.toString(execute.getEntity(), "utf-8");
	}
}
