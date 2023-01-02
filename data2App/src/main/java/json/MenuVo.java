package json;

public class MenuVo {
	private String menuName;
	private String price;
	private String area;
	private String routeName;
	private String direction;

	public MenuVo() {
	}

	public MenuVo(String menuName, String price, String area, String routeName, String direction) {
		this.menuName = menuName;
		this.price = price;
		this.area = area;
		this.routeName = routeName;
		this.direction = direction;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "MenuVo [menuName=" + menuName + ", price=" + price + ", area=" + area + ", routeName=" + routeName
				+ ", direction=" + direction + "]";
	}

}
