package guestbook;

import java.util.ArrayList;

public class GuestBookService {
	private GuestBookDao dao;
	
	public GuestBookService() {
		dao = new GuestBookDao();
	}
	
	public void addBook(GuestBookVo vo) {
		dao.insert(vo);
	}
	
	public GuestBookVo getBook(int num) {
		return dao.select(num);
	}
	
	public ArrayList<GuestBookVo> getAll(){
		return dao.selectAll();
	}
	
	public void editBook(GuestBookVo vo) {
		dao.update(vo);
	}
	
	public void delBook(int num) {
		dao.delete(num);
	}
}
