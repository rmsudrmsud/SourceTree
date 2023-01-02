package review;

import java.sql.Date;
import java.util.ArrayList;

import review_rep.ReviewRepVo;

public class ReviewVo {
	private int review_num;
	private int city_num;
	private String id;
	private String title;
	private String content;
	private String img_path;
	private Date date;
	private ArrayList<ReviewRepVo> reps;
	
	public ReviewVo() {}

	public int getReview_num() {
		return review_num;
	}

	public void setReview_num(int review_num) {
		this.review_num = review_num;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ArrayList<ReviewRepVo> getReps() {
		return reps;
	}

	public void setReps(ArrayList<ReviewRepVo> reps) {
		this.reps = reps;
	}

	public ReviewVo(int review_num, int city_num, String id, String title, String content, String img_path, Date date) {
		super();
		this.review_num = review_num;
		this.city_num = city_num;
		this.id = id;
		this.title = title;
		this.content = content;
		this.img_path = img_path;
		this.date = date;
	}

	@Override
	public String toString() {
		return "ReviewVo [review_num=" + review_num + ", city_num=" + city_num + ", id=" + id + ", title=" + title
				+ ", content=" + content + ", img_path=" + img_path + ", date=" + date + "]";
	}
	
}
