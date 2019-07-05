package outsideApi;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONObject;

/*
 * ͼ��api��
 */
public class Turing {
	private String  APIKEY = "043d6b5730404b8881292afcd8a44458"; // ��ȡͼ������˵�api
	private URL getUrl;
	private HttpURLConnection connection;
	private JSONObject data;
	private BufferedReader reader;
	
	public JSONObject getAnswer(String INFO){
		String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY
				+ "&info=" + INFO;    //ͼ������˵�api

		try {
			getUrl = new URL(getURL);//��ȡһ��url
			connection = (HttpURLConnection) getUrl.openConnection();//URL����
			connection.connect(); //���ӿ�ʼ
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		// ȡ������������ʹ��Reader��ȡ
		
		try {
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			String line = "";
			data = new JSONObject();
			while ((line = reader.readLine()) != null) {
				data = JSONObject.fromObject(line); // ���ַ���ת��Ϊjson
			}
			System.out.println("TURing+1=" + data.getString("text"));// ������ݽ�����֤
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
