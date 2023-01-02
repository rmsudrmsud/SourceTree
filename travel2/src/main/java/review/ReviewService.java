package review;

import java.util.ArrayList;

public class ReviewService {
	private ReviewDao dao;
	public ReviewService() {
		dao=new ReviewDao();
	}
	
	public void addReview(ReviewVo vo) {
		dao.insert(vo);
	}
	
	public ArrayList<ReviewVo> getAll(int city_num){
		return dao.selectAll(city_num);
	}
	
	public ArrayList<ReviewVo> getByTitle(String title, int city_num){
		return dao.selectByTitle(title, city_num);
	}
	
	public ArrayList<ReviewVo> getById(String id){
		return dao.selectById(id);
		
	}
	public ReviewVo getByNum(int review_num) {
		return dao.selectByNum(review_num);
	}
	
	public void editReview(ReviewVo vo) {
		dao.update(vo);
	}
	
	public void delReview(int review_num) {
		dao.delete(review_num);
	}
	
}
