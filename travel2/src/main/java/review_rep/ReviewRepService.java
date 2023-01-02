package review_rep;

import java.util.ArrayList;

public class ReviewRepService {
	private ReviewRepDao dao;
	public ReviewRepService() {
		dao=new ReviewRepDao();
	}
	
	public void addReviewRep(ReviewRepVo vo) {
		dao.insert(vo);
	}
	
	public ArrayList<ReviewRepVo> getAll(int review_num){
		return dao.selectAll(review_num);
	}
	
	public void editReviewRep(ReviewRepVo vo) {
		dao.update(vo);
	}
	
	public void delReviewRep(int review_rep_num) {
		dao.delete(review_rep_num);
	}
	
	public ReviewRepVo getByNum(int review_rep_num) {
		return dao.selectByNum(review_rep_num);
	}
	
	public ReviewRepVo getByRNum(int review_num) {
		return dao.selectByRNum(review_num);
	}
	
}
