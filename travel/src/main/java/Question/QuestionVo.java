package Question;

import java.sql.Date;
import java.util.ArrayList;

import Question_rep.Question_rep_Vo;

public class QuestionVo {

	private int question_num;
	private String id;
	private String title;
	private String content;
	private String img_path;
	private Date wdate;
	private ArrayList<Question_rep_Vo> reps;
	
	public QuestionVo() {}
	
	public QuestionVo(int question_num, String id, String title, String content, String img_path, Date wdate) {
	
		this.question_num = question_num;
		this.id = id;
		this.title = title;
		this.content = content;
		this.img_path = img_path;
		this.wdate = wdate;
	}

	public int getQuestion_num() {
		return question_num;
	}

	public void setQuestion_num(int question_num) {
		this.question_num = question_num;
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
	
	public ArrayList<Question_rep_Vo> getReps() {
		return reps;
	}

	public void setReps(ArrayList<Question_rep_Vo> reps) {
		this.reps = reps;
	}

	@Override
	public String toString() {
		return "QuestionVo [question_num=" + question_num + ", id=" + id + ", title=" + title + ", content=" + content
				+ ", img_path=" + img_path + ", wdate=" + wdate + ", reps=" + reps + "]";
	}


	
	
	
}
