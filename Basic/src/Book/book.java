package Book;

public class book {
	private int num;
	private String title;
	private String type;
	private String writer;
	private String company;
	
	public book() {}
	public book(int num, String title, String type, String writer, String company) {
		this.num = num;
		this.title = title;
		this.type = type;
		this.writer = writer;
		this.company = company;
		
		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "book [num=" + num + ", title=" + title + ", type=" + type + ", writer=" + writer + ", company="
				+ company + "]";
	}
	
	

}
