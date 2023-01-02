package Question;

import java.util.ArrayList;

import Tasty.TastyVo;

public class QuestionService {

	private QuestionDao dao;
	public QuestionService() {
		dao = new QuestionDao();
	}
	
	public void addQuestion(QuestionVo vo) {
		dao.insert(vo);
	}
	
	public ArrayList<QuestionVo> getQuestionByTitle(String title) {
		return dao.selectByTitle(title);
	}
	
	public ArrayList<QuestionVo> getQuestionAll(){
		return dao.selectAll();
	}
	
	public void editQuestion(QuestionVo vo) {
		dao.update(vo);
	}
	
	public void delQuestion(int num) {
		dao.delete(num);
	}
	
	public QuestionVo getQuestion(int question_num) {
		return dao.select(question_num);
	}
	
	
}
