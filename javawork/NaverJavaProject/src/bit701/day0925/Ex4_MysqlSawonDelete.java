package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex4_MysqlSawonDelete {
	DbConnect db=new DbConnect();

	private void sawonDelete() {
		// TODO Auto-generated method stub
		// 사원명 입력후 해당 사원 삭제
		Scanner sc=new Scanner(System.in);
		System.out.print("삭제할 사원명 입력 : ");
		String name=sc.nextLine();
		String sql="delete from sawon where name='"+name+"'";
		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
		
		conn=db.getMySqlConnection();
		try {
			stmt=conn.createStatement();
			//실행 성공적으로 삭제된 갯수 반환
			int n=stmt.executeUpdate(sql);
			if(n==0)
				System.out.println(name+" 사원은 목록에 없습니다.");
			else
				System.out.println("총 "+n+"개의 "+name+" 사원정보를 삭제했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4_MysqlSawonDelete ex=new Ex4_MysqlSawonDelete();
		ex.sawonDelete();
	}



}
