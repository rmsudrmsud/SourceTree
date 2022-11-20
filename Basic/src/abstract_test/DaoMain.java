package abstract_test;

public class DaoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Service service = new Service(new DaoImplOracle());
		service.add();
		service.get();
		service.edit();
		service.delete();
	}

}
