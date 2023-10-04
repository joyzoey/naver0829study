package bit701.day0925;

import java.nio.file.spi.FileSystemProvider;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DbConnect;

public class Ex1_OracleShopInsert {
	DbConnect db=new DbConnect();
	
	public void shopInsert()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("상품명 입력 : ");
		String sang=sc.nextLine();
		
		System.out.print("가격 입력 : ");
		int price = Integer.parseInt(sc.nextLine());
		
		System.out.print("색상 입력 : ");
		String color=sc.nextLine();
		
		String sql="insert into shop values (seq_shop.nextval,'"+sang+"', "+price+", '"+color+"')";
		System.out.println(sql);
		
		Connection conn=null;
		Statement stmt=null;
		
		//db연결
		conn=db.getOracleConnection();
		//Statement 생성
		try {
			stmt=conn.createStatement();
			
			//실행
			
			//만약에 stmt 실행여부를 확인하고 싶다면
//			boolean b=stmt.execute(sql);//반환타입 bolean,select일때만 true, 실행결과가 없을경우 false반환
//			int n=stmt.executeUpdate(sql);//반환타입 int, sql을 성공한 갯수
//			System.out.println(b+", "+n);
			
			//아닐땐 그냥 실행만
			stmt.execute(sql);
			System.out.println("shop에 데이타 추가됨");
			
		} catch (SQLException e) {
			System.out.println("insert sql문 오류:"+e.getMessage());
		} finally {
			db.dbClose (stmt, conn);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1_OracleShopInsert ex=new Ex1_OracleShopInsert();
		ex.shopInsert();
	}

}
