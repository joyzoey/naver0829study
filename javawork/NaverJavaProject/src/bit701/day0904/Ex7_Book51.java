package bit701.day0904;

public class Ex7_Book51 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Json 데이타{"키":"값"}
		String jdata="{\"name\":\"이진\"}";
		System.out.println(jdata);
		
		//jdk13에서 추가된 텍스트 블록 문법"""
		String jdata2=
				"""
{"name":"캔디","address","역삼동"}
				""";
		System.out.println(jdata2);
		
		
		//기존문법
		String name="마이클잭슨";
		int age=32;
		String jdata3= "{\"name\":\""+name+"\",\"age\":"+age+"}";
		System.out.println(jdata3);
		
		//텍스트블록문법
		String jdata4="""
{"name":"%s","age":%d}				
				""".formatted(name,age);
		System.out.println(jdata4);
		
		String str1="red\nblue\ngreen";
		System.out.println(str1);
		System.out.println();
		
		String str2="""
				red
				blue
				green
				pink
				""";
		System.out.println(str2);
	}

}
