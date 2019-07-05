package service;

/*�ִ�֮����Ҵ𰸣����ش�json����*/

import net.sf.json.JSONObject;
import nlp.Participle;
import dao.CheckDao;
import dao.ResponseDao;
import entity.Response;

public class DBService {
	public JSONObject getDBus(String content){
		Participle par = new Participle();//�ִ�
		ResponseDao ask  = new ResponseDao();
		if(ask.getAnswer(par.getParticiple(content)) ==null){
			return null;
		}else{
			Response res =  ask.getAnswer(par.getParticiple(content));  
			
			//�ӷִ��д��ݵ�QGreeting����ת��ResponseDao��ȡResponse����
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
