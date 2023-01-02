package csv;
//년월,요일,상_하행,열차번호,출발역,출발시간,도착역,도착시간,혼잡도,재차인원,영업일,최고혼잡역
public class Csv1Vo {
	private int cnt;
	private String yy_mon;
	private String cday;
	private String derection;
	private String num;
	private String cstart;
	private String start_time;
	private String cend;
	private String end_time;
	private String clevel;
	private String people_num;
	private String date2;
	private String station;
	
	public Csv1Vo() {
		
	}

	public Csv1Vo(int cnt, String yy_mon, String cday, String derection, String num, String cstart, String start_time,
			String cend, String end_time, String clevel, String people_num, String date2, String station) {
		super();
		this.cnt = cnt;
		this.yy_mon = yy_mon;
		this.cday = cday;
		this.derection = derection;
		this.num = num;
		this.cstart = cstart;
		this.start_time = start_time;
		this.cend = cend;
		this.end_time = end_time;
		this.clevel = clevel;
		this.people_num = people_num;
		this.date2 = date2;
		this.station = station;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getYy_mon() {
		return yy_mon;
	}

	public void setYy_mon(String yy_mon) {
		this.yy_mon = yy_mon;
	}

	public String getCday() {
		return cday;
	}

	public void setCday(String cday) {
		this.cday = cday;
	}

	public String getDerection() {
		return derection;
	}

	public void setDerection(String derection) {
		this.derection = derection;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getCstart() {
		return cstart;
	}

	public void setCstart(String cstart) {
		this.cstart = cstart;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getCend() {
		return cend;
	}

	public void setCend(String cend) {
		this.cend = cend;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getClevel() {
		return clevel;
	}

	public void setClevel(String clevel) {
		this.clevel = clevel;
	}

	public String getPeople_num() {
		return people_num;
	}

	public void setPeople_num(String people_num) {
		this.people_num = people_num;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	@Override
	public String toString() {
		return "Csv1Vo [cnt=" + cnt + ", yy_mon=" + yy_mon + ", cday=" + cday + ", derection=" + derection + ", num="
				+ num + ", cstart=" + cstart + ", start_time=" + start_time + ", cend=" + cend + ", end_time="
				+ end_time + ", clevel=" + clevel + ", people_num=" + people_num + ", date2=" + date2 + ", station="
				+ station + "]";
	}
	
}
