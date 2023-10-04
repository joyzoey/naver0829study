package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex2_MysqlSawonInsert {
	DbConnect db=new DbConnect();
	
	public void sawonInsert()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("이름:");
		String name=sc.nextLine();
		System.out.print("1-100사이 점수:");
		int scores=Integer.parseInt(sc.nextLine());
		System.out.print("성별:");
		String gender=sc.nextLine();
		System.out.print("부서:");
		String buseo=sc.nextLine();
		
		String sql="insert into sawon values (null,'"+name+"', "+scores+", '"+gender+"', '"+buseo+"')";
		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
		conn=db.getMySqlConnection();
		try {
			stmt=conn.createStatement();
			//실행
			stmt.execute(sql);
			System.out.println("사원이 추가되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2_MysqlSawonInsert ex=new Ex2_MysqlSawonInsert();
		ex.sawonInsert();
	}

}
