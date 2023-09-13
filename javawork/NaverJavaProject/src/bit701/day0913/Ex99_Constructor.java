package bit701.day0913;
 
class Car{
	//필드 선언
	private String company="현대자동차";
	private String carName;
	private int carPrice;
	private int maxSpeed;
	private String color;
	//생성자 오버로딩
	Car()
	{
		this("아반떼", 100, 200, "red");
	}
	Car(String carName)
	{
		this(carName, 100, 200, "red");
	}
	Car(String carName,int carPrice)
	{
		this(carName, carPrice, 200, "red");
	}
	Car(String carName,int carPrice, int maxSpeed)
	{
		this(carName, carPrice, maxSpeed, "red");
	}
	Car(String carName,int carPrice, int maxSpeed, String color)
	{
		this.carName=carName;
		this.carPrice=carPrice;
		this.maxSpeed=maxSpeed;
		this.color=color;
	}
	//출력함수
	public void carShow() {
		System.out.println(carName+", "+carPrice+", "+maxSpeed+", "+color);
	}
}

public class Ex99_Constructor {
	public static void main(String[] args) {
		//생성자호출
		Car car1=new Car();
		car1.carShow();
		
		Car car2=new Car("아반떼1");
		car2.carShow();
		
		Car car3=new Car("아반떼2",200);
		car3.carShow();
		
		Car car4=new Car("아반떼3",300,400);
		car4.carShow();
		
		Car car5=new Car("아반떼4",400,500,"green");
		car5.carShow();
		
	}

}
