package nlp;

import dao.QDao;
import entity.QGreeting;

//�ִ�
public class Participle {
	QDao ask = new QDao();
	QGreeting qGreeting = new QGreeting();
	public QGreeting getParticiple(String content){
		//����ʵ䣬���ݿ���е���
		String[] cs =  {"���Ӿ�","Ӱ��","ʲô","�������","��","���","��ݲ�ѯ","���� "};//�ʵ�
		System.out.println(content+"npl");
		String[] cs2 = new String[100]; //�������
		int jud = 0; //�ҵ�ƥ���ַ������ı�־
		int j = 0;
		
		String temp =null; //��ʼ����ʱ�ַ���
		
		for(;content.length()>0;){
			for(int i=0;i<content.length();i++){
				temp = content.substring(i);   //ÿ�ν�ȡ���׸��ַ�
				if(isin(cs,temp)==true){  //���Ŀ���ַ��������ݿ���
					cs2[j] = temp;
					jud = 1;
					int number = temp.length();
					content = content.substring(0,content.length()-number);
				}
			}
			if(jud == 0){ //û���ҵ�ƥ���ַ���
				cs2[j] = content.substring(content.length()-1,content.length());   //�����һ��Ԫ�ط���cs2����
				content = content.substring(0,content.length()-1);  //�ص����һ��Ԫ�ؼ���ѭ��
			}
			jud = 0;
			j++;
		}
		for(;j>=0;j--){
			if(cs2[j] != null)
				System.out.println(cs2[j]+"  "+"npl1");
				//���������������ݿ�
				qGreeting = ask.getQGreeting(cs2[j]);
		} 
		System.out.println(qGreeting.getQ_classification()+"class");
		System.out.println(qGreeting.getQ_greet()+"greet");
		return qGreeting;
	}
	
/*
	
	 * ����Ϊ�ж��ַ����Ƿ��ڴʵ��еĺ�������
	
	*/
	
	static public boolean isin(String[] cs,String temp)//�ж�Ŀ���ַ����Ƿ��ڶԱ��ַ���������
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
