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

import net.sf.json.JSONObject;//json数据需要的jar包

import java.net.URLEncoder;

/**
 * 发送接收信息，传入发送信息，得到Json数据，
 */
@WebServlet("/Receive")
public class Receive extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");  //设置编码格式
		response.setContentType("application/json"); // 请求类型为就是json
		String content = request.getParameter("content");// 获取post方法传递的值，content是问题

		String INFO = URLEncoder.encode(content, "utf-8"); // 把content编码成utf-8
		
		System.out.println(content);
		
		
		DBService dbService = new DBService();
		JSONObject data = new JSONObject();
		if(dbService.getDBus(content) != null){
			data = dbService.getDBus(content);
			System.out.println(data+"03");
		}else{
			// 取得输入流，并使用Reader读取
			//图灵机器人api连接
			Turing conn = new Turing();
			data = conn.getAnswer(INFO);
		}
		
		PrintWriter out = response.getWriter(); // 获取一个输出流
		System.out.println("04" + data.getString("text"));// 输出数据进行验证

		
		out.print(data);// 传出数据
		out.close();

	}
}

/*
 * 单个返回 PrintWriter out=response.getWriter(); //获取一个输出流 if
 * (content.equals("1")){ //字符串比较 String data1 ="{\"info\": \"哈喽！！\"}";
 * JSONObject job2=JSONObject.fromObject(data1); //将字符串转换成json数据格式
 * System.out.println("04"+job2.getString("info"));//输出数据进行验证
 * out.print(job2);//传出数据 return; } else if(content.equals("你是谁")){ String
 * data2="{\"info\":\"我是拥有十万软丝的鬼赞赞\"}"; JSONObject
 * job3=JSONObject.fromObject(data2);
 * System.out.println("05"+job3.getString("info")); out.print(job3);
 * out.flush(); //缓冲区内容强制写出，清空缓存 return; } else if(content.equals("你会什么")){
 * String data3="{\"info\":\"我会和你聊天\"}"; JSONObject
 * job4=JSONObject.fromObject(data3);
 * System.out.println("05"+job4.getString("info")); out.print(job4); return;
 * }else{ String data4="{\"info\":\"你说什么？\"}"; JSONObject
 * job4=JSONObject.fromObject(data4);
 * System.out.println("05"+job4.getString("info")); out.print(job4); return; }
 * 
 * }
 */

