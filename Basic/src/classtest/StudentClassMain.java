package classtest;



import java.util.Scanner;



//성적. 클래스는 객체1개 기준으로 정의한다. student클래스 라고하면? 학생1명 기준

class Student1{

	String name;

	int num, kor, eng, math, total;

	float avg;

	//int[][] score;  -> 처럼 하면안됨


	//입력메서드

	void setData(String na, int n, int k, int e, int m) {

		name = na;

		num = n;

		kor = k;

		eng = e;

		math = m;

		total = k+e+m;

		avg = (float)total/3;

	}

	//출력메서드

	void printData() {

		System.out.println("name"+name);

		System.out.println("num"+num);

		System.out.println("kor"+kor);

		System.out.println("eng"+eng);

		System.out.println("math"+math);

		System.out.println("total"+total);

		System.out.println("avg"+avg);

	}



}

public class StudentClassMain {

	//키보드 입력받아 객체에 담아주는 메서드

	public static void input(Student1 s, Scanner sc) { //스태틱이 붙은 메서드는 메서드이름으로 호출가능

		//main에서 호출하기위해서 static 붙임

		System.out.print("name");

		String name=sc.next();

		System.out.print("num:");

		int num =sc.nextInt();

		System.out.print("kor:");

		int kor=sc.nextInt();

		System.out.print("eng:");

		int eng =sc.nextInt();

		System.out.print("math:");

		int math =sc.nextInt();

		s.setData(name, num, kor, eng, math);

	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		// 입력에 사용할 스캐너객체 생성

		Scanner sc = new Scanner(System.in);

		//첫 번째 학생 객체 하나 생성

		Student1 s1 = new Student1();

		input(s1, sc);//s1: 입력받은 값 담을 객체, sc: 입력에 사용할 스캐너

		s1.printData();



		Student1 s2 = new Student1();

		input(s2, sc);

		s2.printData();



		Student1 s3 = new Student1();

		input(s3, sc);

		s3.printData();



		// s1.name = "aaa";

		// s1.num = 1;

		// s1.kor = 34;

		// s1.eng = 56;

		// s1.math = 76;

		// s1.total = s1.kor + s1.eng + s1.math;

		// s1.avg = (float)s1.total/3;

		// 

		// System.out.println("name"+s1.name);

		// System.out.println("num"+s1.num);

		// System.out.println("kor"+s1.kor);

		// System.out.println("eng"+s1.eng);

		// System.out.println("math"+s1.math);

		// System.out.println("total"+s1.total);

		// System.out.println("avg"+s1.avg);

	}



}