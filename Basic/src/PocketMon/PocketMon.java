package PocketMon;

//캐릭터의 공통사항

//name, hp, exp, lv

//eat(), sleep(), play(), exc(), printInfo(), levelCheck()

public class PocketMon {

	protected String name;

	protected int hp;

	protected int exp;

	protected int lv;


	public void eat() {

		System.out.println(name+"밥 먹음");

	}

	public void sleap() {

		System.out.println(name+"잠 자기");

	}

	public boolean play() {

		System.out.println(name+"논다");

		return true; // 살았나 죽었나

	}

	public boolean exc() {

		System.out.println(name+"운동함");

		return true; // 살았나 죽었나

	}



	public void levelCheck() {

		System.out.println(name+"레벨체크");

	}



	public void printInfo() {

		System.out.println(name + "상태확인");

		System.out.println("hp:"+ hp);

		System.out.println("exp:" + exp);

		System.out.println("lv:"+ lv);

	}

}