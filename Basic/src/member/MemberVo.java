package member;

//클래스. 멤버변수와 메서드로 구성
//멤버변수:값 저장(객체가 갖는 정보들을 담기위해)
//메서드: 기능. vo:멤버변수 읽고 쓰기
//vo: 멤버변수, 생성자, setter, getter, toString
//멤버변수의 접근제어자는 private사용. 정보 보호 => 타 클래스에서 접근 불가
//=> 그래서 setter, getter 필요
//생성자:객체 초기화 메서드. 클래스와 동일한 이름과 반환타입 없는 형태. 
//파라메터 자유. 호출은 생성시에만. 
//생성자를 하나라도 정의하면 컴파일러가 자동 생성해주는 생성자는 없다. 
//그래서 파람없는 생성자를 꼭 작성
public class MemberVo {
	private String id;
	private String pwd;
	private String email;
	private String tel;

	public MemberVo() {
	}

	public MemberVo(String id, String pwd, String email, String tel) {
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.tel = tel;
		//this: 현재 객체의 참조값을 갖는 참조변수. 클래스 정의 시에만 사용
		//멤버변수와 지역변수 이름이 동일한 경우 멤버변수를 구분하기위해 사용
	}

	//메서드: 반복적으로 사용되는 코드를 모듈화
	//필요시 호출하여 사용
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	//Override: 상속받은 메서드를 재정의(수정해서 사용)
	//자바의 모든 클래스는 Object를 상속받는다
	//Object: equals(), toString() ..
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", pwd=" + pwd + ", email=" + email + ", tel=" + tel + "]";
	}

}
