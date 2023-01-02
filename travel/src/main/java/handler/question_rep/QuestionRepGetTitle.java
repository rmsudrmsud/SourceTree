package handler.question_rep;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Question_rep.Question_rep_Service;
import Question_rep.Question_rep_Vo;
import handler.Handler;

public class QuestionRepGetTitle implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Question_rep_Service service = new Question_rep_Service();
		ArrayList<Question_rep_Vo> list = service.listAll_rep();
		request.setAttribute("list", list);
		return "/question/detail.jsp";
	}

}
