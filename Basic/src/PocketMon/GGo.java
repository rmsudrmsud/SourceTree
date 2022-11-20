package PocketMon;

public class GGo extends PocketMon {

	protected String name;

	protected int hp;

	protected int exp;

	protected int lv;


	public GGo() {

		hp = 40;

		name = "GGo";

		System.out.println(name + "생성됨");

	}



	@Override

	public void eat() {

		// TODO Auto-generated method stub

		super.eat();

		hp += 10;

	}



	@Override

	public void sleap() {

		// TODO Auto-generated method stub

		super.sleap();

		hp += 15;

	}



	@Override

	public boolean play() {

		// TODO Auto-generated method stub

		super.play();

		hp -= 15;

		exp += 15;

		levelCheck();

		return hp >0;

	}



	@Override

	public boolean exc() {

		// TODO Auto-generated method stub

		super.exc();

		hp -= 20;

		exp += 20;

		levelCheck();

		return hp>0;

	}


	@Override

	public void levelCheck() {

		// TODO Auto-generated method stub

		super.levelCheck();

		if(exp>=25) {

			lv++;

			exp -=25;

			System.out.println(name+"레벨이 1 증가");

		}

	}



	public void 물대포() {

		System.out.println("물대포 공격");

	}



}