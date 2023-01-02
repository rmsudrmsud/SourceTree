package together;

import java.util.ArrayList;

public class TogetherService {
  private TogetherDao dao;
  
  public TogetherService() {
	  dao = new TogetherDao();
	  
  }
  
  public void addTravel(TogetherVo vo ) {
	  dao.insert(vo);
  }
  
  public TogetherVo getNum (int travel_num) {
	  return dao.select(travel_num);
  }
  
  public ArrayList<TogetherVo> getByTitle(String title, int city_num){
	  return dao.selectByTitle(title, city_num);
	  
  }
  
  public ArrayList<TogetherVo> getByTcNum(int city_num){
	  return dao.selectBycNum(city_num);
	  
  }
  
  public  ArrayList<TogetherVo> getAll(){
	  return dao.selectAll();
	  
  }
  
  public void editTravel(TogetherVo vo ) {
	  dao.update(vo);
	  
  }
  
  public void delTravel (int travel_num) {
	  dao.delete(travel_num);
	  
  }
}
