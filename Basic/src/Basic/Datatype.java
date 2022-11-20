package Basic;
public class Datatype{

	  public static void main(String []args){

	    System.out.println(10); // 컴파일러가 정수리터럴은 int 로 판단

	    System.out.println(12.3); // 실수리터럴은 dobule로판다

	    byte b; // 변수 선언

	    b = 1; // int보다 작은 자료형에 대입되는 리터럴은 해당자료형으로 판다

	    b = 10;

	    //b = 12.3;

	    b = (byte)12.3; // 강제형변환(double->byte)

	   System.out.println(b); // 12

	

	   int i = b; // 자동형변환(byte->int)

	   System.out.println(i); // 12	​

	   float f = i;

	   System.out.println(i); //12

	   

	   //f = 34.5;

	   f = 34.5f;

	   System.out.println(f); // 34.5

	

	  long l = 10;

	   //  l = 12345678901234567890;

	   l = 1234567890123L;

	

	  char c;

	  c = 'a';

	  i = c;

	  System.out.println(c);

	  System.out.println(i);	
	  c = 98;

	  System.out.println(c); // 98,b	​

	  boolean flag;

	  flag = true;

	  flag = false;

	  // flag = 1; // x

	  // flag = (boolean)1; // x

	  }

	}