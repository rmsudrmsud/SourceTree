package Basic;
public class Condition{

	public static void main(String[] args){

		int month = 1; // int 타입 기본자료형, 지역변수 -> 기본형 지역변수

		//해당월이 짝수(2로 나눈 나머지값이 0) 월인지 홀수월인지 판단

		System.out.println(month %2 == 0? "짝수월" : "홀수월");



		if( month %2 == 0 ) {

			System.out.println("짝수월입니다");

			System.out.println("앞으로" +(12-month) + "달 남았습니다.");

		} 



		if( month % 2 ==0) {

			System.out.println("짝수월입니다");

		}else{

			System.out.println("홀수월입니다");

		}



		//123, 456, 789, 101112 4분기



		if(month <4) {

			System.out.println("1분기");



		}else if(month < 7 ){

			System.out.println("2분기");

		}else if(month <10 ){

			System.out.println("3분기");

		}else{

			System.out.println("4분기");

		}



		switch(month){

		// case <4: 는 안됨

		case 1:

		case 2:

		case 3:

			System.out.println("1분기입니다");

			break;

		case 4:

		case 5:

		case 6:

			System.out.println("2분기입니다");

			break;

		case 7:

		case 8:

		case 9:

			System.out.println("3분기입니다");

			break;

		case 10:

		case 11:

		default:

			System.out.println("4분기입니다");

			break; // default에는 브레이크 있어도괜찮고 없어도괜찮다



		}



		switch((month-1)/3){

		case 0:

			System.out.println("1분기");

			break;

		case 1:

			System.out.println("2분기");

			break;

		case 2:

			System.out.println("3분기");

			break;

		default:

			System.out.println("4분기");

			break;

		}



		System.out.println( ((month-1)/3) +1 + "분기");



		int scoreKor = 86;

		int scoreMath = 95;

		int scoreEng = 99;

		//소숫점을 포함한 평균을 출력하시오

		//평균이 90점 이상인 경우 A등급

		//평균이 80점 이상인경우 B등급

		// 70점 이상 C등급

		// 60점 이상 D등급

		// 60점 미만인 경우 F등급(if구문으로풀이, switch구문으로 풀이)



		//  if구문    

		float avg=  (scoreKor + scoreMath + scoreEng) / 3.0F;    //평균변수 이름 -> avg로!

		System.out.println(avg+"점");

		if( avg >=90 ) {

			System.out.println("A등급");

		} else if(avg >=80){ 

			System.out.println("B등급");

		} else if(avg >=70){ 

			System.out.println("c등급");

		} else if(avg >=60){ 

			System.out.println("d등급");

		} else{

			System.out.println("F등급");

		}





		// switch구문

		System.out.println(avg+"점");

		switch((int)(avg/10)){  // (int)(avg/10), (int)avg/10 

		case 10:

		case 9: 

			System.out.println("A등급");

			break;

		case 8:

			System.out.println("B등급");

			break;

		case 7:

			System.out.println("C등급");

			break;

		case 6:

			System.out.println("D등급");

			break;

		default :

			System.out.println("F등급");

			break;

		}



		//스위치 없이 규칙 발견해서 a~f까지 출력하기해보기



		java.util.Scanner sc; // sc ->변수이름. 참조 자료형 지역변수

		sc= new java.util.Scanner(System.in);

		System.out.print("년도를 입력하세요:");

		String y = sc.nextLine(); // 키보드로 값을 입력 메소드를 호출해서 값을 반환받는다.

		System.out.println("입력받은 년도값은" + y + "입니다");



		//int year =(int)y; -> 기본형과 참조형변수는 형변환 불가능

		int year = Integer.parseInt(y); // 스트링을 인트값으로 바꾼이유 : 산술연산을 참여하기 위해서

		//int year = sc.nextLine(); ->X. sc.nextLine() 라이브러리는 String값만 받기로 고정.  

		//년도 12로 나눈 나머지값이 0이면 원숭이, 1 닭, 2 개, 3 돼지, 4 쥐, 5 소, 6 호랑이, 7 토끼, 8용, 9 뱀, 10 말, 11 양 



		if (year%12==0){

			System.out.println("원숭이");

		}else if ((year%12)==1){

			System.out.println("닭");

		}else if ((year%12)==2){

			System.out.println("개");

		}else if ((year%12)==3){

			System.out.println("돼지");

		}else if ((year%12)==4){

			System.out.println("쥐");

		}else if ((year%12)==5){

			System.out.println("소");

		}else if ((year%12)==6){

			System.out.println("호랑이");

		}else if ((year%12)==7){

			System.out.println("토끼");

		}else if ((year%12)==8){

			System.out.println("용");

		}else if ((year%12)==9){

			System.out.println("뱀");

		}else if ((year%12)==10){

			System.out.println("말");

		}else if ((year%12)==11){

			System.out.println("양");

		}



		switch(year%12){

		case 0:

			System.out.println("원숭이");

			break;

		case 1:

			System.out.println("닭");

			break;

		case 2:

			System.out.println("개");

			break;

		case 3:

			System.out.println("돼지");

			break;

		case 4:

			System.out.println("쥐");

			break;

		case 5:

			System.out.println("소");

			break;

		case 6:

			System.out.println("호랑이");

			break;

		case 7:

			System.out.println("토끼");

			break;

		case 8:

			System.out.println("용");

			break;

		case 9:

			System.out.println("뱀");

			break;

		case 10:

			System.out.println("말");

			break;

		case 11:

			System.out.println("양");

			break;

		} // 값이 고정되어나올떈 swtich가 if보다 좋다



		//가위바위보

		System.out.println("가위-1, 바위-2, 보-3");

		System.out.println("입력하세요");

		String user = sc.nextLine();

		switch(user){ //switch(조건) 조건자료형은 byte, short, int, char, ->>(int로 형변환이 가능한 타입들), String 타입만 가능, long타입 불가능

		case "1" :

			System.out.println("가위를 입력했습니다.");

			break;

		case "2" :

			System.out.println("바위를 입력했습니다.");

			break;

		case "3" : 

			System.out.println("보를 입력하셨습니다.");

			break;

		default : 

			System.out.println("잘못입력하셨습니다.");

			System.exit(0); // 프로그램 종료

		}    



		int computer =(int)(Math.random()*3+1); //랜덤값을 가져오는 메소드 1.0<=     <4.0

		System.out.println("컴퓨터가 낸 값은");

		switch(computer){

		case 1 :

			System.out.println("가위입니다");

			break;

		case 2 :

			System.out.println("바위입니다");

			break;

		case 3 :

			System.out.println("보입니다");

			break;

		}



		//사용자가 이기는경우

		//사용자 컴퓨터 컴퓨터%3

		//1(가위)  3(보)       0

		//2(바위)  1(가위)    1

		//3(보)     2(바위)    2



		int userint = Integer.parseInt(user);     

		if(userint == computer){

			System.out.println("비겼습니다");

		}else {

			if((userint==1 && computer==3) ||

					(userint==2 && computer==1) ||

					(userint==3 && computer==2)){

				System.out.println("이겼습니다");        

			}else{

				System.out.println("졌습니다");

			}

			System.out.println( userint - (computer %3) == 1?"이겼습니다":"졌습니다");
		}
	}

}