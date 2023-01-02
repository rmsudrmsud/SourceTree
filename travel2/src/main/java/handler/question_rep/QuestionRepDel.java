package handler.question_rep;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Question_rep.Question_rep_Service;
import handler.Handler;

public class QuestionRepDel implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("question_rep_num"));
		int question_num = Integer.parseInt(request.getParameter("question_num"));
		Question_rep_Service service = new Question_rep_Service();
		service.delQuestion_rep(num);
		
		return "redirect:/question/detail.do?question_num="+question_num;
	}

}
