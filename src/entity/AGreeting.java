package entity;

public class AGreeting {
	private String a_greet; //�ش�
	private String a_classification;  //��ȡ�ش�id

	public AGreeting(String a_greet) {
		this.setA_greet(a_greet);
	}

	public String getA_classification() {
		return a_classification;
	}


	public void setA_classification(String a_classification) {
		this.a_classification = a_classification;
	}


	public String getA_greet() {
		return a_greet;
	}




	public void setA_greet(String a_greet) {
		this.a_greet = a_greet;
	}

}
