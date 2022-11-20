package Basic;

public class Array1 {

	public static void main(String[] args) {

		/*

		 * int month1 = 70; int month2 = 60; int month3 = 70; int month4 = 60; int

		 * month5 = 70; int month6 = 60; int month7 = 70; int month8 = 60; int month9 =

		 * 70; int month10 = 60; int month11 = 70; int month12 = 60;

		 */

		int[] month; // int month[]; //배열 선언. int 배열타입의 month변수 -> 참조형(4byte)

		month = new int[12];         //배열 생성. new : 새로운 메모리를 확보한다는 뜻. int타입의 방 12개 생성, 0값으로 자동초기화.'='를만나면 정보값 가져옴



		month[0] = 70; //자바의 index(방) 0부터. month[0]~month[11] 사용가능

		//            System.out.println(month[-1]); //ArrayIndexOutOfBoundsException 에러. index공간을 벗어났다는 뜻

		//            System.out.println(month[12]); //여기도 오류이지만 위에 -1에서 에러뜨고 프로그램이 종료되어서 에러메시지가 안나옴



		System.out.println(month[0]); // 70 -> 0번방엔 70

		System.out.println(month[1]); // 0 ->나머지방엔 설정이없으면 자동초기값 0이 들어있다.



		int index = 2; // 기본형 

		System.out.println(month[index]); //변수를 배열에 활용. 0. month[2]



		int length = month.length; // length 배열길이(index개수)를 알려줌

		System.out.println(length); //12



		//1월부터 12월까지의 걸음수합 구하기

		int total = 0;

		for(int i=0; i<length; i++) {

			total += month[i];

		}

		System.out.println("1년총걸음수는" + total);



		//int scoreKor; int scoreMath; int scoreEng;

		int[] score = new int[3]; // 배열선언, 생성.

		length = score.length;

		score[0] = 87;

		score[1] = 69;

		score[2] = 92;



		//배열초기화 배열 선언,생성, 값지정 한번에

		String[] subject = {"국어", "수학", "영어"}; // 배열선언, 생성, 대입. 0번방 국어 2번방 수학 3번방 영어

		//subject = {"자바", "HTML", "스프링"}; //배열은 재초기화 불가능

		subject = new String[] {"자바", "HTML", "스프링"};

		for(int i =0; i<=length-1; i++) {

			System.out.println(subject[i] + "점수:" + score[i]);

		}


		float avg;







		//TODO 실수형 평균값 계산

		int totalScore = 0;

		// totalScore = score[0] + score[1] + score[2];

		for(int i=0; i<length;i++){

			totalScore += score[i];

		}

		avg =(float)totalScore / length;

		System.out.println("평균점 : " + avg);

		System.out.println("소숫점1자리까지의 평균점:" +((int)(avg*10)/10.0F));



		int[] numArr = {1,5,3,2,1,5,2,7,8,3,5,6,10,5};

		int[] cntArr =new int[10];//각 숫자의 출현횟수가 누적될 배열. cntArr[0]은 1의 출현횟수가 누적될 배열.

		//cntArr[1]은 2의 출현횟수가 누적될 배열

		//1의 출현횟수 : 2회

		//2의 출현횟수 : 2회

		//3의 출현횟수 : 2회

		//4의 출현횟수 : 0회

		//5의 출현횟수 : 4회

		//6의 출현횟수 : 0회

		//7의 출현횟수 : 1회

		//8의 출현횟수 : 1회

		//9의 출현횟수 : 0회

		//10의 출현횟수 : 1회

		for(int i=0; i<numArr.length; i++) {

			int value = numArr[i];

			cntArr[value-1]++;

		}

		for(int i=0; i<cntArr.length;i++) {

			System.out.println((i+1)+"의 출현횟수 :" + cntArr[i] + "회");

		}

		//for문에 선언한 변수는 그 블럭에서만 사용







		String []zodiacSign = {"원숭이", "닭", "개", "돼지", "쥐", "소", "호랑이", "토끼", "용", "뱀", "말", "양"};

		int year = 2022;

		System.out.println(year + "년도는" + zodiacSign[year%12] + " 해입니다.");



		int []numArr2 = {10, 3, 5, 2, 6};

		int max;

		int min;



		//TODO 최대값을 계산하시오.

		max = numArr2[0];

		for(int i=1; i<numArr2.length;i++) {

			if(numArr2[i]>max) {

				max=numArr2[i];

			}

		}

		System.out.println("최대값은 : " + max);

		//최대값 초기값을 배열의 0번째칸으로 지정 이후 다음 인덱스들과비교



		//TODO 최소값을 계산하시오.

		min = numArr2[0];

		for(int i=1; i<numArr2.length;i++) {

			if(numArr2[i]<min) {

				min=numArr2[i];

			}

		}

		System.out.println("최소값은 : " + min);

		// 최소값 : 초기값을 배열의 0번째칸으로 지정 이후 다음 인덱스들과비교

		//TODO 선택정렬(selection sort)로 오름차순하시오.

		//오름차순: 1,2,3,4,5~~  a,b,c,d~~  가,나,다 ~~. 사전순 같은의미 <->내림차순

		for(int i=0; i<numArr2.length;i++) {

			for(int j=i+1; j<numArr2.length; j++) {

				if(numArr2[i]>numArr2[j]) {

					int temp = numArr2[i]; // temp : 값 변경을 위한 임시저장

					numArr2[i]=numArr2[j];

					numArr2[j]=temp;

				}

			}

		}



		//선택정렬 : 0번인덱스부터 채워나가는거, 버블정렬 : 마지막인덱스부터 계산해 나가는것

		//최상이건 최악이건 선택정렬과 버블정렬은 시간복잡도가같다.

		//정렬에관한 것 : 회사시험문제로 best! 정렬의 개념 어떤 상황에 어떤 정렬을쓰는가 등등



		for(int i = 0; i<numArr2.length; i++) {

			System.out.print(numArr2[i]+" ");

		}

		System.out.println();

		//오름차순 정렬. 중간에 값을 비교할때 임시저장하는 temp 사용, https://wakestand.tistory.com/596



		//TODO 중앙값을 계산, 출력하시오.

		/*

int indexMiddle = numArr2.length;

    if(numArr2.length%2==0) {

            System.out.println("중간값: "+numArr2[indexMiddle/2-1]+ ", "+numArr2[indexMiddle/2]);

    }else{

            System.out.println("중간값: "+numArr2[indexMiddle/2]);

        }

		 */

		System.out.println("중앙값을 계산");

		int median;

		int halfLength = length / 2;

		if(length%2==0) { //짝수갯수인 경우 중앙값은 가운데 두 수의 평균

			median = (numArr2[halfLength-1] + numArr2[halfLength])/2;

		}else {

			median = numArr2[halfLength];

		}

		System.out.println(median);








		//TODO 1~45사이의 중복되지 않는 숫자를 6개 만드시오

		int[]lotto = new int[6];

		System.out.println("1~45사이의 중복되지 않는 로또숫자 6개를 만드시오");

		length = lotto.length;

		int maxLottoValue = 45;

		for(int i=0; i<=length-1; i++) {

			lotto[i] = (int)(Math.random()*maxLottoValue+1);

			for(int j=0; j<i; j++) {

				if(lotto[j] == lotto[i]) { //중복

					i--;

					break; // break로 빠져나오면 가장 근접한 반복문으로 돌아감

				}

			}

		}     

		for(int i=0; i<=length-1; i++) {

			System.out.print(i==0?"":","); //맨처음부터 , 를 쓰고싶지 않기때문에 i가 0일때 ""

			System.out.print(lotto[i]);

		}
		System.out.println();
		//강사님 풀이

		// int []numArr2 = 

		//      {5,4,3,2,1}; //worst

		//      {1,2,3,4,5}; //best

		//             {10, 3, 5, 2, 6};

		//     int max;

		//     int min;

		//     max = numArr2[0];

		//     //TODO 최대값을 계산,출력하시오

		//     length = numArr2.length;

		//     for(int i=1; i<length; i++) {

		//      if(max < numArr2[i]) {

		//      max = numArr2[i];

		//      }

		//     }

		//     System.out.println("최대값:" + max);

		//     //TODO 최소값을 계산,출력하시오

		//     min = numArr2[0];

		//     for(int i=1; i<length; i++) {

		//      if(min > numArr2[i]) {

		//      min = numArr2[i];

		//      }

		//     }

		//     System.out.println("최소값:" + min);

		

		// System.out.println("선택정렬(selection sort)로 오름차순하시오");

		//     for(int i=0; i<length-1; i++) {

		//      int minIndex = i;

		//      for(int j=i+1; j<length; j++) {

		//      if(numArr2[j] < numArr2[minIndex]) {

		//      minIndex = j; 

		//      }

		//      System.out.println("i["+i+"]=" + numArr2[i] +", j[" + j+ "]=" + numArr2[j] +"==>minIndex:"+minIndex);

		//      }

		//      System.out.println("--swap--");

		//      int temp = numArr2[i];

		//      numArr2[i] = numArr2[minIndex];

		//      numArr2[minIndex] = temp;

		//     }

		//     for(int i=0; i<length; i++) {

		//      System.out.println(numArr2[i]+",");

		//     }

	} 

}