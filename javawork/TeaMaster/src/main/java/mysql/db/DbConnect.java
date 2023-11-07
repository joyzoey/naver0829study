package mysql.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnect {
	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	//static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";

	//원격 mysql url
	static final String MYSQL_URL = "jdbc:mysql://db-jbo6i-kr.vpc-pub-cdb.ntruss.com:3306/studydb?serverTimezone=Asia/Seoul";
	
	public DbConnect() {
		
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Mysql 드라이버 오류:"+e.getMessage());
		}
	}
	
	public Connection getConnection()
	{
		Connection conn=null;
		try {
			//local 연결
			//conn=DriverManager.getConnection(MYSQL_URL, "root", "1234");
			
			//원격 연결
			conn=DriverManager.getConnection(MYSQL_URL, "study", "bitcamp123!@#");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Mysql Local 연결실패:"+e.getMessage());
		}
		return conn;
	}
	
	public void dbClose(PreparedStatement pstmt, Connection conn)
	{
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn)
	{
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
	}

}
