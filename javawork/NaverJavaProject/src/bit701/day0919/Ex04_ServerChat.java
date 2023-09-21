package bit701.day0919;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Ex04_ServerChat extends JFrame implements Runnable{
	JTextArea area;
	
	public Ex04_ServerChat() {
		super("채팅서버");
		this.setBounds(700,100,400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
		
	}
	
	//1번 쓰레드의 run메소드
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//서버 소켓 생성
		ServerSocket serverSocket=null;
		try {
			serverSocket=new ServerSocket(6000);
			area.append("서버소켓생성성공!!\n");
			
			//접속하는 클라이언트들 허용
			while(true)
			{
				//대기중
				//접속요청하는 클라이언트 허용, 허용되면 socket이 만들어짐
				Socket socket=serverSocket.accept();
				System.out.println("접속허용 IP:"+socket.getInetAddress().getHostAddress()+"\n");
				
			}
			
		} catch (IOException e) {
			 area.append("서버소켓생성실패:"+e.getMessage());
		}
	}

	private void setDesign() {
		// TODO Auto-generated method stub
		area=new JTextArea();
		this.add(area);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex04_ServerChat serverChat=new Ex04_ServerChat();
		Thread th=new Thread(serverChat);
		th.start();//1번 run 메소드 호출
	}

}
