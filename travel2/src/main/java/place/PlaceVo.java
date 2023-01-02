package place;

import java.sql.Date;

public class PlaceVo {
	private int place_num;
	private int city_num;
	private String id;
	private String title;
	private String content;
	private String img_path;
	private Date wdate;
	
	public PlaceVo() {}

	public PlaceVo(int place_num, int city_num, String id, String title, String content, String img_path, Date wdate) {
		super();
		this.place_num = place_num;
		this.city_num = city_num;
		this.id = id;
		this.title = title;
		this.content = content;
		this.img_path = img_path;
		this.wdate = wdate;
	}

	public int getPlace_num() {
		return place_num;
	}

	public void setPlace_num(int place_num) {
		this.place_num = place_num;
	}

	public int getCity_num() {
		return city_num;
	}

	public void setCity_num(int city_num) {
		this.city_num = city_num;
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
		return "PlaceVo [place_num=" + place_num + ", city_num=" + city_num + ", id=" + id + ", title=" + title
				+ ", content=" + content + ", img_path=" + img_path + ", wdate=" + wdate + "]";
	}

	
}