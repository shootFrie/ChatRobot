package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;




import util.DBUtils;
import entity.AGreeting;
import entity.Response;

public class CheckDao {
	private PreparedStatement ps;
	private PreparedStatement ps2;
	private Connection con = DBUtils.getConn();
	private String sql;
	private String sql2;

	// 获取相应a_id的回答
	public String getAGreeting(Response response) { // 形参a_id
		sql = "SELECT * FROM answer WHERE a_id=?";
		sql2 = "SELECT * FROM a_greeting WHERE a_classification=?";
		List<AGreeting> list= new ArrayList<AGreeting>();
		try {
			ps = con.prepareStatement(sql); 
			ps2 = con.prepareCall(sql2);
			ps.setString(1, response.getA_id());
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				ps2.setString(1, rs.getString("a_classification"));
				System.out.println(rs.getString("a_classification")+"++checkdao");
				ResultSet rs2=ps2.executeQuery();
				while (rs2.next()) {
					AGreeting aGreeting = new AGreeting(
							rs2.getString("a_specific"));
					list.add(aGreeting);
					
					System.out.println(list.get(0).getA_greet()+"+1"); //验证
					
				}
				rs2.close();
				ps2.close();
			}
			rs.close();
			ps.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeConnection(con);
		}
		
		Random r = new Random(); 
		int[] array = {0,1,2};
		int index = array[r.nextInt(3)];
		AGreeting a_greet = list.get(index);
		System.out.println(a_greet+"AGreeting对象");
		System.out.println(a_greet.getA_greet()+"+2");
		return  a_greet.getA_greet();

	}
}
//Random r = new Random(); 
//ran =array[r.nextInt(3)];
