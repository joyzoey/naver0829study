package bit701.day0912;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex5_FileLeader {

	static final String SUNGJEOK_FILE="D:\\naver0829/Sungjeok.txt";
	Sungjeok []sung=new Sungjeok[20];
	int count;
	
	public Ex5_FileLeader() throws IOException {
		//파일 읽어서 sung 배열에 담기(줄단위로 읽은 후 , 분리해서 넣기)
		FileReader fr=null;
		BufferedReader br=null;
		try {
			fr=new FileReader(SUNGJEOK_FILE);
			br=new BufferedReader(fr);
			
			count=0;
			while(true)
			{
				String line=br.readLine();
				//null이면 종료
				if(line==null)
					break;
				//줄 내용 분리
				String []strArray=line.split(",");
				String name=strArray[0];
				int kor=Integer.parseInt(strArray[1]);
				int eng=Integer.parseInt(strArray[2]);
				//성적 클래스 생성-count번지
				sung[count]=new Sungjeok(name, kor, eng);
				count++;
			}
			br.close();
			fr.close();
			System.out.println("총 "+count+"명의 성적을 읽었습니다.\n\n");
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		}
		
	}
	
	public void dataList()//출력
	{
		System.out.println("이름\t국어\t영어\t총점\t평균");
		System.out.println("-".repeat(40));
		for(int i=0; i<count; i++)
		{
			Sungjeok s=sung[i];
			int tot=s.getKor()+s.getEng();
			double avg=tot/2.0;
			System.out.println(s.getName()+"\t"+s.getKor()+"\t"+s.getEng()+"\t"+tot+"\t"+avg);
		}
		System.out.println("-".repeat(40));
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Ex5_FileLeader ex=new Ex5_FileLeader();
		ex.dataList();

	}

}
