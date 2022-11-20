package addr_ArrayList;

import java.util.ArrayList;

public class DaoImplEqls implements Dao {
	
	private ArrayList<Person> list;
	
	public DaoImplEqls() {
		list = new ArrayList<>();
	}

	@Override
	public void insert(Person p) {
		// TODO Auto-generated method stub
		list.add(p);
	}

	@Override
	public Person select(String name) {
		// TODO Auto-generated method stub
		int idx = select2(name);
		if(idx>=0) {
			return list.get(idx);
		}
		return null;
	}

	@Override
	public int select2(String name) {
		// TODO Auto-generated method stub
		return list.indexOf(new Person(name,"",""));
	}

	@Override
	public void delete(String name) {
		// TODO Auto-generated method stub
	boolean flag = list.remove(new Person(name,"","")); //삭제할 객체 기준이 이름이니까 멤버변수 
	if(flag) {
		System.out.println("삭제완료");
	}else {
		System.out.println("없는이름. 삭제취소함");
	}
	}

	@Override
	public ArrayList<Person> selectAll() {
		// TODO Auto-generated method stub
		return list;
	}

}
