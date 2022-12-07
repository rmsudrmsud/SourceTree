package download;

import java.sql.Date;

public class DownloadVo {
	private int num;
	private String writer;
	private Date W_date;
	private String title;
	private String content;
	private String down_path;
	private int down_cnt;
	
	public DownloadVo() {
		
	}
	public DownloadVo(int num, String writer, Date w_date, String title, String content, String down_path,
			int down_cnt) {
		super();
		this.num = num;
		this.writer = writer;
		W_date = w_date;
		this.title = title;
		this.content = content;
		this.down_path = down_path;
		this.down_cnt = down_cnt;
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
		return W_date;
	}
	public void setW_date(Date w_date) {
		W_date = w_date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDown_path() {
		return down_path;
	}
	public void setDown_path(String down_path) {
		this.down_path = down_path;
	}
	public int getDown_cnt() {
		return down_cnt;
	}
	public void setDown_cnt(int down_cnt) {
		this.down_cnt = down_cnt;
	}
	@Override
	public String toString() {
		return "DownloadVo [num=" + num + ", writer=" + writer + ", W_date=" + W_date + ", title=" + title
				+ ", content=" + content + ", down_path=" + down_path + ", down_cnt=" + down_cnt + "]";
	}
}
