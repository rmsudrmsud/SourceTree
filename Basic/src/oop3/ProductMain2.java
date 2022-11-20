package oop3;

class Product{ //공통적으로 등장하는멤버 정의
	public String name;
	public int price; 
	public int point;	
}

class Tv extends Product{
	public Tv() {
		name = "tv";
		price = 100;
		point = 10;
	}
}
class Audio extends Product{
	public Audio() {
		name = "Audio";
		price = 200;
		point = 20;
	}
}
class Computer extends Product{
	public Computer() {
		name = "Computer";
		price = 300;
		point = 30;
	}
}

class Buyer{
	public int money;
	public int point;
	
	public Buyer() {
		money = 1000;
		point = 0;
	}
	
	// 업캐스팅을 활용한 다형성 구현 .티비 오디오 컴퓨터 누구살지 모르니까 상위클래스로
	public void buy(Product p) { 
		if (money >= p.price) {
			System.out.println(p.name+" 구매");
			money -= p.price;
			point += p.point;
			System.out.println("잔액:" + money);
			System.out.println("적립된 포인트:" + point);
		} else {
			System.out.println("잔액부족");
		}
	}
}
public class ProductMain2 {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		Product[] prods = {new Tv(), new Audio(), new Computer(),
				new Tv(), new Audio(), new Computer(),
				new Tv(), new Audio(), new Computer()};
		
		for(Product p:prods) {
			b.buy(p);
		}
	}
}
