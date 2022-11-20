package product;

//모든 멤버는 private
//생성자, setter, getter, toString() 
//int num(자동할당), String name, int price, int amount
public class ProductVo {
	private int num;
	private String name;
	private int price;
	private int amount;
	private static int cnt;

	public ProductVo() {
	}
	//등록용 생성자
	public ProductVo(String name, int price, int amount) {
		this.num = ++cnt;//제품번호 자동할당
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	public ProductVo(int num, String name, int price, int amount) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ProductVo [num=" + num + ", name=" + name + ", price=" + price + ", amount=" + amount + "]";
	}

}
