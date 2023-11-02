package myshop.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import mysql.db.DbConnect;

public class MyshopDao {
	DbConnect db=new DbConnect();

	//검색결과 출력
	public List<MyshopDto> getSearchSangpum(String search)
	{
		List<MyshopDto> list=new Vector<MyshopDto>();
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from myshop where sangpum like ? order by num";

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, "%"+search.trim()+"%");
			rs=pstmt.executeQuery();

			while(rs.next())
			{
				MyshopDto dto=new MyshopDto();//반드시 while문 안에 선언
				dto.setNum(rs.getInt("num"));
				dto.setSangpum(rs.getString("sangpum"));
				dto.setPrice(rs.getInt("price"));
				dto.setColor(rs.getString("color"));
				dto.setPhoto(rs.getString("photo"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				//list에 추가
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return list;
	}
	
	
	//전체 출력
	public List<MyshopDto> getAllSangpums()
	{
		List<MyshopDto> list=new Vector<MyshopDto>();
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from myshop order by num";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				MyshopDto dto=new MyshopDto();//반드시 while문 안에 선언
				dto.setNum(rs.getInt("num"));
				dto.setSangpum(rs.getString("sangpum"));
				dto.setPrice(rs.getInt("price"));
				dto.setColor(rs.getString("color"));
				dto.setPhoto(rs.getString("photo"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				//list에 추가
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	//insert
	public void insertShop(MyshopDto dto)
	{
		String sql="insert into myshop (sangpum,color,price,photo,writeday) values (?,?,?,?,now())";
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getSangpum());
			pstmt.setString(2, dto.getColor());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setString(4, dto.getPhoto());
			//실행
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//update
		public void updateShop(MyshopDto dto)
		{
			String sql="update myshop set sangpum=?,color=?,price=?,photo=?,writeday=now() where num=?";
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			
			try {
				pstmt=conn.prepareStatement(sql);
				//바인딩
				pstmt.setString(1, dto.getSangpum());
				pstmt.setString(2, dto.getColor());
				pstmt.setInt(3, dto.getPrice());
				pstmt.setString(4, dto.getPhoto());
				pstmt.setInt(5, dto.getNum());
				//실행
				pstmt.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.dbClose(pstmt, conn);
			}
			
		}
	
	//delete
	public void deleteShop(String num)
	{
		String sql="delete from myshop where num=?";
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, num);
			//실행
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//num에 해당하는 dto 반환
	public MyshopDto getSangpum(String num)
	{
		MyshopDto dto=new MyshopDto();
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from myshop where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1,num);
			//실행
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				dto.setNum(rs.getInt("num"));
				dto.setSangpum(rs.getString("sangpum"));
				dto.setPrice(rs.getInt("price"));
				dto.setColor(rs.getString("color"));
				dto.setPhoto(rs.getString("photo"));
				dto.setWriteday(rs.getTimestamp("writeday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return dto;
	}


}
