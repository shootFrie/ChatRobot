package outsideApi;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;

/*
 * 图灵api类
 */
public class Turing {
	private String  APIKEY = "043d6b5730404b8881292afcd8a44458"; // 获取图灵机器人的api
	private URL getUrl;
	private HttpURLConnection connection;
	private JSONObject data;
	private BufferedReader reader;
	
	public JSONObject getAnswer(String INFO){
		String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY
				+ "&info=" + INFO;    //图灵机器人的api

		try {
			getUrl = new URL(getURL);//获取一个url
			connection = (HttpURLConnection) getUrl.openConnection();//URL连接
			connection.connect(); //连接开始
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		// 取得输入流，并使用Reader读取
		
		try {
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			String line = "";
			data = new JSONObject();
			while ((line = reader.readLine()) != null) {
				data = JSONObject.fromObject(line); // 将字符串转换为json
			}
			System.out.println("TURing+1=" + data.getString("text"));// 输出数据进行验证
			reader.close();
			connection.disconnect();
	
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return data;	

	}
}
