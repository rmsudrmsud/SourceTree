package togetherRep;

import java.sql.Date;

public class TogetherRepVo {
	private int travel_rep_num;
	private int travel_num;
	private String id;
	private String content;
	private Date date;

	TogetherRepVo(){

	}

	public TogetherRepVo(int travel_rep_num, int travel_num, String id, String content, Date date) {

		this.travel_rep_num = travel_rep_num;
		this.travel_num = travel_num;
		this.id = id;
		this.content = content;
		this.date = date;
	}

	/**
	 * @return the travel_rep_num
	 */
	public int getTravel_rep_num() {
		return travel_rep_num;
	}

	/**
	 * @param travel_rep_num the travel_rep_num to set
	 */
	public void setTravel_rep_num(int travel_rep_num) {
		this.travel_rep_num = travel_rep_num;
	}

	/**
	 * @return the travel_num
	 */
	public int getTravel_num() {
		return travel_num;
	}

	/**
	 * @param travel_num the travel_num to set
	 */
	public void setTravel_num(int travel_num) {
		this.travel_num = travel_num;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "TravelRepVo [travel_rep_num=" + travel_rep_num + ", travel_num=" + travel_num + ", id=" + id
				+ ", content=" + content + ", date=" + date + "]";
	}


}
