package service;

/*分词之后查找答案，返回答案json数组*/

import net.sf.json.JSONObject;
import nlp.Participle;
import dao.CheckDao;
import dao.ResponseDao;
import entity.Response;

public class DBService {
	public JSONObject getDBus(String content){
		Participle par = new Participle();//分词
		ResponseDao ask  = new ResponseDao();
		if(ask.getAnswer(par.getParticiple(content)) ==null){
			return null;
		}else{
			Response res =  ask.getAnswer(par.getParticiple(content));  
			
			//从分词中传递的QGreeting对象，转到ResponseDao获取Response对象
			CheckDao dao = new CheckDao();
			String info = dao.getAGreeting(res);
			if(info  != null){
				String data="{\"text\":\""+info+"\"}";
				JSONObject job=JSONObject.fromObject(data);
				System.out.println(job+"++job");
				return job;
			}else{
				return null;
			}
		}
	}
}
