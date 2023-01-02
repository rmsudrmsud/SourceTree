package Question_rep;

import java.sql.Date;

public class Question_rep_Vo {

	private int question_rep_num;
	private int question_num;
	private String id;
	private String content;
	private Date wdate;
	
	public Question_rep_Vo() {}
	
	public Question_rep_Vo(int question_rep_num, int question_num, String id, String content, Date wdate) {
		
		this.question_rep_num = question_rep_num;
		this.question_num = question_num;
		this.id = id;
		this.content = content;
		this.wdate = wdate;
	}

	public int getQuestion_rep_num() {
		return question_rep_num;
	}

	public void setQuestion_rep_num(int question_rep_num) {
		this.question_rep_num = question_rep_num;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	@Override
	public String toString() {
		return "Question_rep_Vo [question_rep_num=" + question_rep_num + ", question_num=" + question_num + ", id=" + id
				+ ", content=" + content + ", wdate=" + wdate + "]";
	}
	
	
	
}
