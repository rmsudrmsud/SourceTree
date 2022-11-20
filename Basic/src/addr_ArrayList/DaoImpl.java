package addr_ArrayList;

import java.util.ArrayList;

public class DaoImpl implements Dao {
	
	private ArrayList<Person> list;
	
	public DaoImpl() {
		list = new ArrayList<>();
	}
	
	public ArrayList<Person> selectAll(){
		return list;
	}
	
	@Override
	public void insert(Person p) {
		// TODO Auto-generated method stub
		list.add(p);
	}

	@Override
	public Person select(String name) {
		// TODO Auto-generated method stub
		for(Person p:list) {
			if(name.equals(p.getName())) {
				return p;
			}
		}
		return null;
	}

	@Override
	public int select2(String name) {
		// TODO Auto-generated method stub
		for(int i=0;i<list.size();i++) {
			Person p = list.get(i);
			if(name.equals(p.getName())) {
				return i;
			}
		}
		return 0;
	}

	@Override
	public void delete(String name) {
		// TODO Auto-generated method stub
		int idx= select2(name);
		if(idx<0) {
			System.out.println("없는 이름, 삭제취소 ");
		}else {
			list.remove(idx);
		}
	}

}
