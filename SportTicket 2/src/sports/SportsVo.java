package sports;

import java.sql.Date;

public class SportsVo {
	int sport_seq;
	String name;
	String spo_date;
	String location;
	String team;
	String text;
	
	public SportsVo(){}
	public SportsVo(int sport_seq, String name, String spo_date, String location, String team, String text) {
		super();
		this.sport_seq = sport_seq;
		this.name = name;
		this.spo_date = spo_date;
		this.location = location;
		this.team = team;
		this.text = text;
	}
	public int getSport_seq() {
		return sport_seq;
	}
	public void setSport_seq(int sport_seq) {
		this.sport_seq = sport_seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpo_date() {
		return spo_date;
	}
	public void setSpo_date(String spo_date) {
		this.spo_date = spo_date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getText() {
		return text;
	}
	public void setTxt(String txt) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "SportsVo [sport_seq=" + sport_seq + ", name=" + name + ", spo_date=" + spo_date + ", location="
				+ location + ", team=" + team + ", text=" + text + "]";
	}


}