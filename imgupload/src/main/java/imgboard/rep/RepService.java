package imgboard.rep;

import java.util.ArrayList;

public class RepService {
	private RepDao dao;

	public RepService() {
		dao = new RepDao();
	}
	
	public void addRep(Rep r) {
		dao.insert(r);
	}
	
	public Rep getRep(int num) {
		return dao.select(num);
	}
	
	public ArrayList<Rep> getAll(int parent){
		return dao.selectAll(parent);
	}
	
	public void editRep(Rep r) {
		dao.update(r);
	}
	
	public void delRep(int num) {
		dao.delete(num);
	}
}
