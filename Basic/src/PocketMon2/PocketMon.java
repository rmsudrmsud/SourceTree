package PocketMon2;
//캐릭터의 공통사항
//name, hp, exp, lv
//eat(), sleep(), play(), exc(), printInfo(), levelCheck()
public abstract class PocketMon {
	protected String name;
	protected int hp;
	protected int exp;
	protected int lv;
	
	//PocketMon 클래스는 객체 생성이 아니라 상속을 목적으로 만든 클래스임으로
	//메서드 구현하지 않고 상속 받는 하위클래스에서 재정의해서 사용해라
	//그래서 구현 안해도 됨
	public abstract void eat(); // << 추상 메서드
	public abstract void sleap();
	public abstract boolean play();
	public abstract boolean exc();
	public abstract void levelCheck();
	
	public void printInfo() {
		System.out.println(name + "상태확인");
		System.out.println("hp:"+ hp);
		System.out.println("exp:" + exp);
		System.out.println("lv:"+ lv);
	}
}