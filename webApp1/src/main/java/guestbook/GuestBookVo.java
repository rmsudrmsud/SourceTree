package guestbook;

import java.sql.Date;

public class GuestBookVo {
	private int num;
	private String writer;
	private Date w_date;
	private String pwd;
	private String content;
	public GuestBookVo() {}
	public GuestBookVo(int num, String writer, Date w_date, String pwd, String content) {
		this.num = num;
		this.writer = writer;
		this.w_date = w_date;
		this.pwd = pwd;
		this.content = content;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getW_date() {
		return w_date;
	}
	public void setW_date(Date w_date) {
		this.w_date = w_date;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "GuestBookVo [num=" + num + ", writer=" + writer + ", w_date=" + w_date + ", pwd=" + pwd + ", content="
				+ content + "]";
	}
}
