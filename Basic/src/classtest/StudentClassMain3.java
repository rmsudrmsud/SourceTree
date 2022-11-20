package classtest;

//한 학생의 점수 1세트

class Score{

	int kor, eng, math, total;

	float avg;



	void setData(int k, int e, int m) {

		kor = k;

		eng = e;

		math = m;

		total = kor+eng+math;

		avg = (float)total/3;

	}

	void printData() {

		System.out.println("kor:"+kor);

		System.out.println("eng:"+eng);

		System.out.println("math:"+math);

		System.out.println("total:"+total);

		System.out.println("avg:"+avg);



	}

}

class Student3{

	String name;

	int num;

	String phone;

	Score score; // 점수 세트. 포함관계(다른 클래스의 객체를 멤버변수로 갖는것)



	void setInfo(String n, int nu, String p, Score s ) {

		name = n;

		num = nu;

		phone = p;

		score = s;

	}

	void printInfo() {

		System.out.println("name:"+name);

		System.out.println("num:"+num);

		System.out.println("phone:"+phone);

		score.printData();

	}

}



public class StudentClassMain3 {



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Student3 s3 = new Student3();

		Score s = new Score();

		s.setData(54, 98, 78);

		s3.setInfo("aaa",1 , "010-1111-2222",s);

		s3.printInfo();



	}



}