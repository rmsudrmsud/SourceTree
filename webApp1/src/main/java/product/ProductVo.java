package product;

public class ProductVo {
	private int num;
	private String name;
	private int price;
	private int amount;
	private String seller;

	public ProductVo() {
	}

	public ProductVo(int num, String name, int price, int amount, String seller) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.seller = seller;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
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
		return "ProductVo [num=" + num + ", name=" + name + ", price=" + price + ", amount=" + amount + ", seller="
				+ seller + "]";
	}

}
