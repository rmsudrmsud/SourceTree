package order;

import Product.ProductVo;

public class OrderVo {
	private int num;
	private ProductVo prod;
	private int amount;
	private int payment;
	private boolean pay;
	private boolean out;
	private String orderId;//주문자id
	private static int cnt;

	public OrderVo() {
	}

	public OrderVo(ProductVo prod, int amount, int payment, String orderId) {
		this.num = ++cnt;
		this.prod = prod;
		this.amount = amount;
		this.payment = payment;
		this.orderId = orderId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public ProductVo getProd() {
		return prod;
	}

	public void setProd(ProductVo prod) {
		this.prod = prod;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public boolean isPay() {
		return pay;
	}

	public void setPay(boolean pay) {
		this.pay = pay;
	}

	public boolean isOut() {
		return out;
	}

	public void setOut(boolean out) {
		this.out = out;
	}

	@Override
	public String toString() {
		return "OrderVo [num=" + num + ", prod=" + prod + ", amount=" + amount + ", payment=" + payment + ", pay=" + pay
				+ ", out=" + out + "]";
	}

}
