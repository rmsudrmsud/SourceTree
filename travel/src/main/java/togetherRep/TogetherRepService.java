package togetherRep;

import java.util.ArrayList;

public class TogetherRepService {
  private TogetherRepDao dao;
  
  public TogetherRepService () {
	  dao = new TogetherRepDao();
	  
  }
  
    public void addTravelRep(TogetherRepVo vo) {
    	dao.insert(vo);
    }
    
    public void editTravelRep (TogetherRepVo vo) {
    	dao.update(vo);
    	
    }
    
    public TogetherRepVo get(int travel_rep_num) {
    	return dao.select(travel_rep_num);
    }
    
    public void delete(int travel_rep_num) {
    	dao.delete(travel_rep_num);
    }
    
    public ArrayList<TogetherRepVo> getNum (int travel_num){
    	return dao.selectByNum(travel_num);
    }
    
    public ArrayList<TogetherRepVo> getAll (){
    	return dao.selectAll();
    }
    
}
