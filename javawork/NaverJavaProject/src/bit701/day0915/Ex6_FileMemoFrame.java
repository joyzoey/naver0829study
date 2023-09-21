package bit701.day0915;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex6_FileMemoFrame extends JFrame {
	JTextArea memoArea;
	JButton btnSave, btnOpen, btnClear;
	
	public Ex6_FileMemoFrame(String title) {
		
		super(title); // JFrame의 문자열을 받는 생성자 호출
		
		this.setLocation(300, 100); // 프레임의 시작 위치
		this.setSize(500, 600); // 프레임의 너비, 높이
		this.getContentPane().setBackground(Color.PINK);
		// 디자인이나 이벤트를 구현할 메소드 호출

		this.setDesign();
		this.setVisible(true); // true : 프레임을 보이게하기, false : 프레임 숨기기
		
		// 윈도우 이벤트 발생
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) { // 윈도우의 x버튼 클릭시 호출되는 메서드
				
				// JOptionPane.showMessageDialog(SwingGibon.this, "프레임 종료");
				// 실제 종료
				System.exit(0); // 정상 종료
				super.windowClosing(e);
				
			}
			
		});
	}

	private void setDesign() {
		btnSave = new JButton("저장");
		btnOpen = new JButton("열기");
		btnClear = new JButton("지우기");
		
		JPanel p = new JPanel();
		p.add(btnSave);
		p.add(btnOpen);
		p.add(btnClear);
		
		this.add(p, "North");
		
		memoArea = new JTextArea("내용 입력");
		// this.add(memoArea, "Center"); // 데이터가 길어져도 스크롤바가 생기지 않음
		this.add(new JScrollPane(memoArea), "Center");
		
		// 내용 지우기
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				memoArea.setText("");
			}
		});
		
		// 저장
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog dlg = new FileDialog(Ex6_FileMemoFrame.this, "저장", FileDialog.SAVE);
				dlg.setVisible(true);
				// System.out.println("디렉토리 : " + dlg.getDirectory());
				// System.out.println("파일명 : " + dlg.getFile());
				
				// 취소시 메서드 종료
				if(dlg.getDirectory() == null) return;
				
				String fileName= dlg.getDirectory() + dlg.getFile() + ".txt";
				
				String memoText = memoArea.getText(); // 저장할 내용
				FileWriter fw = null;
				try {
					fw = new FileWriter(fileName);
					
					// 내용 저장
					fw.write(memoText);
					// 메모장에 메세지 넣기
					memoArea.setText("저장완료");
				} catch (IOException e1) {
					System.out.println("저장 오류");
				} finally {
					try {  
						fw.close();
					} catch (NullPointerException | IOException e1) {
					}
				}
			}
		});
		
		// 열기
		btnOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog dlg = new FileDialog(Ex6_FileMemoFrame.this, "열기", FileDialog.LOAD);
				dlg.setVisible(true);
				
				// 취소시 메서드 종료
				if(dlg.getDirectory() == null) return;
				
				String fileName= dlg.getDirectory() + dlg.getFile();
				
				String memoText = memoArea.getText(); // 저장할 내용
				
				FileReader fr = null;
				BufferedReader br = null;
				try {
					fr = new FileReader(fileName);
					br = new BufferedReader(fr);
					
					// 메모장 기본 내용 지우기
					memoArea.setText("");
					while(true) {
						String line = br.readLine();
						if(line == null) break;
						
						memoArea.append(line + "\n");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					try {  
						br.close();
						fr.close();
					} catch (NullPointerException | IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		Ex6_FileMemoFrame s = new Ex6_FileMemoFrame("메모");
	}

}