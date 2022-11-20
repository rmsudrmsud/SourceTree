package classtest;


import java.util.Scanner;



//문제 1 주소록 프로그램 

class Member1{

	String name, tel, address;



	void setData(String n, String t, String a) {

		name = n;

		tel = t;

		address = a;

	}



	void printData() {

		System.out.println("이름:"+name);

		System.out.println("전화번호:"+tel);

		System.out.println("주소:"+address);

	}



}

public class Member {



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Member1 m1 = new Member1(); // m1 Member1클래스 선언

		m1.setData("aaa", "0102222", "대한민국"); // setdata에 값넣어주는곳

		m1.printData(); // printdata 실행

		//여러사람일땐? 객체를 여러개 만들기. 

		//여러개의 객체를 배열에 담기 가능



		//Member1 객체 3개 담을 수 있는 배열 생성.

		//세명의 주소 정보 저장

		//출력

		//3가지방법

		Member1[] arr = new Member1[3]; // 방만 생성 arr 배열 0번방, 1번방, 2번방

		// 1. 배열 각 방에 객체 생성해서 담기



		arr[0]= new Member1();

		arr[1]= new Member1();

		arr[2]= new Member1();



		// 2. for 문 쓰는방법 

		for(int i=0; i<arr.length; i++) {

			arr[i] = new Member1();

		}



		// 3. 객체에 초기화값넣는 방법 

		Member1[] arr2 = { new Member1(), new Member1(), new Member1() };

		Scanner sc=new Scanner(System.in); //패키지에 스캐너가없으면 빨간줄

		//"컨트롤 쉬프트 o(영어)"누르면 위에 import문 추가됨

		//입력부

		for(Member1 m:arr2) {

			System.out.println("name");

			String name = sc.next();

			System.out.println("tel");

			String tel = sc.next();

			System.out.println("address");

			String address = sc.next();

			m.setData(name, tel, address);

		}


		//출력부

		for(Member1 m:arr2) {

			m.printData();

		}



	}



}