package bit701.day0925;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex3_OracleShopDelete {
	DbConnect db=new DbConnect();

	private void shopDelet() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("삭제할 상품명 입력 : ");
		String sang=sc.nextLine();
		String sql="delete from shop where sang_name='"+sang+"'";
		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
		
		conn=db.getOracleConnection();
		try {
			stmt=conn.createStatement();
			//실행 성공적으로 삭제된 갯수 반환
			int n=stmt.executeUpdate(sql);
			if(n==0)
				System.out.println(sang+" 상품은 목록에 없습니다.");
			else
				System.out.println("총 "+n+"개의 "+sang+" 상품을 삭제했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3_OracleShopDelete ex=new Ex3_OracleShopDelete();
		ex.shopDelet();
	}

}
