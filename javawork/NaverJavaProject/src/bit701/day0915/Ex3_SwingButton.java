package bit701.day0915;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex3_SwingButton extends JFrame implements ActionListener {
	JButton btn1,btn2;
	
	@Override
	public void actionPerformed (ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn1) {
			System.out.println("버튼1 클릭");
			this.getContentPane().setBackground(Color.yellow);
		}
		else {
			System.out.println("버튼 2 클릭");
			this.getContentPane().setBackground(Color.cyan);
		}

	}
	
	public Ex3_SwingButton(String title) {
		super(title);//JFrame 의 문자열을 받는 생성자 호출
		this.setLocation(300,100);//프레임의 시작위치
		this.setSize(300,300);//프레임의 너비, 높이
		//this.getContentPane().setBackground(Color.green);//color상수를 이용하여 변경
		this.getContentPane().setBackground(new Color(250,218,72));//0~255의 rgb
		
		//디자인이나 이벤트를 구현할 메서드 호출
		this.setDesign();
		this.setVisible(true);//true : 프레임보이게,flase 프레임숨기기

		
		//윈도우 이벤트 발생 익명내부 클래스 형태로 이벤트 구현
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {//x버튼 클릭시 호출되는 메서드
				JOptionPane.showMessageDialog(Ex3_SwingButton.this, "프레임을 종료합니다");
				//실제종료
				System.exit(0);//정상종료
				super.windowClosing(e);
			}
		
		});
	}
	
	private void setDesign() {

		//버튼1추가
		btn1=new JButton("버튼#1");//버튼생성
		this.add(btn1,"North");//프레임에 추가
			//BorderLayout(기본)인경우 위치를 지정해야함
			//North,South,East,West,Center
		
		//버튼2추가
		btn2=new JButton("버튼#2");	
		this.add(btn2,"South");
		
		//버튼 12에 이벤트 발생
		btn1.addActionListener(this);//()의 this는 이벤트 메서드가 구현된 클래스의 인스턴스
		btn2.addActionListener(this);//둘다 같은 이벤트 메서드가 호출
	}

	public static void main(String[] args) {
		Ex3_SwingButton s=new Ex3_SwingButton("버튼");
		
		
	}

}
