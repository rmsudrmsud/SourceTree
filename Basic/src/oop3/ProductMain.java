package oop3;

//class Tv {
//	public int price;
//	public int point;
//
//	public Tv() {
//		price = 100;
//		point = 10;
//	}
//}
//
//class Audio {
//	public int price;
//	public int point;
//
//	public Audio() {
//		price = 200;
//		point = 20;
//	}
//}
//
//class Computer {
//	public int price;
//	public int point;
//
//	public Computer() {
//		price = 300;
//		point = 30;
//	}
//}
//
//class Buyer {
//	public int money;
//	public int point;
//
//	public Buyer() {
//		money = 1000;
//		point = 0;
//	}
//
//	
//	// 오버로딩으로 구현한 다형성
//	public void buy(Tv tv) {
//		if (money >= tv.price) {
//			System.out.println("tv 구매");
//			money -= tv.price;
//			point += tv.point;
//			System.out.println("잔액:" + money);
//			System.out.println("적립된 포인트:" + point);
//		} else {
//			System.out.println("잔액부족");
//		}
//	}
//
//	public void buy(Audio a) {
//		if (money >= a.price) {
//			System.out.println("Audio 구매");
//			money -= a.price;
//			point += a.point;
//			System.out.println("잔액:" + money);
//			System.out.println("적립된 포인트:" + point);
//		} else {
//			System.out.println("잔액부족");
//		}
//	}
//
//	public void buy(Computer c) {
//		if (money >= c.price) {
//			System.out.println("Computer 구매");
//			money -= c.price;
//			point += c.point;
//			System.out.println("잔액:" + money);
//			System.out.println("적립된 포인트:" + point);
//		} else {
//			System.out.println("잔액부족");
//		}
//	}
//}

public class ProductMain {
        
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Audio());
		b.buy(new Computer());
	}

}