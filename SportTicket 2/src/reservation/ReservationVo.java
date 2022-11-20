package reservation;

import java.sql.Date;

public class ReservationVo {
	int res_seq;
	String memId;
	int sport_seq;
	String res_num;
	int payment;
	int price;
	Date date;

	public ReservationVo() {
	}

	public ReservationVo(int res_seq, String memId, int sport_seq, String res_num, int payment, int price, Date date) {
		super();
		this.res_seq = res_seq;
		this.memId = memId;
		this.sport_seq = sport_seq;
		this.res_num = res_num;
		this.payment = payment;
		this.price = price;
		this.date = date;
	}

	public int getRes_seq() {
		return res_seq;
	}

	public void setRes_seq(int res_seq) {
		this.res_seq = res_seq;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public int getSport_seq() {
		return sport_seq;
	}

	public void setSport_seq(int sport_seq) {
		this.sport_seq = sport_seq;
	}

	public String getRes_num() {
		return res_num;
	}

	public void setRes_num(String res_num) {
		this.res_num = res_num;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ReservationVo [res_seq=" + res_seq + ", memId=" + memId + ", sport_seq=" + sport_seq + ", res_num="
				+ res_num + ", payment=" + payment + ", price=" + price + ", date=" + date + "]";
	}
}