package day11;

public class ClassUpCastingEx01 {

	public static void main(String[] args) {
		/* 자식 클래스인 KiaCar 객체를 부모 클래스인 Car 객체에 저장 : 업 캐스팅
		 * 업 캐스팅은 자동으로 동작
		 * */
		//Car car = new KiaCar(4, "K5", 0x00ff00, "123허1234");
		//car.print();
		//Car 배열을 이용하여 여러 종류의 자동차들을 관리할 수 있다
		Car [] carList = new Car[5];
		carList[0] = new KiaCar(4, "K5", 0x00ff00, "123허1234");
		carList[1] = new HyundaiCar(4, "쏘나타", 0xff0000, "456가1234");
		
	}

}
