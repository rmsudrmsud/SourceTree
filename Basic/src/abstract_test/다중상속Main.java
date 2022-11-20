package abstract_test;
interface A{
	void test1();
}

interface B{
	void test2();
}

class C implements A,B{

	@Override
	public void test2() {
		// TODO Auto-generated method stub
		System.out.println("test2");
	}

	@Override
	public void test1() {
		// TODO Auto-generated method stub
		System.out.println("test1");
	}
	
}

public class 다중상속Main implements MyInterface {
	public static void main(String[] args) {
		C c = new C();
		c.test1();
		c.test2();
	}
	
	@Override
	public void test1(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int test2(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

}
