package abstract_test;

public class Service {
	//인터페이스 타입. 업캐스팅
	private Dao dao;
	
	//생성자. 의존성 주입 코드가 하나에 의존하지 않기 때문에 유지보수에 편함
	public Service(Dao dao) {
		this.dao = dao;
	}
	
	public void add() {
		dao.insert();
	}
	
	public void get() {
		dao.insert();
	}
	
	public void edit() {
		dao.insert();
	}
	
	public void delete() {
		dao.insert();
	}
	
	
}
