package inquireboard.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import mysql.db.DbConnect;

public class InquireBoardDao {
	DbConnect db= new DbConnect();
	
	//목록
		public List<InquireBoardDto> getAllList()
		{
			List<InquireBoardDto> list=new Vector<InquireBoardDto>();
			String sql="select * from inquireboard order by num desc";
			
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs= null;
			
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					InquireBoardDto dto=new InquireBoardDto();
					
					dto.setNum(rs.getString("num"));
					dto.setWriter(rs.getString("writer"));
					dto.setPhone(rs.getString("phone"));
					dto.setMail(rs.getString("mail"));
					dto.setSubject(rs.getString("subject"));
					dto.setContent(rs.getString("content"));
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
		public void insertBoard(InquireBoardDto dto)
		{
			String sql="""
					insert into inquireboard (writer,phone,mail,subject,content,writeday)
					values (?,?,?,?,?,now())
					""";
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			
			try {
				pstmt=conn.prepareStatement(sql);
				//바인딩
				pstmt.setString(1, dto.getWriter());
				pstmt.setString(2, dto.getPhone());
				pstmt.setString(3, dto.getMail());
				pstmt.setString(4, dto.getSubject());
				pstmt.setString(5, dto.getContent());
				
				pstmt.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.dbClose(pstmt, conn);
			}
			
			
		}
		
		//내용보기
		public InquireBoardDto getDate(String num)
		{
			InquireBoardDto dto=new InquireBoardDto();
			String sql="select * from inquireboard where num=?";
			
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			try {
				pstmt=conn.prepareStatement(sql);
				//바인딩
				pstmt.setString(1,num);
				//실행
				rs=pstmt.executeQuery();
				
				if(rs.next())
				{
					dto.setNum(rs.getString("num"));
					dto.setWriter(rs.getString("writer"));
					dto.setPhone(rs.getString("phone"));
					dto.setMail(rs.getString("mail"));
					dto.setSubject(rs.getString("subject"));
					dto.setContent(rs.getString("content"));
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
		
		//삭제
		public void deleteBoard (String num)
		{
			String sql="delete from inquireboard where num=?";
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
	
}
