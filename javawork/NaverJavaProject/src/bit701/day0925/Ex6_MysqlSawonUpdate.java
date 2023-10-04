package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex6_MysqlSawonUpdate {
	DbConnect db = new DbConnect();
	
	private void sawonUpdate() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("수정할 사원 번호는?");
		String num=sc.nextLine();
		System.out.print("수정할 이름은?");
		String name=sc.nextLine();
		System.out.print("수정할 점수는?");
		int score=Integer.parseInt(sc.nextLine());
		System.out.print("수정할 부서이름은?");
		String buseo=sc.nextLine();
		
		String sql="update sawon set name='"+name+"',score="+score+",buseo='"+buseo+"' where num="+num;
		System.out.println(sql);

		Connection conn=null;
		Statement stmt=null;
		conn=db.getMySqlConnection();
		
		try {
			stmt=conn.createStatement();
			int n=stmt.executeUpdate(sql);
			if(n==0)
				System.out.println("해당 사원이 없습니다");
			else
				System.out.println("사원정보를 수정하였습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex6_MysqlSawonUpdate ex=new Ex6_MysqlSawonUpdate();
		ex.sawonUpdate();
	}

	

}
