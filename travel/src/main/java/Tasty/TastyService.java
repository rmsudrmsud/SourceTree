package Tasty;

import java.util.ArrayList;

public class TastyService {

	private TastyDao dao;
	public TastyService() {
		dao = new TastyDao();
	}
	
	public void addTasty(TastyVo vo) {
		dao.insert(vo);
	}
	
	public ArrayList<TastyVo> getTasty(int city_num) {
		return dao.select(city_num);
	}
	
	public ArrayList<TastyVo> getAll(){
		return dao.selectAll();
	}
	
	public TastyVo getByTastyNum(int tasty_num) {
		return dao.selectByTastyNum(tasty_num);
	}
	
	public ArrayList<TastyVo> getByTitle(int city_num, String title){
		return dao.selectByTitle(city_num, title);
	}
	
	public void editTasty(TastyVo vo) {
		dao.update(vo);
	}
	
	public void delTasty(int num) {
		dao.delete(num);
	}
}
