package bit701.day0914;

//<T>는 T가 타입 파라미터임을 뜻하는 기호로
//타입이 필요한 자리에 T를 사용한다
class GenericsType<T>{
	T[] v;//v라는 배열
	
	public void set(T[] n)//set이라는 메소드에 매개변수 T[] n
	{
		v=n;
	}
	
	public void print()
	{ 
		for(T s:v)
		{
			System.out.println(s+" ");
		}
		System.out.println();
	}
	
}

public class Ex5_Generics {

	public static void main(String[] args) {
		String []sarr= {"장미꽃","안개꽃","다알리아"};
		Integer []narr= {5,7,10,30,100};
		
		//T에 대체되는 타입은 클래스타입 또는 인터페이스만 가능
		//String과 Integer만 가능, int는 기본타입이라서 대체 타입이 될 수 없다.
		GenericsType<String> t1=new GenericsType<>();
		t1.set(sarr);
		t1.print();
		
		System.out.println("-".repeat(30));
		
		//GenericsType<int> t2=new GenericsType();//int 에러
		GenericsType<Integer> t2=new GenericsType();
		t2.set(narr);
		t2.print();
	}

}
