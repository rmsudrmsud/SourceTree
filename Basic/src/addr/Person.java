package addr;

public class Person {
	String name;
	String tel;
	String address;

	// 생성자
	Person() {
	}

	Person(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	void printPerson() {
		System.out.println("name:" + name);
		System.out.println("tel:" + tel);
		System.out.println("address:" + address);
	}
}