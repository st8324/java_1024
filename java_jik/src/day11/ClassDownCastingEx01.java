package day11;

public class ClassDownCastingEx01 {

	public static void main(String[] args) {
		/* 클래스 다운 캐스팅은 조건부로 가능
		 * 안되는 경우 : 부모 클래스의 객체를 바로 자식 클래스의 객체에 저장하는 경우
		 * */
		//KiaCar kcar =(KiaCar)(new Car(4,"K5", 0x00ff00, "123허1234","기아"));
		//kcar.print();
		/* 되는 경우 : 자식 클래스의 객체를 부모 클래스의 객체에 저장한 후, 
		 * 부모 클래스의 객체를 다시 자식 클래스의 객체로 저장하는 경우
		 * */
		KiaCar kcar1 = new KiaCar(4,"K5", 0x00ff00, "123허1234");
		Car car = kcar1;
		//Car car = new KiaCar(4,"K5", 0x00ff00, "123허1234");
		KiaCar kcar2 = (KiaCar)car;
		kcar2.print();
		

		Car [] carList = new Car[5];
		carList[0] = new KiaCar(4, "K5", 0x00ff00, "123허1234");
		carList[1] = new HyundaiCar(4, "쏘나타", 0xff0000, "456가1234");
		for(Car tmp : carList) {
			if(tmp == null) {
				continue;
			}
			//차 종류에 맞게 기아면 수동으로 기능을 현대면 자동으로 트렁크가 열리게 하기 위해  
			//다운 캐스팅을 함
			if(tmp instanceof KiaCar) {
				((KiaCar) tmp).hand();
			}else if(tmp instanceof HyundaiCar) {
				((HyundaiCar) tmp).auto();
			}
		}
	}
}
