package bit701.day0915;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.DesignMode;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingGibon extends JFrame {

	public SwingGibon(String title) {
		super(title);//JFrame 의 문자열을 받는 생성자 호출
		this.setLocation(300,100);//프레임의 시작위치
		this.setSize(300,300);//프레임의 너비, 높이
		//this.getContentPane().setBackground(Color.green);//color상수를 이용하여 변경
		this.getContentPane().setBackground(new Color(250,218,72));//0~255의 rgb
		this.setVisible(true);//true : 프레임보이게,flase 프레임숨기기
		
		//디자인이나 이벤트를 구현할 메서드 호출
		this.setDesign();
		
		//윈도우 이벤트 발생 익명내부 클래스 형태로 이벤트 구현
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {//x버튼 클릭시 호출되는 메서드
				JOptionPane.showMessageDialog(SwingGibon.this, "프레임을 종료합니다");
				//실제종료
				System.exit(0);//정상종료
				super.windowClosing(e);
			}
		
		});
	}
	
	private void setDesign() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		SwingGibon s=new SwingGibon("안녕");
		
		
	}

}
