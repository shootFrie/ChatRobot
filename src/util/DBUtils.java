package util;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;


	/*
	 *数据库连接类
	 */
	public class DBUtils {
			//加载数据库连接驱动
			//注册驱动
			static{
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			//获取数据库连接的方法
			private static Connection conn;
			public static Connection getConn() {
				String url = "jdbc:mysql://localhost:3306/copy_chat?characterEncoding=utf8";
				try {
					conn = DriverManager.getConnection(url, "root", "000000");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return conn;
			}
			
			//数据库关闭的方法
			public static void closeConnection(Connection connection){
				//判断连接是否为null
				if(connection !=null){
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			

		}
