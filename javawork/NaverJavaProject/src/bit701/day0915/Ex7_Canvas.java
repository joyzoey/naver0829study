package bit701.day0915;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex7_Canvas  extends JFrame {
	
	MyCanvas myCanvas=new MyCanvas();

	public Ex7_Canvas(String title) {
		super(title);//JFrame 의 문자열을 받는 생성자 호출
		this.setLocation(300,100);//프레임의 시작위치
		this.setSize(500,700);//프레임의 너비, 높이
		//this.getContentPane().setBackground(Color.green);//color상수를 이용하여 변경
		//this.getContentPane().setBackground(new Color(250,218,72));//0~255의 rgb
		this.setVisible(true);//true : 프레임보이게,flase 프레임숨기기
		
		//디자인이나 이벤트를 구현할 메서드 호출
		this.setDesign();
		
		//윈도우 이벤트 발생 익명내부 클래스 형태로 이벤트 구현
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {//x버튼 클릭시 호출되는 메서드
				JOptionPane.showMessageDialog(Ex7_Canvas.this, "프레임을 종료합니다");
				//실제종료
				System.exit(0);//정상종료
				super.windowClosing(e);
			}
		
		});
	}
	
	//캔버스 내부클래스
	class MyCanvas extends Canvas
	{
		String imageIcon1="D:\\naver0829\\workstudy\\webwork\\이쁜동물이미지\\C7.png";
		
		@Override
		public void paint(Graphics g) {
				
			super.paint(g);
			
			//원그리기
			g.setColor(new Color(250,218,72));//색지정
			g.drawOval(50,50,100,100);//빈 원
			g.fillOval(200,50,100,100);//채운원
			
			//사각형그리기
			g.setColor(Color.pink);//색지정
			g.drawRect(50, 200, 100, 100);//빈사각형
			g.fillRect(200, 200, 100, 100);//채운사각형
			
			Image image1=new ImageIcon(imageIcon1).getImage();
			//이미지그리기
			g.drawImage(image1, 300,220, this);
			
			//크기변경
			g.drawImage(image1, 300, 30, 100, 100, this);
			
		}
	}
	
	private void setDesign() {
		// TODO Auto-generated method stub
		this.add(myCanvas,"Center");
	}

	public static void main(String[] args) {
		Ex7_Canvas s=new Ex7_Canvas("캔버스");
		
		
	}
}
