package movie;

import java.util.Arrays;

public class PeopleVo {
	private String pcode;
	private String name;
	private String[] filmos;

	public PeopleVo() {
	}

	public PeopleVo(String pcode, String name, String[] filmos) {
		this.pcode = pcode;
		this.name = name;
		this.filmos = filmos;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getFilmos() {
		return filmos;
	}

	public void setFilmos(String[] filmos) {
		this.filmos = filmos;
	}

	@Override
	public String toString() {
		return "PeopleVo [pcode=" + pcode + ", name=" + name + ", filmos=" + Arrays.toString(filmos) + "]";
	}

}
