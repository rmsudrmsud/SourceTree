package abstract_test;

public class MyInterFaceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyInterfaceImpl m = new MyInterfaceImpl();
		System.out.println(MyInterface.MAX); //상수는 객체생성과 상관없어서 인터페이스 이름으로 사용가능
		m.test1("aaa");
		m.test2(1, 3);
	}

}
