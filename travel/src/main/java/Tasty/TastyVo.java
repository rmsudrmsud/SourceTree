package Tasty;

import java.sql.Date;

public class TastyVo {

	private int tasty_num;
	private String id;
	private int city_num;
	private String title;
	private String content;
	private String img_path;
	private Date wdate;
	
	public TastyVo() {}
	
	

	public TastyVo(int tasty_num, String id, int city_num, String title, String content, String img_path, Date wdate) {
		
		this.tasty_num = tasty_num;
		this.id = id;
		this.city_num = city_num;
		this.title = title;
		this.content = content;
		this.img_path = img_path;
		this.wdate = wdate;
	}


	public int getTasty_num() {
		return tasty_num;
	}

	public void setTasty_num(int tasty_num) {
		this.tasty_num = tasty_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCity_num() {
		return city_num;
	}

	public void setCity_num(int city_num) {
		this.city_num = city_num;
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
		return "TastyVo [tasty_num=" + tasty_num + ", id=" + id + ", city_num=" + city_num + ", title=" + title
				+ ", content=" + content + ", img_path=" + img_path + ", wdate=" + wdate + "]";
	}

}
