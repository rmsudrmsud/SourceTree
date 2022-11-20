package Basic;

public class Loop{
	
	public static void main(String[] args){
		System.out.println("Hi");

		System.out.println("Hi");

		System.out.println("Hi");

		System.out.println("Hi");

		System.out.println("Hi");
	
		int i = 0; //반복문의 카운트역할

		while(i<5){

			System.out.println("Hi");

			i++;

		}

	

		i = 0;

		/*System.out.println(0);

       System.out.println(1);

       System.out.println(2);

       System.out.println(3);

       System.out.println(4);

		 */

		/*

      i = 1;

      while(i<5) {

       System.out.println(i);

       i++;

      //한줄로 합치면 System.out.println(i++);  -> 지양. ++연산자는 혼자쓰는게 안전

      }

		 */   

		

		while(i<5){

			i++;

			System.out.println(i);

			// 한줄로 합치면 System.out.println(++i); -> 지양


		}

		/*

       System.out.println("1");

       System.out.println("3");

       System.out.println("5");

       System.out.println("7");

       System.out.println("9");

		 */

		

		i = 1;

		while(i<6){

			System.out.println((2*i)-1);

			i++;

		}

		

		i = 1;

		while(i<10){

			System.out.println(i);

			i = i+2;

		}

		/*

        System.out.println("1"); //0+1

        System.out.println("3"); //0+1+2

        System.out.println("6"); //0+1+2+3

        System.out.println("10");//0+1+2+3+4

        System.out.println("15");//0+1+2+3+4+5

		 */

		int sum = 0;

		i = 1;

		while(i<=10){

			sum += i; // sum = sum+i;  += -> 우측의 값을 좌측변수값과 더한 후 변수에 저장

			i++;        

			System.out.println(sum);

		}

		System.out.println("1부터 10까지의 합:" + sum);

		

		

		//피보나치 수열(이전숫자와 이전이전숫자의 합) : 1, 1, 2, 3, 5, 8, 13, 21, 34, 55

		System.out.println("피보나치 수열 10개를 출력");
		

		i=0;   // i 반복을 실행할 수

		int first = 1; // 앞앞수

		int second = 0; // 앞수

		int third = 0; // 현재수

		while(i < 10){

			third = first + second;

			if(i>0){

				System.out.print(", ");

			}

			System.out.print(third);

			first = second;

			second = third;

			i++;

	

		}

		System.out.println();

		

		System.out.println("알파벳 대문자 A~Z 출력");

		char al = 'A'; //al 변수값을 바꾸지 않고 출력하기

		i = 0;

		/* System.out.println((char)(al+0)); //알파벳a 아스키코드 10진법 65

        System.out.println((char)(al+1)); */

		

		while( (al+i)<= 'Z' ){

			System.out.println((char)(al+i));

			i++;

		}     

		//al변수값을 바꾸고 출력하기

		while(al <= 'Z' ){

			System.out.println( al );

			//al =(char)(a1 + 1);

			//al += 1;

			al++;

		}

		

		//1

		//2

		//3

		//4

		//5
		
		//1

		//22

		//333

		//4444

		//55555


		i=1;

		while( i <= 5){

			int j = 0;

			while(j<i){

				System.out.print(i);

				j++;

			}

			System.out.println();

			i++;

		}

		

		//*

		//**

		//***

		//****

		//*****
		
		
		i=1;

		while( i <= 5){

			int j = 0;

			while(j<i){

				System.out.print('*');

				j++;

			}

			System.out.println();

			i++;

		}



		System.out.println("구구단2단~5단");

		int dan = 2; //2단

	

		while(dan <=5){

			i = 1; // 1~9

			while(i<=9){

				System.out.print(dan*i + " ");

				i++;

			}

			System.out.println();

			dan++;

		}         

		

		System.out.println(">>반복문 for<<");

	

		for(i = 0; i < 5; i++ ){

			System.out.println("Hi");

			

		}

		

		

		for(i = 0; i < 5; i++ ){

			System.out.println(i);

		}

		

		for(i=0; i < 5; ){

			i++; // 초기식(i=0), 증감식(i++;) for문괄호안에서 생략하고 블럭에 내려도 가능

			System.out.println( i );

			//System.out.println( ++i );

		}

		

		for(sum=0, i = 1; i<=10; sum += i, i++){

			System.out.println(sum);

		}

		System.out.println("1부터 10까지의 합:" + sum);

		

		

		//피보나치 수열(이전숫자와 이전이전숫자의 합) : 1, 1, 2, 3, 5, 8, 13, 21, 34, 55

		System.out.println("피보나치 수열 10개를 출력");

		

		

		first = 1; // 앞앞수

		second = 0; // 앞수

		third = 0;

		for(i=0; i < 10; i++){

			third = first + second;

			if(i>0){

				System.out.print(", ");

			}

			System.out.print(third);

			first = second;

			second = third;
	

		}
		
		System.out.println("알파벳 대문자 A~Z 출력");

		al = 'A'; //al 변수값을 바꾸지 않고 출력하기


		for(i=0; (al+i)<= 'Z' ;i++){

			System.out.println((char)(al+i));
			

		}     

		//al변수값을 바꾸고 출력하기

		for(al ='A',i=0; (al+i) <= 'Z'; i++ ){

			System.out.println( (char)(al+i) );

		}

		

		System.out.println(">>반복문 제어<<");

		al = 'A';

		i = 0;

		while(true) {

			System.out.println((char)(al+i));

			if(al+i=='Z') {

				break; 

			}

			i++;

		}

		

		for(i=1; i <= 5;i++){

			if(i == 3) {

				continue;}

		}

		//    continue -> 반복문 건너뛰기 컨티뉴 다음구문 건너뛰고 증감식으로감

		for(int j=0; j<i; j++){

			System.out.print(i);

		}

		System.out.println();

		

		

		System.out.println("구구단2단~5단.7의 배수는 출력하지 않습니다");

		for(dan=2; dan <=5; dan++){

			for(i=1;i<=9;i++){

				if((dan*i)%7 ==0) {

					continue;

				}

				System.out.print(dan*i + " ");

			}
			
		
			System.out.println();			
			
	
		}
		

		System.out.println("do while반복문"); // do{}먼저수행 이후 while();수행. 최소 1회이상 실행

		java.util.Scanner sc=new java.util.Scanner(System.in);

		// while(true) {

		// System.out.println("중지하려면 quit을 입력하세요:");

		// String keyboard = sc.nextLine(); //자바스트링 비교할땐 equals 이용. ==X

		// System.out.println("입력한 값은" + keyboard + "입니다");

		// if(keyboard.equals ("quit")) {

		// break;

		// }

		//break를 권장하지 않기때문에 while-> do while구문

		String keyboard;

		do {

			System.out.println("중지하려면 quit을 입력하세요:");

			keyboard = sc.nextLine(); //자바스트링 비교할땐 equals 이용. ==X

			System.out.println("입력한 값은" + keyboard + "입니다");

		}
		
			while(!keyboard.equals ("quit"));
			//블럭내에서 선언한 변수는 그 블럭 안에서만 쓸수있다.

			//do블럭에 선언한 keyboard변수를 while에서 사용불가-> do바깥에 String keyboard선언하면 do, while 둘다사용 가능
	
	}
	
}