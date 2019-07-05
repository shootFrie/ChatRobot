package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtils;
import entity.QGreeting;
import entity.Response;

public class ResponseDao {
	private PreparedStatement ps;
	private Connection con = DBUtils.getConn();
	private String sql;
	
	//问题和答案对应
	public Response getAnswer(QGreeting qGreeting){
		Response response =  new Response();
		String q_classification = qGreeting.getQ_classification();
		sql = "SELECT * FROM question WHERE q_classification=?";
		System.out.println(q_classification+"5");
		try {
			ps = con.prepareStatement(sql); 
			ps.setString(1, q_classification);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("a_id")+"aa");
				response.setA_id(rs.getString("a_id"));
			}
			rs.close();
			ps.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(response.getA_id()+"a_di");
		if(response.getA_id()==null){
			return null;
		}else{
			return response;	
		}
	}
}
