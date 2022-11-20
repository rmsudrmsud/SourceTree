package abstract_test;

public interface MyInterface {
//정석	public static final int MAX=100; //보통 상수는 대문자로 변수는 소문자로
	   int MAX=100; //인터페이스안에서는 변수가 없기때문에 생략가능.
	   
//	   public abstract void test1(String s);
	   void test1(String s); //추상메서드
	   int test2(int a, int b);
}
