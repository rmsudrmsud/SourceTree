package notice;

import java.sql.Date;

public class NoticeVo {
	private int notice_num;
	private String id;
	private String title;
	private String content;
	private String img_path;
	private Date wdate;
	
	public NoticeVo() {
		
	}
	public NoticeVo(int notice_num, String id, String title, String content, String img_path, Date wdate) {
		super();
		this.notice_num = notice_num;
		this.id = id;
		this.title = title;
		this.content = content;
		this.img_path = img_path;
		this.wdate = wdate;
	}
	public int getNotice_num() {
		return notice_num;
	}
	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	@Override
	public String toString() {
		return "NoticeVo [notice_num=" + notice_num + ", id=" + id + ", title=" + title + ", content=" + content
				+ ", img_path=" + img_path + ", wdate=" + wdate + "]";
	}

	
}