package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.QGreeting;
import util.DBUtils;

public class QDao {
	private PreparedStatement ps;
	private Connection con = DBUtils.getConn();
	private String sql;
	
	//得到问题
	public QGreeting getQGreeting(String q_greet){
		QGreeting qGreeting = new QGreeting();
		System.out.println(q_greet+"+222");
		sql ="select * from q_greeting where q_greet=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, q_greet);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				qGreeting.setQ_classification(rs.getString("q_classification"));
				qGreeting.setQ_greet(rs.getString("q_greet"));
			}
			rs.close();
			ps.close();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return qGreeting;   //返回对象
	}
}
