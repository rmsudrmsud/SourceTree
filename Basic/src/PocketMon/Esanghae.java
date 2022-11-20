package PocketMon;
public class Esanghae extends PocketMon {

	protected String name;

	protected int  hp;

	protected int exp;

	protected int lv;



	public Esanghae() {

		hp = 50;

		name = "E";

		System.out.println(name + "생성됨");

	}



	@Override

	public void eat() {

		// TODO Auto-generated method stub

		super.eat();

		hp += 15;

	}



	@Override

	public void sleap() {

		// TODO Auto-generated method stub

		super.sleap();

		hp += 25;

	}



	@Override

	public boolean play() {

		// TODO Auto-generated method stub

		super.play();

		hp -= 25;

		exp += 25;

		levelCheck();

		return hp >0;

	}



	@Override

	public boolean exc() {

		// TODO Auto-generated method stub

		super.exc();

		hp -= 30;

		exp += 30;

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



	public void 넝쿨공격() {

		System.out.println("넝쿨공격");

	}


}