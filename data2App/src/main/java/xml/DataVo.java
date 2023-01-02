package xml;

public class DataVo {
	private String date;
	private String weather;
	private String tmn;
	private String tmx;

	public DataVo() {
	}

	public DataVo(String date, String weather, String tmn, String tmx) {
		this.date = date;
		this.weather = weather;
		this.tmn = tmn;
		this.tmx = tmx;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getTmn() {
		return tmn;
	}

	public void setTmn(String tmn) {
		this.tmn = tmn;
	}

	public String getTmx() {
		return tmx;
	}

	public void setTmx(String tmx) {
		this.tmx = tmx;
	}

	@Override
	public String toString() {
		return "DataVo [date=" + date + ", weather=" + weather + ", tmn=" + tmn + ", tmx=" + tmx + "]";
	}

}
