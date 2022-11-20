package test;

import java.sql.Date;

public class test1Vo {
	private int num;
	private String name;
	private String tel;
	private Date joindate;
	
	public test1Vo() {	
	}
	
	public test1Vo(int num, String name, String tel, Date joindate) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
		this.joindate = joindate;
	}
	
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	
	@Override
	public String toString() {
		return "test1Vo [num=" + num + ", name=" + name + ", tel=" + tel + ", joindate=" + joindate + "]";
	}
}
