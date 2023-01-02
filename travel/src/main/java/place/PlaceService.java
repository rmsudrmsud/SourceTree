package place;

import java.util.ArrayList;


public class PlaceService {
	private PlaceDao dao;
	
	public PlaceService() {
		dao = new PlaceDao();
	}
	//명소추가
	public void addPlace(PlaceVo vo) {
		dao.insert(vo);
	}
	//명소번호로 검색
	public PlaceVo getPlace(int place_num) {
		return dao.select(place_num);
	}
	//명소제목으로 검색
	public ArrayList<PlaceVo> getByTitle(String title, int city_num){
		return dao.selectByTitle(title, city_num);
	}
	//명소(도시번호로검색) 출력
	public ArrayList<PlaceVo> getAll(int city_num){
		return dao.selectAll(city_num);
	}
	//명소수정
	public void editPlace(PlaceVo vo) {
		dao.update(vo);
	}
	//명소삭제
	public void delPlace(int place_num) {
		dao.delete(place_num);
	}
}