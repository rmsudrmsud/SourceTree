package review_rep;

import java.sql.Date;

public class ReviewRepVo {
	private int review_rep_num;
	private int review_num;
	private String id;
	private String content;
	private Date date;
	
	public int getReview_rep_num() {
		return review_rep_num;
	}
	public void setReview_rep_num(int review_rep_num) {
		this.review_rep_num = review_rep_num;
	}
	public int getReview_num() {
		return review_num;
	}
	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ReviewRepVo(int review_rep_num, int review_num, String id, String content, Date date) {
		super();
		this.review_rep_num = review_rep_num;
		this.review_num = review_num;
		this.id = id;
		this.content = content;
		this.date = date;
	}
	@Override
	public String toString() {
		return "ReviewRepVo [review_rep_num=" + review_rep_num + ", review_num=" + review_num + ", id=" + id
				+ ", content=" + content + ", date=" + date + "]";
	}
	
	
	
}
