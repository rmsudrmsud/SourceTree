package xml;

import java.util.ArrayList;

public class LocationVo {
	private String city;
	private ArrayList<DataVo> list;

	public LocationVo() {
	}

	public LocationVo(String city, ArrayList<DataVo> list) {
		this.city = city;
		this.list = list;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public ArrayList<DataVo> getList() {
		return list;
	}

	public void setList(ArrayList<DataVo> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "LocationVo [city=" + city + ", list=" + list + "]";
	}

}
