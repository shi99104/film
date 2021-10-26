package film;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionFactory {
	private static ConnectionFactory cFactory = new ConnectionFactory();
	private ConnectionFactory(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("���������쳣��");
		}
}
	public static Connection createConnection(){
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
		try {
			conn = DriverManager.getConnection(url, "root", "123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("���ݿ������쳣");
		}
		return conn;
	}
	public static void close(Connection conn){
		if(conn !=null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("���ݿ�ر�ʧ�ܣ�");
			}
	}
	public static void close(Statement stmt){
		if(stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("������ر�ʧ�ܣ�");
			}
	}
	public static void close(ResultSet rs){
		if(rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("������ر�ʧ�ܣ�");
			}
	}
/*	public static void main(String args[])
	{
		cFactory.createConnection();
	}*/
}
