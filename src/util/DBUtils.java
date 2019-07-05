package util;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;


	/*
	 *���ݿ�������
	 */
	public class DBUtils {
			//�������ݿ���������
			//ע������
			static{
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			//��ȡ���ݿ����ӵķ���
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
			
			//���ݿ�رյķ���
			public static void closeConnection(Connection connection){
				//�ж������Ƿ�Ϊnull
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
