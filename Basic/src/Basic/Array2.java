package Basic;

public class Array2 {



	public static void main(String[] args) {

		//        int[][]arr1 = new int[3][2]; // int[3]행[2]열;

		//        arr1[0][0] = 80; //1번학생의 국어점수

		//        arr1[0][1] = 90; //1번학생의 수학점수



		//

		//        arr1[1][0] = 60; //2번학생의 국어점수

		//        arr1[1][1] = 100; /2번학생의 수학점수



		int[][]arr1 = {{80,90},

				{60,100},

				{0,0}

		}; // {}안에 {}행수만큼. 3행에 넣을값이없어도 초기값 0으로 표기해줘야함. 가독성을위해 행별로 엔터 추천



		System.out.println(arr1[0][0]);

		System.out.println(arr1[0][1]);



		// int colLength = arr1[0].length; // 행에대한 배열 갯수

		// for(int i=0; i<=colLength-1; i++) {

		// System.out.println(arr1[0][i]);

		// }

		//

		// colLength = arr1[1].length;

		// for(int i=0; i<=colLength-1; i++) {

		// System.out.println(arr1[1][i]);

		// }

		//

		// colLength = arr1[2].length;

		// for(int i=0; i<=colLength-1; i++) {

		// System.out.println(arr1[2][i]);

		// }



		int rowLength = arr1.length;

		for(int row=0; row<=rowLength-1;row++) {

			int colLength = arr1[row].length; // 행에대한 배열 갯수

			for(int col=0; col<=colLength-1; col++) {

				System.out.print(arr1[row][col]);

			}

			System.out.println();



		}

		//TODO

		/*

		 * 1 2 3 4

		 * 5 6 7 8

		 * 9 10 11 12

		 */

		

		int [][]arr2 = new int[3][4];

		int num=1;

		rowLength = arr2.length;

		for(int row=0; row<=rowLength-1; row++) {

			int colLength = arr2[row].length;

			for(int col=0; col<=colLength-1; col++) {

				arr2[row][col] = num;

				num++;

			}

		} 

		for(int row=0; row<=rowLength-1; row++) {

			int colLength = arr2[row].length;

			for(int col=0; col<=colLength-1; col++) {

				System.out.print(arr2[row][col] + "  ");

			}

			System.out.println();

		}



		//TODO

		/* 1  4  7  10

		 * 2  5  8  11

		 * 3  6  9  12 

		 */

		arr2 = new int[3][4];

		num = 1;

		int colLength = arr2[0].length;      //4

		for(int col=0; col<=colLength-1;col++) {

			rowLength = arr2.length;     //3

			for(int row=0;row<=rowLength-1;row++) {

				arr2[row][col] =num;

				num++;

			}



		}



		for(int row = 0;row<=rowLength-1;row++) {

			for(int col =0; col<=colLength-1;col++) {

				System.out.print(arr2[row][col]+" ");

			}

			System.out.println();

		}

		

		

		//TODO 

		// /* 1  2  3  4

		//  * 8  7  6  5

		//  * 9  10  11 12

		//  */

		

		// num=1;

		// for(int i = 0; i <= arr2.length-1; i++) {

		// for(int j = 0; j <= arr2[i].length-1; j++) {

		// if(i == 0 || i == 2) {

		// arr2[i][j] = num;

		// num++;

		// }else {

		// arr2[i][arr2[i].length-1-j] = num;

		// num++;

		// }

		// }

		// }

		
		

		arr2 = new int[3][4];

		num = 1;

		int max = num + (arr2.length * arr2[0].length);

		int row = 0;

		int col = 0;

		boolean direct = true;

		colLength = arr2[row].length;



		while(num < max) { //1~12

			if(col == -1 || col == colLength) {

				col = direct?colLength-1: 0;

				row++;

				direct = !direct;

			}

			arr2[row][col] = num;

			col = direct?col+1: col-1;

			num++;

		}



		for(row=0; row<=rowLength-1; row++) {

			for( col=0; col<=colLength-1; col++) {

				System.out.print(arr2[row][col] + "  ");

			}

			System.out.println();

		}



		int[][]arr3 = new int[3][]; //규격을맞춘다

		arr3[0] = new int[10];

		arr3[1] = new int[2];

		arr3[2] = new int[1];



		int[][]arr4 = new int[5][];

		// arr4[0]= new int[1];

		// arr4[1]= new int[2];

		// arr4[2]= new int[3];

		// arr4[3] = new int[4];

		// arr4[4] = new int[5];



		rowLength=arr4.length;

		for(int i=0; i<=rowLength-1; i++) {

			arr4[i] = new int[i+1];

		}

		// arr4[0][0] = 1;


		// arr4[1][0] = 1;

		// arr4[1][1] = 1;

		// 

		// arr4[2][0] = 1;

		// arr4[2][1] = 1;

		// arr4[2][0] = 1;


		// arr4[3][0] = 1;

		// arr4[3][1] = 1;

		// arr4[3][2] = 1;

		// arr4[3][3] = 1;





		// arr4[4][0] = 1;

		// arr4[4][1] = 1;

		// arr4[4][2] = 1;

		// arr4[4][3] = 1;

		// arr4[4][4] = 1;



		num=1;

		for(row = 0; row<= arr4.length-1; row++) {

			for(col = 0; col < arr4[row].length; col++) {

				arr4[row][col] = num;

				num++;

			}

		}

		for(row = 0; row <=arr4.length-1; row++) {

			for(col = 0; col <=arr4[row].length-1; col++) {

				System.out.print(arr4[row][col]+" ");

			}

			System.out.println();

		}





		int[][]arr5 = {{1,2,3},

				{4,5,6},

				{7,8,9}

		};



		// arr5[0][0] = arr6[2][0];

		// arr5[0][1] = arr6[1][0];

		// arr5[0][2] = arr6[0][0];

		

		// arr5[1][0] = arr6[2][1];

		// arr5[1][1] = arr6[1][1];

		// arr5[1][2] = arr6[0][1];

		

		// arr5[2][0] = arr6[2][2];

		// arr5[2][1] = arr6[1][2];

		// arr5[2][2] = arr6[0][2]; 

		

		//      arr6행과 arr5열의 관계 0->2 1->1 2->0 arr6열=arr5행

		//      6의행수 :  3 - 1 - 0

		//            3 - 1 - 1

		//           3 - 1 - 2

		
		

		// arr6[0][0] = arr5[0][2];

		// arr6[0][1] = arr5[1][2];

		// arr6[0][2] = arr5[2][2];

		// 

		// arr6[1][0] = arr5[0][1];

		// arr6[1][1] = arr5[1][1];

		// arr6[1][2] = arr5[2][1];

		// 

		// arr6[2][0] = arr5[0][0];

		// arr6[2][1] = arr5[1][0];

		// arr6[2][2] = arr5[2][0];

		int[][]arr6 = new int[arr5[0].length][arr5.length];

		rowLength = arr6.length;

		for(row=0; row<=rowLength-1; row++) {

			colLength = arr6[row].length;

			for(col=0; col<=colLength-1; col++) {

				arr6[row][col] = arr5[col][rowLength-1-row]; 

			}

		}



		for(row = 0; row <= rowLength-1; row++) {

			for(col = 0; col <=colLength-1; col++) {

				System.out.print(arr6[row][col] + "  ");

			}

			System.out.println();

		}

		

	}

}