package handler.question;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Question.QuestionService;
import Question.QuestionVo;
import handler.Handler;

public class QuestionDel implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("question_num"));
		QuestionService service = new QuestionService();
		QuestionVo vo = service.getQuestion(num);
		File f = new File("/Users/choigeunhyeong/Documents/Kosta/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/webapps/img"+vo.getImg_path());
		f.delete();
		service.delQuestion(num);
		
		return "redirect:/question/listAll.do";
	}

}
