package PocketMon2;

public class Picachu extends PocketMon {
	
	public Picachu() {
		hp = 30;
		name = "피카츄";
		System.out.println(name + "생성됨");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("피카츄 밥먹음");
		hp += 5;
	}

	@Override
	public void sleap() {
		// TODO Auto-generated method stub
		System.out.println("피카츄 잠");
		hp += 5;
	}

	@Override
	public boolean play() {
		// TODO Auto-generated method stub
		System.out.println("피카츄 논다");
		hp -= 5;
		exp += 5;
		levelCheck();
		return hp>0;
		
	}

	@Override
	public boolean exc() {
		// TODO Auto-generated method stub
		System.out.println("피카츄 dnsehd");
		hp -= 10;
		exp += 10;
		levelCheck();
		return hp>0;
	}

	@Override
	public void levelCheck() {
		if(exp>=20) {
			lv++;
			exp-=20;
			System.out.println("피카츄 레벨 1올라감");
		}
		// TODO Auto-generated method stub

	}

}
