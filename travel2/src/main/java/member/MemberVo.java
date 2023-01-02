package member;

public class MemberVo {
	private String id;
	private String pwd;
	private String name;
	private String tel;
	private String email;
	private String birth;

	public MemberVo() {
	}

	public MemberVo(String id, String pwd, String name, String tel, String email, String birth) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.birth = birth;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", pwd=" + pwd + ", name=" + name + ", tel=" + tel + ", email=" + email
				+ ", birth=" + birth + "]";
	}

	

}
