package classtest;

class Student2{

	String name;

	int[] score;  // num, kor, eng, math, total 

	float avg;



	void setData(String n, int[] s) {

		//파라메터로 가져온 참조값은 주소를가짐

		name = n;

		score = s;

		score[4] = score[1]+score[2]+score[3];

		avg = (float)score[4]/3;



	}

	void printData() {

		System.out.println("name:"+name);

		String[] title = {"num: ","kor: ","eng: ","math: ","total: "};

		for(int j=0;j<score.length;j++) {

			System.out.println(title[j]+score[j]);

		}

		System.out.println("avg:"+avg);



	}

}



public class StudentClassMain2 {



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Student2 s = new Student2();

		s.setData("aaa", new int[] {1,65,87, 99, 0});

		s.printData();



	}



}