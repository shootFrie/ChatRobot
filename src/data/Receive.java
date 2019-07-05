package data;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import outsideApi.Turing;
import service.DBService;

import java.io.IOException;
import java.io.PrintWriter;

import net.sf.json.JSONObject;//json������Ҫ��jar��

import java.net.URLEncoder;

/**
 * ���ͽ�����Ϣ�����뷢����Ϣ���õ�Json���ݣ�
 */
@WebServlet("/Receive")
public class Receive extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");  //���ñ����ʽ
		response.setContentType("application/json"); // ��������Ϊ����json
		String content = request.getParameter("content");// ��ȡpost�������ݵ�ֵ��content������

		String INFO = URLEncoder.encode(content, "utf-8"); // ��content�����utf-8
		
		System.out.println(content);
		
		
		DBService dbService = new DBService();
		JSONObject data = new JSONObject();
		if(dbService.getDBus(content) != null){
			data = dbService.getDBus(content);
			System.out.println(data+"03");
		}else{
			// ȡ������������ʹ��Reader��ȡ
			//ͼ�������api����
			Turing conn = new Turing();
			data = conn.getAnswer(INFO);
		}
		
		PrintWriter out = response.getWriter(); // ��ȡһ�������
		System.out.println("04" + data.getString("text"));// ������ݽ�����֤

		
		out.print(data);// ��������
		out.close();

	}
}

/*
 * �������� PrintWriter out=response.getWriter(); //��ȡһ������� if
 * (content.equals("1")){ //�ַ����Ƚ� String data1 ="{\"info\": \"��ඣ���\"}";
 * JSONObject job2=JSONObject.fromObject(data1); //���ַ���ת����json���ݸ�ʽ
 * System.out.println("04"+job2.getString("info"));//������ݽ�����֤
 * out.print(job2);//�������� return; } else if(content.equals("����˭")){ String
 * data2="{\"info\":\"����ӵ��ʮ����˿�Ĺ�����\"}"; JSONObject
 * job3=JSONObject.fromObject(data2);
 * System.out.println("05"+job3.getString("info")); out.print(job3);
 * out.flush(); //����������ǿ��д������ջ��� return; } else if(content.equals("���ʲô")){
 * String data3="{\"info\":\"�һ��������\"}"; JSONObject
 * job4=JSONObject.fromObject(data3);
 * System.out.println("05"+job4.getString("info")); out.print(job4); return;
 * }else{ String data4="{\"info\":\"��˵ʲô��\"}"; JSONObject
 * job4=JSONObject.fromObject(data4);
 * System.out.println("05"+job4.getString("info")); out.print(job4); return; }
 * 
 * }
 */

