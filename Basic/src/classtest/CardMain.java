package classtest;


//1. 카드 클래스 만들기(필수)

//카드 정보 : 카드사 명, 카드번호, 소유자 이름, 카드 비밀번호

//데이터셋, 데이터 출력 메서드



class Card{

String cardname, humanname, num, secretnum;



void setData(String c, String n, String h,  String s) {

cardname = c;

num = n;

humanname = h;

secretnum = s;

}



void printData() {

System.out.println("카드사명: "+cardname);

System.out.println("카드번호: "+num);

System.out.println("소유자 이름: "+humanname);

System.out.println("카드 비밀번호: "+secretnum);

}



}

public class CardMain {



public static void main(String[] args) {

//TODO Auto-generated method stub

Card c1= new Card();

c1.setData("신한카드","22","철수","0000");

c1.printData();



}



}