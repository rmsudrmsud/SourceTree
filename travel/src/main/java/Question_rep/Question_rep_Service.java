package Question_rep;

import java.util.ArrayList;

public class Question_rep_Service {

	private Question_rep_Dao dao;
	public Question_rep_Service() {
		dao = new Question_rep_Dao();
	}
	
	public void addQuestion_rep(Question_rep_Vo r) {
		dao.insert(r);
	}
	
	public ArrayList<Question_rep_Vo> getQuestion_rep(int question_num) {
		return dao.selectByQuestionNum(question_num);
	}
	
	public ArrayList<Question_rep_Vo> listAll_rep() {
		return dao.selectAll();
	}
	
	public void editQuestion_rep(Question_rep_Vo vo) {
		dao.update(vo);
	}
	public Question_rep_Vo get(int question_rep_num) {
		return dao.select(question_rep_num);
	}
	
	public void delQuestion_rep(int question_rep_num) {
		dao.delete(question_rep_num);
	}
	
}
