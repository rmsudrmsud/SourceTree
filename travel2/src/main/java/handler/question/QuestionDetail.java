package handler.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Question.QuestionService;
import Question.QuestionVo;
import Question_rep.Question_rep_Service;
import handler.Handler;

public class QuestionDetail implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int question_num = Integer.parseInt(request.getParameter("question_num"));
		QuestionVo vo = (new QuestionService()).getQuestion(question_num);
		Question_rep_Service service = new Question_rep_Service();
		vo.setReps(service.getQuestion_rep(question_num));//댓글 목록을 가져올 Array리스트를 여기에 추가해주어야 된다.
		request.setAttribute("vo", vo);
		return "/question/detail.jsp";
	}

}
