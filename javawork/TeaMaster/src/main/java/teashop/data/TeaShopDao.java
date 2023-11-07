package teashop.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import mysql.db.DbConnect;

public class TeaShopDao {
		DbConnect db=new DbConnect();

		//전체 출력
		public List<TeaShopDto> getAllproducts()
		{
			List<TeaShopDto> list=new Vector<TeaShopDto>();
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String sql="select * from teashop order by num";
			
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					TeaShopDto dto=new TeaShopDto();//반드시 while문 안에 선언
					dto.setNum(rs.getInt("num"));
					dto.setProduct(rs.getString("product"));
					dto.setTeatype(rs.getString("teatype"));
					dto.setPrice(rs.getInt("price"));
					dto.setAmount(rs.getInt("amount"));
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
		public void insertShop(TeaShopDto dto)
		{
			String sql="insert into teashop (product,teatype,price,amount,photo,writeday) values (?,?,?,?,?,now())";
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			
			try {
				pstmt=conn.prepareStatement(sql);
				//바인딩
				pstmt.setString(1, dto.getProduct());
				pstmt.setString(2, dto.getTeatype());
				pstmt.setInt(3, dto.getPrice());
				pstmt.setInt(4, dto.getAmount());
				pstmt.setString(5, dto.getPhoto());
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
			public void updateShop(TeaShopDto dto)
			{
				String sql="update teashop set product=?,teatype=?,price=?,amount=?,photo=?,writeday=now() where num=?";
				Connection conn=db.getConnection();
				PreparedStatement pstmt=null;
				
				try {
					pstmt=conn.prepareStatement(sql);
					//바인딩
					pstmt.setString(1, dto.getProduct());
					pstmt.setString(2, dto.getTeatype());
					pstmt.setInt(3, dto.getPrice());
					pstmt.setInt(4, dto.getAmount());
					pstmt.setString(5, dto.getPhoto());
					pstmt.setInt(6, dto.getNum());
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
			String sql="delete from teashop where num=?";
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
		public TeaShopDto getproduct(String num)
		{
			TeaShopDto dto=new TeaShopDto();
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String sql="select * from teashop where num=?";
			
			try {
				pstmt=conn.prepareStatement(sql);
				//바인딩
				pstmt.setString(1,num);
				//실행
				rs=pstmt.executeQuery();
				
				if(rs.next())
				{
					dto.setNum(rs.getInt("num"));
					dto.setProduct(rs.getString("product"));
					dto.setTeatype(rs.getString("teatype"));
					dto.setPrice(rs.getInt("price"));
					dto.setAmount(rs.getInt("amount"));
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
		
		//검색결과 출력
		public List<TeaShopDto> getSearchproduct(String search)
		{
			List<TeaShopDto> list=new Vector<TeaShopDto>();
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			String sql="select * from teashop where product like ? order by num";

			try {
				pstmt=conn.prepareStatement(sql);
				//바인딩
				pstmt.setString(1, "%"+search.trim()+"%");
				rs=pstmt.executeQuery();

				while(rs.next())
				{
					TeaShopDto dto=new TeaShopDto();//반드시 while문 안에 선언
					dto.setNum(rs.getInt("num"));
					dto.setProduct(rs.getString("product"));
					dto.setTeatype(rs.getString("teatype"));
					dto.setPrice(rs.getInt("price"));
					dto.setAmount(rs.getInt("amount"));
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

	
	
}
