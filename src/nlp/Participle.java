package nlp;

import dao.QDao;
import entity.QGreeting;

//分词
public class Participle {
	QDao ask = new QDao();
	QGreeting qGreeting = new QGreeting();
	public QGreeting getParticiple(String content){
		//导入词典，数据库进行导入
		String[] cs =  {"电视剧","影视","什么","新闻浏览","嗨","你好","快递查询","评价 "};//词典
		System.out.println(content+"npl");
		String[] cs2 = new String[100]; //结果数组
		int jud = 0; //找到匹配字符串与否的标志
		int j = 0;
		
		String temp =null; //初始化临时字符串
		
		for(;content.length()>0;){
			for(int i=0;i<content.length();i++){
				temp = content.substring(i);   //每次截取掉首个字符
				if(isin(cs,temp)==true){  //如果目标字符串在数据库中
					cs2[j] = temp;
					jud = 1;
					int number = temp.length();
					content = content.substring(0,content.length()-number);
				}
			}
			if(jud == 0){ //没有找到匹配字符串
				cs2[j] = content.substring(content.length()-1,content.length());   //将最后一个元素放在cs2里面
				content = content.substring(0,content.length()-1);  //截掉最后一个元素继续循环
			}
			jud = 0;
			j++;
		}
		for(;j>=0;j--){
			if(cs2[j] != null)
				System.out.println(cs2[j]+"  "+"npl1");
				//查找问题子类数据库
				qGreeting = ask.getQGreeting(cs2[j]);
		} 
		System.out.println(qGreeting.getQ_classification()+"class");
		System.out.println(qGreeting.getQ_greet()+"greet");
		return qGreeting;
	}
	
/*
	
	 * 下面为判断字符串是否在词典中的函数方法
	
	*/
	
	static public boolean isin(String[] cs,String temp)//判断目标字符串是否在对比字符串数组中
	{
		int i;
		for(i = 0;i<cs.length;)
		{
			if(temp.equals(cs[i]))
				i = cs.length+1;
			else
				i++;
		}
		if(i == cs.length+1)
			return true;
		else
			return false;
	}
  
}
