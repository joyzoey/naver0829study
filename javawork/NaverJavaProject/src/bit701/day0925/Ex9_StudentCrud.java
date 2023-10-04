package bit701.day0925;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import db.DbConnect;

public class Ex9_StudentCrud {
      DbConnect db = new DbConnect();
      Scanner scan = new Scanner(System.in);
      PreparedStatement ps = null;
      
      public void selectAll() {
         Connection conn = db.getMySqlConnection();
         String query = "select * from student";
         ResultSet rs = null;
         
         int total = 0;
         
         try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()) {
               int num = rs.getInt("num");
               String name = rs.getString("name");
               String blood = rs.getString("blood");
               String phone = rs.getString("phone");
               Date writeday = new Date();
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
               String day = sdf.format(writeday);
               total++;
               System.out.println(num + "  " + name + "  " + blood + "  " + phone + "  " + day);
            }
            System.out.println(total + "개의 조회 결과가 있습니다.");
            
         } catch (SQLException e) {
            System.out.println(e.getMessage());
         } finally {
        	 db.dbClose(rs, ps, conn);
         }
         
      }
      public void insertAll() {
         Connection conn = db.getMySqlConnection();
         String query = "insert into student values"
               + "(null, ?, ?, ?, NOW())";
         
         System.out.print("이름 : ");
         String name = scan.nextLine();

         System.out.print("혈액형 : ");
         String blood = scan.nextLine();
         blood = blood.toUpperCase();

         System.out.print("전화번호 : ");
         String phone = scan.nextLine();

         try {
            ps = conn.prepareStatement(query);
            
            ps.setString(1, name);
            ps.setString(2, blood);
            ps.setString(3, phone);
            
            ps.execute();
            System.out.println("학생 정보가 추가되었습니다.");
         } catch (SQLException e) {
            System.out.println(e.getMessage());
         } finally {
            db.dbClose(ps, conn);
         }
      }
      
   //   num
   //   name
   //   blood
   //   phone
   //   writeday
      public void deleteAll() {
         System.out.print("삭제 학생명 : ");
         String name = scan.nextLine();
         
         String query = "delete from student where name = ?";
         Connection conn = db.getMySqlConnection();
         
         try {
            ps = conn.prepareStatement(query);
            
            ps.setString(1, name);
            
            int n = ps.executeUpdate();
            System.out.println(n + "개의 정보가 삭제되었습니다.");
         } catch (SQLException e) {
            System.out.println(e.getMessage());
         } finally {
            db.dbClose(ps, conn);
         }
      }
      

      public void updateAll() {
         Connection conn = db.getMySqlConnection();
         
         String query = "update student set name = ?, blood = ?, phone = ? where num = ?";
         
         System.out.print("수정할 ID : ");
         int num = Integer.valueOf(scan.nextLine());
         
         System.out.print("수정 이름 : ");
         String name = scan.nextLine();
         
         System.out.print("수정 혈액형 : ");
         String blood = scan.nextLine();
         
         System.out.print("수정 전화번호 : ");
         String phone = scan.nextLine();
         
         try {
            ps = conn.prepareStatement(query);
            
            ps.setString(1, name);
            ps.setString(2, blood);
            ps.setString(3, phone);
            ps.setInt(4, num);
            
            int n = ps.executeUpdate();
            System.out.println(n + "개의 정보가 수정되었습니다.");
         } catch (SQLException e) {
            System.out.println(e.getMessage());
         } finally {
            db.dbClose(ps, conn);
         }
      }
      
      public void searchPhone() {
         Connection conn = db.getMySqlConnection();
         System.out.print("검색 번호 : ");
         String search = scan.nextLine();
         
         String query = "select * from student where phone like ?";
         ResultSet rs = null;
         
         int total = 0;
         
         try {
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();
            while(rs.next()) {
               int num = rs.getInt("num");
               String name = rs.getString("name");
               String blood = rs.getString("blood");
               String phone = rs.getString("phone");
               Date writeday = new Date();
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
               String day = sdf.format(writeday);
               total++;
               System.out.println(num + "  " + name + "  " + blood + "  " + phone + "  " + day);
            }
            System.out.println(total + "개의 조회 결과가 있습니다.");
            
         } catch (SQLException e) {
            System.out.println(e.getMessage());
         } finally {
            db.dbClose(rs, ps, conn);
         }
         
      }
      
      public int getMenu() {
         int result = 0;

         System.out.println("1. 추가  2. 삭제  3. 수정  4. 조회  5. 검색 6.종료");
         System.out.print("번호 입력 : ");
         result = Integer.valueOf(scan.nextLine());

         return result;
      }
      
      public static void main(String[] args) {
         Ex9_StudentCrud ex = new Ex9_StudentCrud();
         
         while (true) {
            int menu = ex.getMenu();

            switch (menu) {
            case 1:
               ex.insertAll();
               break;
            case 2:
               ex.deleteAll();
               break;
            case 3:
               ex.updateAll();
               break;
            case 4:
               ex.selectAll();
               break;
            case 5:
               ex.searchPhone();
               break;
            default:
               System.out.println("시스템 종료!!");
               System.exit(0);
            } 

            System.out.println("-".repeat(50));
         }
      }


}