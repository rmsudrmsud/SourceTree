package oop3;

import java.util.ArrayList;

//메서드 재정의를 통한 다형성 구현
class Car {
	public String name;

	public Car() {
		name = "Car";
	}

	public void horn() {
		System.out.println("빵빵");
	}
}

class 엠뷸런스 extends Car {
	public 엠뷸런스() {
		name = "엠뷸런스";
	}

	// 메서드 재정의: 상속받은 메서드를 하위 클래스에 적합하게 수정
	// 메서드 껍데기는 그대로 내용만 수정
	@Override
	public void horn() {
		// TODO Auto-generated method stub
		System.out.println("삐오삐오");
	}

	public void 환자이송() {
		System.out.println("환자를 이송함");
	}
}

class 소방차 extends Car {
	public 소방차() {
		name = "소방차";
	}

	@Override
	public void horn() {
		// TODO Auto-generated method stub
		System.out.println("에~~~엥");
	}

	public void 불끈다() {
		System.out.println("불끈다");
	}
}

class 경찰차 extends Car {
	public 경찰차() {
		name = "경찰차";
	}

	@Override
	public void horn() {
		// TODO Auto-generated method stub
		System.out.println("삐뽀삐뽀");
	}

	public void 나쁜놈이송() {
		System.out.println("나쁜놈이송");
	}
}

public class CarMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 업캐스팅: 객체는 자식, 타입 부모인 캐스팅. 부모 클래스에 정의된 멤버만 사용가능
		ArrayList<Car> list = new ArrayList<>();
		list.add(new Car());
		list.add(new 엠뷸런스());
		list.add(new 소방차());
		list.add(new 경찰차());

		for (Car c : list) {
			System.out.println(c.name + "의 경적소리");
			c.horn();
			// 하위 클래스에 추가된 멤버를 사용하려면 다운캐스팅 해야함
			// instanceof: 객체 타입 비교 연산자.
			// 양 항의 타입이 일치하면 true, 아니면 false반환
			if (c instanceof 엠뷸런스) {
				//Car로 업캐스팅 된 c를 엠뷸런스로 다운 캐스팅
				((엠뷸런스) c).환자이송();
			} else if (c instanceof 소방차) {
				//Car로 업캐스팅 된 c를 소방차로 다운 캐스팅
				((소방차) c).불끈다();
			} else if (c instanceof 경찰차) {
				//Car로 업캐스팅 된 c를 경찰차로 다운 캐스팅
				((경찰차) c).나쁜놈이송();
			}
		}
	}

}
