package bit701.day0926;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import db.DbConnect;

public class Ex2_SawonSwingCRUD2 extends JFrame {
	JTextField tfName, tfScore;
	JComboBox<String> cbGender, cbBuseo;
	JTable table;
	DefaultTableModel tableModel;
	JButton btnAdd,btnDel,btnSearch,btnAll;
	DbConnect db= new DbConnect();	
	
	public Ex2_SawonSwingCRUD2() {
		super("사원관리");
		this.setBounds(600,200,500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
	}
	
	private void setDesign() {
		// TODO Auto-generated method stub
		tfName=new JTextField(4);
		tfScore=new JTextField(10);
		String []cbTitle1= {"여자","남자"};
		cbGender=new JComboBox<String>(cbTitle1);
		String []cbTitle2= {"홍보부","교육부","인사부","영업부"};
		cbBuseo=new JComboBox<String>(cbTitle2);
		
		JPanel pTop=new JPanel();
		pTop.add(new JLabel("이름"));
		pTop.add(tfName);
		pTop.add(new JLabel("점수"));
		pTop.add(tfScore);
		pTop.add(new JLabel("성별"));
		pTop.add(cbGender);
		pTop.add(new JLabel("부서"));
		pTop.add(cbBuseo);
		
		this.add("North",pTop);
		
		//하단
		btnAdd=new JButton("추가");
		btnDel=new JButton("삭제");
		btnSearch=new JButton("검색");
		btnAll=new JButton("전체조회");
		
		JPanel pBottom=new JPanel();
		pBottom.add(btnAdd);
		pBottom.add(btnDel);
		pBottom.add(btnSearch);
		pBottom.add(btnAll);
		
		//버튼 이벤트
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//데이타를 가져온다
				String name=tfName.getText();
				
				String gender=(String)cbGender.getSelectedItem();
				String buseo=(String)cbBuseo.getSelectedItem();
				//이름이나 전화번호 입력을 안한 경우 종료
				if(name.length()==0) {
					JOptionPane.showMessageDialog(Ex2_SawonSwingCRUD2.this, "이름을 입력해주세요.");
					return;
				}
				int score=0;
				try {
					score=Integer.parseInt(tfScore.getText());
				}catch(NumberFormatException e1) {
					score=0;//점수에 문자를 넣으면 그냥 0점으로
				}
				
				if(score<0 || score>100) {
					JOptionPane.showMessageDialog(Ex2_SawonSwingCRUD2.this, "점수는 0-100사이로 입력해주세요.");
					return;
				}
				//db에 insert하는 메서드 호출
				insertSawon (name,score,gender,buseo);
				//db로 부터 다시 데이터를 가져와서 출력
				sawonSelectAll();
				//입력값초기화
				tfName.setText("");
				tfScore.setText("");
			}
		});
		//삭제
		btnDel.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//선택한 행번호를 얻는다
				int row=table.getSelectedRow();
				//System.out.println(row);
				if(row==-1)
				{
					JOptionPane.showMessageDialog(Ex2_SawonSwingCRUD2.this, "삭제할 행을 선택해주세요.");
				} else {
					//row행의 0이 num값
					String num=table.getValueAt(row, 0).toString();
					deleteSawon(num);
					//삭제 후 데이터 다시 불러오기
					sawonSelectAll();
				}
				
			}
		});
		//조회
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String searchBuseo=JOptionPane.showInputDialog("검색할 부서명을 입력하세요");
				//System.out.println(searchName);
				if(searchBuseo==null)
					return; //취소누를경우 메서드 종료
				else
					searchSawon(searchBuseo);//이름이 포함된 모든 데이터 테이블에 출력;
			}

		});
		//전체조회
		btnAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sawonSelectAll();
			}
		});
		
		this.add("South",pBottom);
		
		//Center Table
		String []title= {"번호","이름","점수","성별","부서"};
		tableModel=new DefaultTableModel(title,0);
		table=new JTable(tableModel);
		this.add("Center",new JScrollPane(table));
		
		//초기 db데이타 가져오기
		sawonSelectAll();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2_SawonSwingCRUD2 ex=new Ex2_SawonSwingCRUD2();
	}
	
	//db method
	//db에서 전체 데이타를 가져와서 테이블에 출력하는 메서드
	public void sawonSelectAll()
	{
		tableModel.setRowCount(0);
		
		Connection conn=db.getMySqlConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from sawon order by num desc";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				Vector<String> data=new Vector<String>();
				String num=rs.getString("num");
				String name=rs.getString("name");
				String score=rs.getString("score");
				String gender=rs.getString("gender");
				String buseo=rs.getString("buseo");
				
				//Vector에 추가한다.
				data.add(num);
				data.add(name);
				data.add(score);
				data.add(gender);
				data.add(buseo);
				
				//테이블에 추가
				tableModel.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs,pstmt,conn);
		}
		
	}

	//db에 추가
	public void insertSawon(String name,int score,String gender,String buseo)
	{
		
		Connection conn=db.getMySqlConnection();
		PreparedStatement pstmt=null;
		String sql="insert into sawon values (null,?,?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			//? 4개 바인딩
			pstmt.setString(1, name);
			pstmt.setInt(2, score);
			pstmt.setString(3, gender);
			pstmt.setString(4, buseo);
			//실행
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//db삭제하는 메서드
	public void deleteSawon(String num)
	{
		//System.out.println(num);
		Connection conn=db.getMySqlConnection();
		PreparedStatement pstmt=null;
		String sql="delete from sawon where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			//1개 바이딩
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
	
	//이름이 포함된 모든 데이터 테이블에 출력;
	public void searchSawon(String searchBuseo) {
		// TODO Auto-generated method stub
		tableModel.setRowCount(0);
		
		Connection conn=db.getMySqlConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from sawon where buseo like ?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, searchBuseo);
			//실행
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				Vector<String> data=new Vector<String>();
				String num=rs.getString("num");
				String name=rs.getString("name");
				String score=rs.getString("score");
				String gender=rs.getString("gender");
				String buseo=rs.getString("buseo");
				
				//Vector에 추가한다.
				data.add(num);
				data.add(name);
				data.add(score);
				data.add(gender);
				data.add(buseo);
				
				//테이블에 추가
				tableModel.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs,pstmt,conn);
		}
		
			
	}
	
}
