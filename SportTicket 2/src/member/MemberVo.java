package member;

public class MemberVo {

	private String memId;
	private String pwd;
	private String email;
	private String addr;
	private int blackList;
	private String name;
	private int master; 
	
	public MemberVo() {}
	public MemberVo(String memId, String pwd, String email, String addr, int blackList, String name, int master) {
		super();
		this.memId = memId;
		this.pwd = pwd;
		this.email = email;
		this.addr = addr;
		this.blackList = blackList;
		this.name = name;
		this.master = master;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getBlackList() {
		return blackList;
	}
	public void setBlackList(int blackList) {
		this.blackList = blackList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaster() {
		return master;
	}
	public void setMaster(int master) {
		this.master = master;
	}
	
	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", pwd=" + pwd + ", email=" + email + ", addr=" + addr + ", blackList="
				+ blackList + ", name=" + name + ", master=" + master + "]";
	}

}// MemberVO