package PocketMon;

//업 캐스팅 활용!


import java.util.Scanner;



public class Menu{

private PocketMon p; //포켓몬 클래스엔 피카츄 꼬부기 이상해씨 등을 담을수있다 업캐스팅으로



public void select(Scanner sc) {

System.out.println("캐릭터 선택\n 1. 피카츄(기본) 2. 꼬부기 3. 이상해씨");

int ch = sc.nextInt();

switch (ch) {

case 2 :

p = new GGo();

case 3 :

p = new Esanghae();

break;

default:

p = new Picachu();

break;

}

}





public void run(Scanner sc) {

boolean flag=true;

int m;

while(flag) {

System.out.println("1.밥먹기 2.잠자기 3. 놀기 4. 운동하기 5. 상태확인 6. 종료 7. 특기공격");

m = sc.nextInt();

switch(m) {

case 1: p.eat();

break;

case 2: p.sleap();

break;

case 3: flag = p.play();     //hp가 0이되면 사망하고 게임이 종료되어야하니까 flag true false로 비교

      break;

case 4: flag = p.exc();

      break;

case 5: p.printInfo();

break;

case 6: 

flag = false;

break;

case 7:

//instanceof : 양 변의 타입이 일치하면 true, 아니면 false

if(p instanceof Picachu) {

System.out.println("피카츄");

((Picachu)p).백만볼트(); //다운캐스팅 -> 피카츄.백만볼트 공격 출력

}else if(p instanceof GGo) {

System.out.println("꼬부기");

((GGo)p).물대포();

} else if(p instanceof Esanghae) {

System.out.println("이상해씨");

((Esanghae) p).넝쿨공격();

}

//        업캐스팅 다운캐스팅 헷갈릴 때 

//int sum=300;

//float avg = (float)sum/3;

//

//Lee i = new Lee();

//

////업캐스팅. 부모클래스에 정의된 멤버만 사용가능.

//PocketMon pm = new Lee();

//pm.eat(); // 자식클래스에 재정의한 형태로 실행

//pm.play();

//((lee).pm).넝쿨공격();

////pm.넝쿨공격();



break; 

}

}



if(p.hp <= 0) {

System.out.println("캐릭터 사망");

}

System.out.println("게임종료");

}



}