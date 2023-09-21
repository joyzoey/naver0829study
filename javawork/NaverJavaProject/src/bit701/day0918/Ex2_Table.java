package bit701.day0918;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ex2_Table extends JFrame {
	
	JTable table1;
	
	JTable table2;

	public Ex2_Table(String title) {
		super(title);
		this.setBounds(800, 100, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료해주는 메서드
		this.setDesign();
		this.setVisible(true);

	}
	private void setDesign() {
		//table 2개를 넣기 위해 2행 1열로 레이아웃 변경
		this.setLayout(new GridLayout(2,1));
		
		//5행4열의 빈테이블 생성연습
		//table1=new JTable(5,4);//5행4열의 빈테이블이 만들어진다
		//this.add(table1);
		
		//테이블1
		//제목과 3개의 빈 행을 추가
		DefaultTableModel model = new DefaultTableModel(new String[] {"이름","나이","주소"},3);
		table1=new JTable(model);
		this.add(new JScrollPane(table1));//scroll이 가능하도록 만들어줘야 제목이 나옴
		
		
		//테이블2
		//제목과 3개의 데이터행을 추가
		String [][]data= {
				{"강부자","56","강남구"},
				{"이순재","67","여의도"},
				{"신구","56","제주도"}
		};
		table2=new JTable(data, new String[] {"이름","나이","주소"});
		this.add(new JScrollPane(table2));
		
		
	}
	public static void main(String[] args) {
		Ex2_Table ex=new Ex2_Table("JTable");
	}

}
