package bit701.day0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class Ex2_MysqlJdbc {

	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	
	public Ex2_MysqlJdbc() {
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("Mysql 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql 드라이버 오류:"+e.getMessage());
		}
	}
	
	public void sawonAllDatas()
	{
		Connection conn=null;
		
		Statement stmt=null;
	      ResultSet rs=null;//select일때에만 필요 db로 부터 데이터 가져올때 필요
	      String sql="select * from sawon order by num";
		
		
		try {
			conn=DriverManager.getConnection(MYSQL_URL, "root", "1234");
			//System.out.println("Mysql 연결 성공");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			//rs.next() : 다음데이터로 이동을 하고 true 반환, 이동할 데이터가 없을경우 false 반환
	         System.out.println("번호\t이름\t부서\t성별\t점수");
	         System.out.println("=".repeat(60));
	         int total=0;
	         int count=0;
	         double avg;
	         while(rs.next()) {
	            
	        	 String no=rs.getString("num");
	        	 String name=rs.getString("name");
	        	 int score=rs.getInt("score");
	        	 String gender=rs.getString("gender");
	        	 String buseo=rs.getString("buseo");
	        	 
	        	 total+=score;
	        	 count++;

	            System.out.println(no+"\t"+name+"\t"+buseo+"\t"+gender+"\t"+score);
	         }
	         avg=(double)total/count;
	         System.out.println("\n총금액:"+total);
	         System.out.printf("평균: %2.1f\n",avg);

			
		} catch (SQLException e) {
			System.out.println("Mysql 연결 실패 : "+e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2_MysqlJdbc ex=new Ex2_MysqlJdbc();
		ex.sawonAllDatas();
	}

}
