package cityinfo;

public class CityInfoVo {
	private int city_num;
	private String name;
	private String id;
	public CityInfoVo() {
		
	}
	public CityInfoVo(int city_num, String name, String id) {
		super();
		this.city_num = city_num;
		this.name = name;
		this.id = id;
	}
	public int getCity_num() {
		return city_num;
	}
	public void setCity_num(int city_num) {
		this.city_num = city_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "CityInfoVo [city_num=" + city_num + ", name=" + name + ", id=" + id + "]";
	}
	
}