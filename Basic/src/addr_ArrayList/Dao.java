package addr_ArrayList;

import java.util.ArrayList;

public interface Dao {
	void insert(Person p);
	
	Person select(String name);
	
	int select2(String name);
	
	void delete(String name);
	
	ArrayList<Person> selectAll();
}
