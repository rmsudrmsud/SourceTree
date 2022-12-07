package imgboard.rep;

public class Rep {
	private int num;
	private String writer;
	private String content;
	private int parent;
	
	public Rep() {
		
	}

	public Rep(int num, String writer, String content, int parent) {
		super();
		this.num = num;
		this.writer = writer;
		this.content = content;
		this.parent = parent;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Rep [num=" + num + ", writer=" + writer + ", content=" + content + ", parent=" + parent + "]";
	}
	
	
}
