package com.jjst;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

public class ThreadTest  extends Thread{
	
	
	/**
	 * 封装支付HTTP POST方法
	 * 
	 * @param
	 * @param
	 * @return
	 * @throws ClientProtocolException
	 * @throws java.io.IOException
	 */
	public static String postPayMsg(String url, Map<String, String> paramMap)
			throws ClientProtocolException, IOException {
		HttpClient httpClient = new DefaultHttpClient();
		System.setProperty("sun.net.client.defaultConnectTimeout", String   
                .valueOf(10000));// （单位：毫秒）  
        System.setProperty("sun.net.client.defaultReadTimeout", String   
                .valueOf(10000)); //
		httpClient.getParams().setIntParameter(CoreConnectionPNames.SO_TIMEOUT, 10000);
		httpClient.getParams().setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000);
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> formparams = setHttpParams(paramMap);
		UrlEncodedFormEntity param = new UrlEncodedFormEntity(formparams, "UTF-8");
		// 通过setEntity()设置参数给post
		httpPost.setEntity(param);
		String result = null;
		// 利用httpClient的execute()方法发送请求并且获取返回参数
		HttpResponse response = httpClient.execute(httpPost);
		if (response != null) {
			HttpEntity rEntity = response.getEntity();
			if (rEntity != null) {
				result = EntityUtils.toString(rEntity, "UTF-8");
			}
		}
		return result;
	}

	/**
	 * 设置请求参数
	 * 
	 * @param
	 * @return
	 */
	private static List<NameValuePair> setHttpParams(Map<String, String> paramMap) {
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		Set<Map.Entry<String, String>> set = paramMap.entrySet();
		for (Map.Entry<String, String> entry : set) {
			formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		return formparams;
	}
	
	
	@Override
	public void run() {
		final String string = "http://192.168.1.20:8080/HustElective/interface/elective/selectiveCourse";
		Map<String, String> map = new HashMap<String, String>();
		List<Map<String, String>> li = new ArrayList<Map<String, String>>();
		map.put("plan_id", "1");
		map.put("userid", "6560");
		map.put("id", "641");
		li.add(map);
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("plan_id", "1");
		map2.put("userid", "6561");
		map2.put("id", "644");
		li.add(map2);
		Map<String, String> map3 = new HashMap<String, String>();
		map3.put("plan_id", "1");
		map3.put("userid", "6562");
		map3.put("id", "647");
		li.add(map3);
		Map<String, String> map4 = new HashMap<String, String>();
		map4.put("plan_id", "1");
		map4.put("userid", "6563");
		map4.put("id", "648");
		li.add(map4);
		Map<String, String> map5 = new HashMap<String, String>();
		map5.put("plan_id", "1");
		map5.put("userid", "6564");
		map5.put("id", "649");
		li.add(map5);
		Map<String, String> map6 = new HashMap<String, String>();
		map6.put("plan_id", "1");
		map6.put("userid", "6565");
		map6.put("id", "650");
		li.add(map6);
		Map<String, String> map7 = new HashMap<String, String>();
		map7.put("plan_id", "1");
		map7.put("userid", "6566");
		map7.put("id", "641");
		li.add(map7);
		Map<String, String> map8 = new HashMap<String, String>();
		map8.put("plan_id", "1");
		map8.put("userid", "6567");
		map8.put("id", "641");
		li.add(map8);
		Map<String, String> map9 = new HashMap<String, String>();
		map9.put("plan_id", "1");
		map9.put("userid", "6568");
		map9.put("id", "641");
		li.add(map9);
		Map<String, String> map10 = new HashMap<String, String>();
		map10.put("plan_id", "1");
		map10.put("userid", "6569");
		map10.put("id", "641");
		li.add(map10);
		Map<String, String> map11 = new HashMap<String, String>();
		map11.put("plan_id", "1");
		map11.put("userid", "6570");
		map11.put("id", "641");
		li.add(map11);
		try {
			for (int i = 0; i <11; i++) {
				String str = postPayMsg(string, li.get(i));
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
