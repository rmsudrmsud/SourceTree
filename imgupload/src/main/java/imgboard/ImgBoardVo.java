package imgboard;

import java.sql.Date;
import java.util.ArrayList;

import imgboard.rep.Rep;

public class ImgBoardVo {
	private int num;
	private String writer;
	private Date w_date;
	private String title;
	private String content;
	private String img_path;
	private ArrayList<Rep> reps;
	
	public ArrayList<Rep> getReps() {
		return reps;
	}

	public void setReps(ArrayList<Rep> reps) {
		this.reps = reps;
	}

	public ImgBoardVo() {
		
	}
	
	public ImgBoardVo(int num, String writer, Date w_date, String title, String content, String img_path) {
		
		this.num = num;
		this.writer = writer;
		this.w_date = w_date;
		this.title = title;
		this.content = content;
		this.img_path = img_path;
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

	@Override
	public String toString() {
		return "ImgBoardVo [num=" + num + ", writer=" + writer + ", w_date=" + w_date + ", title=" + title
				+ ", content=" + content + ", img_path=" + img_path + "]";
	}


	
	
}
