package abstract_test;
//implements 인터페이스를 상속받는키워드. 다중상속 가능. 인터페이스 이름 여러개 작성 가능
public class MyInterfaceImpl implements MyInterface { //대문자impl 
	
	@Override
	public void test1(String s) {
		// TODO Auto-generated method stub
		System.out.println("MAX:"+ MAX);
		System.out.println("s:"+s);
	}

	@Override
	public int test2(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}

}
