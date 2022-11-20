package PocketMon;
//피카추 자식클래스생성-> 캐릭터 생성 -> 오버라이드(재정의할 메서드)

public class Picachu extends PocketMon {

	// 캐릭터 초기화,생성자

	public Picachu() {

		hp = 30;

		name = "Picachu";

		System.out.println(name + "생성됨");

		// exp, lv = 0으로시작

	}

	@Override

	public void eat() {

		// TODO Auto-generated method stub

		super.eat(); // 부모객체의 eat

		hp += 5;

	}

	@Override

	public void sleap() {

		// TODO Auto-generated method stub

		super.sleap();

		hp += 10;

	}

	@Override

	public boolean play() {

		// TODO Auto-generated method stub

		super.play();

		hp -= 8; // hp 감소

		exp += 8;

		levelCheck();

		return hp > 0; // hp가 0초과 이어야 생존.

	}

	@Override

	public boolean exc() {

		// TODO Auto-generated method stub

		super.exc();

		hp -= 15;

		exp += 10;

		levelCheck();

		return hp > 0;

	}

	@Override

	public void levelCheck() {

		// TODO Auto-generated method stub

		super.levelCheck();

		if (exp >= 20) {

			lv++;

			exp -= 20;

			System.out.println(name + "레벨 1 증가");

		}

	}

	public void 백만볼트() {

		System.out.println("백만볼트 공격");

	}

}