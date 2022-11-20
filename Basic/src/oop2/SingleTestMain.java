package oop2;


import java.util.Calendar;

import java.util.Date;





class SingleTest {

	//생성자가 private이라 클래스 외부에서 객체생성 불가.

	//그래서 클래스 내에서 객체 생성하여 줘야함 => 싱글톤에서 바깥에주는것 getInstance()

	private static SingleTest st = new SingleTest();



	//private 생성자

	private SingleTest() {}


	//밖에서 객체요청시 호출할 메서드

	public static SingleTest getInstance() {

		return st;

	}



	public void test() {

		System.out.println("싱글톤 테스트");

	}

}



public class SingleTestMain {


	public static void main(String[] args) {

		// TODO Auto-generated method stub

		//SingleTest st = new SignleTest(); //생성자가 private이라 클래스밖에서 사용불가



		//싱글톤 객체 획득

		SingleTest st = SingleTest.getInstance();

		st.test();



		Calendar c = Calendar.getInstance(); //객체를 new가아닌 getInstance로생성 싱글톤객체

		Date date = c.getTime(); // 현재 날짜, 시간 반환하는 메서드

		System.out.println((date.getYear()+1900)+"년");

		System.out.println(date.getMonth()+"월");

		System.out.println(date.getDate()+"일");

	}



}