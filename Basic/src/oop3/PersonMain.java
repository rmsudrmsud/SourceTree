package oop3;

//학생 / 교수 / 교직원

//학생(번호, 이름, 수강과목String[])

//교수(번호, 이름, 오픈과목String[])

//교직원(번호, 이름 직무String)


//부모 클래스

class Person{

	protected int num;            //공통으로 갖는 녀석들

	protected String name;



	// public Person() {}



	public Person(int num, String name) { //부모클래스 생성자

		this.num = num;

		this.name = name;

	}


	public void printInfo() {

		System.out.println("num:"+num);

		System.out.println("name:"+name);   



	}


}


//자식 클래스 학생

class Student extends Person{

	public String[] subj; // 수강과목



	public Student(int num, String name, String[] subj) {

		super(num,name); //부모 생성자 호출. 이유? 생성자 파라메터 전달

		// this.num = num;

		// this.name = name;

		this.subj = subj;

	}



	@Override

	public void printInfo() {

		// TODO Auto-generated method stub

		super.printInfo(); //super = this와 비슷한 역할->부모객체(Person)의 printInfo를호출하라는 뜻

		System.out.println("수강과목");

		for(String s:subj) {

			System.out.println(s);

		}

	}



	public void printSubj() {

		System.out.println("수강과목");

		for(String s:subj) {

			System.out.println(s);

		}

	}

}

//자식클래스 교수

class Prof extends Person{

	public String[] open;


	public Prof(int num, String name, String[] open) {

		super(num,name);

		// this.num = num;

		// this.name = name;

		this.open = open;

	}


	@Override

	public void printInfo() {

		// TODO Auto-generated method stub

		super.printInfo();

		System.out.println("오픈과목");

		for(String s:open) {

			System.out.println(s);

		}

	}


	public void printOpen() {

		System.out.println("오픈과목");

		for(String s:open) {

			System.out.println(s);

		}

	}

}


//자식클래스 교직원

class Staff extends Person{

	public String job;



	public Staff(int num, String name, String job) {

		super(num,name);

		// this.num = num;

		// this.name = name;

		this.job = job;

	}



	@Override

	public void printInfo() {

		// TODO Auto-generated method stub

		super.printInfo();

		System.out.println("담당직무: "+ job);

	}


	public void printJob() {

		System.out.println("직무");

		System.out.println(job);

	}

}



public class PersonMain {

	public static void main(String[] args) {

		Student s1 = new Student(1,"aaa", new String[] {"국어","영어", "수학"}); //초기화생성

		s1.printInfo(); //num, name 출력

		// s1.printSubj(); // 수강과목 출력


		Prof p = new Prof(2,"bbb",new String[] {"국어","영어"});

		p.printInfo();

		// p.printOpen();



		Staff s= new Staff(3,"ccc","청소");

		s.printInfo();

		// s.printJob();


		Person pp = new Person(4,"ddd");

		pp.num = 4;

		pp.name = "ddd";

		//부모 객체는 부모printInfo(), 자식 객체는 자식 printInfo()가 호출된다

		pp.printInfo(); //이 객체의 클래스에 정의된 메서드가 호출



		//업 캐스팅

		Person up1 = s1; //s1 스튜던트의 객체를 부모타입객체에 담는것

		System.out.println(s1.num);

		System.out.println(s1.name);

		System.out.println(s1.subj[0]);



		System.out.println(up1.num);

		System.out.println(up1.name);

		// System.out.println(up1.subj[0]); //업 캐스팅된 변수는 부모클래스에 정의된 변수만 사용가능

		//부모클래스 없는 subj[0]이기 때문에 에러


		//하위클래스에 추가된 멤버를 사용하려면 다운캐스팅하여 접근

		System.out.println("다운캐스팅 예:"+((Student)up1).subj[0]);




		s1.printInfo();

		s1.printSubj();


		System.out.println("업 캐스팅 객체로 재정의 메서드 호출");

		up1.printInfo(); //업캐스팅된 객체로 재정의 메서드 호출하면 자식클래스의 것 실행됨


		// up1.printSubj();  up캐스팅해서 부모행세를 하기때문에 자식 클래스에 정의된 printSubj사용 불가



		System.out.println("===========  업캐스팅 테스트 ===========");

		Person[] arr = {s1,p,s,pp};

		for(Person x:arr) {

			x.printInfo();

		}



	}

}