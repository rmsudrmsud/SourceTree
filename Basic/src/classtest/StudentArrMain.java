package classtest;



import java.util.Scanner;


//3명 학생의 국어,영어,수학 총점, 평균(소수점까지). 이름 //배열3개될수밖에없음 

//배열을 활용하여 구현. 데이터입력받아서 처리(스캐너)

//배열의 단점 : 크기와 타입고정



public class StudentArrMain {



	public static void main(String[] args) {

		int size = 3;

		int[][] score = new int[size][5];

		float[] avg = new float[size];

		String[] name = new String[size];

		String[] title = {"name", "num", "kor", "eng", "maht", "total", "avg"};

		int i,j;

		Scanner sc = new Scanner(System.in);

		for(i=0;i<size;i++) {

			//이름 입력

			System.out.println(title[0]);

			name[i]=sc.next();

			//번, 국, 영, 수 입력

			for(j=0;j<4;j++) {

				System.out.println(title[j+1]);

				score[i][j]=sc.nextInt();

				if(j!=0) { // 번호 제외

					//총점 계산

					score[i][4] += score[i][j]; // 국,영,수 4번방에 누적

				}



			}

			//평균계산

			avg[i] = (float)score[i][4]/3;

		}

		//제목줄 출력

		for(String s:title) {

			System.out.print(s+"\t");

		}

		System.out.println();

		//결과 출력

		for(i=0;i<size;i++) {

			System.out.print(name[i]+"\t");

			for(int x:score[i])

			{

				System.out.print(x+"\t");

			}

			System.out.println(avg[i]);

		}

	}



}