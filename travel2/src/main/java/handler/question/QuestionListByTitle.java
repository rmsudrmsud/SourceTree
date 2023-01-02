package handler.question;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Question.QuestionService;
import Question.QuestionVo;
import handler.Handler;

public class QuestionListByTitle implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		ArrayList<QuestionVo> list = (new QuestionService().getQuestionByTitle(title));
		request.setAttribute("list", list);
		return "/question/list.jsp";
	}

	

}
