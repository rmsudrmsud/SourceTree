package cityinfo;

import java.util.ArrayList;

public class CityInfoService {
	private CityInfoDao dao;
	
	public CityInfoService() {
		dao = new CityInfoDao();
	}
	
	//도시정보 추가
	public void addCity(CityInfoVo vo) {
		dao.insert(vo);
	}
	//도시번호로 검색
	public CityInfoVo getbyNum(int city_num) {
		return dao.selectByNum(city_num);
	}
	
	//도시전체출력
	public ArrayList<CityInfoVo> getAll(){
		return dao.selectAll();
	}
	
	//도시정보 수정
	public void editCity(CityInfoVo vo) {
		dao.update(vo);
	}
	
	//도시정보삭제
	public void delCity(int city_num) {
		dao.delete(city_num);
	}
}