//11월 3일
package 복습;

//vo : 객체 정보 담는 그릇
public class 수강 {
	// private : 은닉성 제공(보안)
	private int code; // 과목코드
	private String name; // 과목명
	private String profName;// 교수명
	private int cnt;// 수강인원
	private String room;// 강의장

	// 생성자 : 이름이 클래스와 같고 반환타입이 없는 메서드. -> 역할: 객체를 초기화함.멤버변수 초기화.
	// 접근제어자+클래스명+()+{};
	public 수강(int code, String name, String profName, int cnt, String room) {
		this.code = code;
		this.name = name;
		this.profName = profName;
		this.cnt = cnt;
		this.room = room;
	}

	// 메서드를 쓰는이유 :반복적인 기능을 많이 사용할 때 만들어두고 호출해서 사용하기 위해서
	// 값을 설정하는 메서드 : 멤버변수에 파라메터 값들을 할당

	// 메서드 작성. ->접근제어자 반환타입 이름(외부로부터 받아올값(파라메터)){메서드가 할 일}
	// 파라메터는 메서드 호출시 필요한 값을 받아오는 매개변수
	// 파라메터의 이름 맞춰주는게 좋음.이름은꼭 맞지않아도 타입은 꼭 맞춰야함

	// 메서드
	public void setData(int code, String name, String profName, int cnt, String room) {
		// 이 코드에서 setData의 기능 : 5개의 멤버변수에 값을 할당받는기능
		this.code = code;
		this.name = name;
		this.profName = profName;
		this.cnt = cnt;
		this.room = room;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	// profName의 setter
	public void setProfName(String profName) {
		this.profName = profName;
	}

	// profName의 getter
	public String getProfName() { // 함수반환타입 변수타입과 같게하기위해 String
		return profName;
	}

	public void printData() { // this 지역변수와 멤버변수를 구분하기위해사
		System.out.println("code:" + code); // s1을 this 로한이유 현시점에서 객체이름이 없기때문에. this 를 쓰지않아도 가능
		System.out.println("name:" + name);
		System.out.println("profName:" + profName);
		System.out.println("cnt:" + cnt);
		System.out.println("room:" + this.room);
	}

}
