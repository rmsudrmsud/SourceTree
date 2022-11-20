package oop1;

class LocalValTest1{

	//멤버 변수. 이 클래스의 모든 메서드가 읽고 사용

	int x; // x=0 함수 선언을 메서드 밖에서하면 멤버변수

	int y; // y=0



	void printData(int a) {

		System.out.println("x: "+x);

		System.out.println("y: "+y);

		System.out.println("a: "+a); //a->지역변수

		// setData()의 지역변수z 선언되어있으므로 이메서드에서 사용x

		// System.out.println("z: "+z);

	}



	void setData() {

		// a = 10; 지역변수는 선언한 메서드에서만사용. printData()의 파라메터이므로 이 메서드에서 사용x

		//      int x;

		x = 10; // 지역변수

		y = 20;

		int z; //지역변수 z는 값을 할당하지않으면 쓰레기값을 가짐.

		// System.out.println("z: "+z); 지역변수 초기화 안하고 사용하면 에러발생

	}

}



public class LocalValTest {



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		LocalValTest1 lv = new LocalValTest1();

		lv.printData(5);

		lv.setData(); // x,y

		lv.printData(7); //



	}



}