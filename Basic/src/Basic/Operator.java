package Basic;

public class Operator{

	  public static void main(String []args){

	   System.out.println("산술연산자");

	   System.out.println(1+2); // 3

	   System.out.println(6/2); //3

	   System.out.println(6/5); // 1 자바는 정수를 정수로 나누면 결과가 정수이다. 

	   System.out.println(6/5.0); // 1.2 5.0이 더블타입이고 6이 인트타입. 인트와 더블을 산술연산하면 결과는 더블타입(실수결과)

	   System.out.println((float)6/5); // 1.2  

	   //System.out.println(1/0); // 컴파일은 성공할수있으나 실행은 오류 실행시 ArithmeticException 발생

	   System.out.println(6%5);

	 

	   System.out.println("대입연산자");

	   int i;

	   i = 1+2;

	   System.out.println(i); //3

	   i += 4; // i+4;와 같음 7

	   System.out.println(i); //7

	   

	   Short s1, s2, s3;

	   s1 = 10;

	   s2 = 20;

	   //s3 = s1+s2; // incompatible types 자료형의 값이 일치하지 않을때 의 오류 산술연산(4바이트) short(2바이트)는 int보다 작은 연산값 강제형변환시키기

	   s3 = (short)(s1 + s2); // (s1+s2) 괄호로 연산자 우선순위를 높인후 short 타입으로 바꾼다

	   //s3 = (short)s1+s2; // s1만 쇼츠됨 

	   

	   System.out.println("비교연산자");

	   System.out.println(1==2);  // 비교연산은 무조건 결과가 true or false로 나온다

	   i = 17;

	   System.out.println(i%2 == 0); // false 연산자가 여러개 있을때는 연산자 우선순위를 고려. 우선순위가 가장낮은것: =. 산술연산과 비교연산있으면 산술연산이 더 높다. 

	   //i = i%2 == 0; // 산술먼저 . i%2=1 -> 1 == 0 이후. 자료형이 맞지않는다는 에러 발생	​

	   System.out.println("논리 연산자");

	   System.out.println(3>1 && 30>10); // 논리연산자의 좌측우측은 true or false가 와야한다 True

	   System.out.println(3>1 && 30>100); // false	​

	   System.out.println(3>1 || 30>10);  // true

	   System.out.println(3>1 || 30>100); // true

	   System.out.println(3>10 || 30>100); // false​
	   System.out.println(!(3>10)); // true
	
	   System.out.println("단항 연산자");

	   i = 10;

	   i++; // 1 증가

	   System.out.println(i);// 11

	   i--; // 1감소

	   System.out.println(i);// 10​

	   int j;

	   j = ++i; // 단항연산자가 대입연산자보다 우선.

	   System.out.println(i + "," + j); // 11, 11​

	   i=10;

	   j= i++; // 변수명 뒤쪽에 단항연산자 -> 다른연산 이후 단항연산자가 가장 나중에 처리(후치연산)

	   System.out.println(i + "," + j); // 11, 10

	/*

	   i++;

	   j=i;

	 */ 

	/*

	   j=i;

	   i++;

	*/   

	  

	   System.out.println("삼항 연산자");

	   System.out.println(18%2==0?"짝수" :"홀수"); // 1.산술연산자(0) 2. 비교연산자(true) . 3삼항연산자 순서. 짝수

	   String result = 18%2==0?"짝수" :"홀수"; // string 문자열 " "사용시.

	   System.out.println(result); // 짝수

	   char c='짝'; // "짝" -> String 타입  

	   System.out.println("THE END");

	 }

	

	}