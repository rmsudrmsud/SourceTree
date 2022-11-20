package oop2;



public class Member {

	private String id;

	private int num;

	private String pwd;



	public Member() { //생성자



	}



	public Member(String id, int num, String pwd) {  // constructor using field

		this.id = id;

		this.num = num;

		this.pwd = pwd;

	}





	//setter : private 멤버에 값 설정 메서드

	//private 멤버에 할당할 값을 파라메터로 받아서 멤버변수에 저장

	//setter의 형태 : void set멤버변수이름(멤버변수타입 변수명){}

	public void setId(String id) {

		this.id = id; //현재멤버변수 id에 파라메터로받은 id 값 넣기

	}



	public void setNum(int num) {

		this.num= num;

	}






	public void setPwd(String pwd) {

		this.pwd = pwd;

	}

	//getter : private 멤버에 값을 반환

	//private 멤버에 값을 리턴

	//getter의 형태 : 멤버변수타입 get멤버변수이름(){return 멤버변수;}

	public String getId() {

		return id;

	}



	public int getNum() {

		return num;

	}



	public String getPwd() {

		return pwd;

	}



	@Override //상속받은 메서드 수정.

	//소스메뉴 generate toString
	public String toString() {
		
		// return "클래스명@참조값";

		return "Member [id=" + id + ", num=" + num + ", pwd=" + pwd + "]";

	}

}