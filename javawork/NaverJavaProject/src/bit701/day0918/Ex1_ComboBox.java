package bit701.day0918;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.w3c.dom.css.RGBColor;

public class Ex1_ComboBox extends JFrame {

	JPanel p=new JPanel();
	JComboBox<String> combo;
	JRadioButton rbYellow,rbMagenta,rbGray,rbBlue;
	JLabel lblMessage;
	
	public Ex1_ComboBox(String title) {
		super(title);
		this.setBounds(800, 100, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료해주는 메서드
		this.setDesign();
		this.setVisible(true);

	}
	private void setDesign() {
		Vector<String> list=new Vector<String>();
		list.add("빨강");
		list.add("초록");
		list.add("노랑");
		list.add("분홍");
		
		//콤보박스 생성
		combo=new JComboBox<String>(list);
		//상단에 추가
		//this.add("North",combo);//상단전체에추가
		JPanel pTop=new JPanel();
		pTop.add(combo);
		this.add("North",pTop);
		
		//p패널에 라벨추가
		lblMessage=new JLabel("Have a Nice Day!!!");
		lblMessage.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		p.add(lblMessage);
		
		//Center에 Jpanel p를 추가
		p.setBackground(Color.red);
		this.add("Center",p);
		
		
		//콤보박스 이벤트
		combo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				//선택한 문자열을 얻어보자
				String selectColor=(String)combo.getSelectedItem();
				//System.out.println(selectColor);
				//jdk부터 switch에서 String가능
				switch(selectColor) {
					case"빨강":
						p.setBackground(Color.red);
						break;
					case"초록":
						p.setBackground(new Color(34,177,76));
						break;
					case"노랑":
						p.setBackground(Color.yellow);
						break;
					case"분홍":
						p.setBackground(Color.pink);
						break;
				}
				
				
			}
		});
		
		//하단에 4개의 라디오버튼 추가하기
		ButtonGroup bg=new ButtonGroup();
		rbYellow=new JRadioButton("노랑");
		rbBlue=new JRadioButton("파랑");
		rbMagenta=new JRadioButton("핫핑");
		rbGray=new JRadioButton("회색");
		
		//라디오버튼들을 같은 그룹으로 붂기
		bg.add(rbYellow);
		bg.add(rbBlue);
		bg.add(rbMagenta);
		bg.add(rbGray);
		
		
		//4개의 라디오버튼을 일단 패널에 묶어서 넣은후 프레임 추가
		JPanel pBottom=new JPanel();
		pBottom.add(rbYellow);
		pBottom.add(rbBlue);
		pBottom.add(rbMagenta);
		pBottom.add(rbGray);
		
		this.add("South",pBottom);
		
		//글자색 변경 이벤트
		rbYellow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setForeground(new Color(178,168,11));
			}
		});
		rbBlue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setForeground(new Color(63,72,204));
			}
		});
		rbMagenta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setForeground(Color.magenta);
			}
		});
		rbGray.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setForeground(Color.darkGray);
			}
		});
		
		
	}
	public static void main(String[] args) {
		Ex1_ComboBox ex=new Ex1_ComboBox("ComboBox");
	}

}
