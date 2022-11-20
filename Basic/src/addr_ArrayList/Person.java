package addr_ArrayList;

import java.io.Serializable;

public class Person implements Serializable{
	private String name;
	private String tel;
	private String address;

	// 생성자
	Person() {
	}

	Person(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
//=================================================//
	//equals : 객체끼리 같은지 아닌지 비교. name 
	//Object : 자바에서 기본으로 제공하는 조상클래. 따로만들지 않아도 기본적으로 존재.
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Person) {
			Person p = (Person)obj;
			if(name.equals(p.name)) {
				return true;
			}
		}
		return false;
		
	}
//=================================================//
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", tel=" + tel + ", address=" + address + "]";
	}


}