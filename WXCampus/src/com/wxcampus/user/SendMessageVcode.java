package com.wxcampus.user;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class SendMessageVcode {
	
	public static boolean send(String tel,String vcode)
	{
		String url="http://apis.baidu.com/kingtto_media/106sms/106sms?";
		String para="mobile="+tel+"&content=【橘子皮】：您的验证码是"+vcode+"，5分钟内有效。";
        String result=getResponse(url+para);
	//	String result="Success";
        if(result.contains("Success"))
        	return true;
        else
        	return false;
	}
	
	public static String getResponse(String url)
	   {
		   HttpClient hc=new DefaultHttpClient();
			HttpGet hGet=new HttpGet(url);
			hGet.addHeader("Content-Type","application/json;charset=utf-8");
			hGet.addHeader("apikey", "12287bb65605c0497a66fc21f70c2a6a");
	   	HttpResponse hResponse;
	    try
	  		{
	  			hResponse=hc.execute(hGet);
	  			 hGet.abort();
	  			return EntityUtils.toString(hResponse.getEntity(),"utf-8");
	  		} catch (Exception e)
	  		{
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}
	    return null;
	   }

}
