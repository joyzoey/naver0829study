package bit701.day0911;

public class Ex7_Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//배열 할당 방법1
//		Student []stu=new Student[3];
//		stu[0]=new Student();
//		stu[1]=new Student("강호동");
//		stu[2]=new Student("홍길동", 1989, 90);
		
		//배열 할당 방법2
		Student []stu= {
			new Student(),
			new Student("유재석"),
			new Student("이효리",1989,89),
			new Student("캔디",1979,100)
		};
		
		//출력방법1
//		for(int i=0;i<stu.length;i++)
//			stu[i].studentInfo();
		//출력방법2
		for(Student s:stu)
			s.studentInfo();
	}

}
