package handler.question;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Question.QuestionService;
import Question.QuestionVo;
import handler.Handler;

public class QuestionListAll implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		QuestionService service = new QuestionService();
		ArrayList<QuestionVo> list = service.getQuestionAll();
		request.setAttribute("list", list);
		return "/question/list.jsp";
	}

}
