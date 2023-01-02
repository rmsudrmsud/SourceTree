package handler.question;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Question.QuestionService;
import Question.QuestionVo;
import handler.Handler;

public class QuestionEdit implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		

//		
//		if(request.getMethod().toLowerCase().equals("get")) {
//			QuestionService service = new QuestionService();
//			QuestionVo vo = service.getQuestion(question_num);
//			//검색 결과를 request에 담는다
//			request.setAttribute("vo", vo);
//			
//			return "/question/detail.jsp";
//		}

		String path = "/Users/choigeunhyeong/Documents/Kosta/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/webapps/img";

		// 업로드 파일의 최대 크기
		int size = 100 * 1024 * 1024; // 100M

		// 업로드에 사용할 MultipartRequest 객체 생성
		MultipartRequest multipart = null;
		try {
			multipart = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int question_num = Integer.parseInt(multipart.getParameter("question_num"));
		
		File f = multipart.getFile("file");
		String title = multipart.getParameter("title");
		String content = multipart.getParameter("content");
		//업로드 된 파일 객체
		String ofname = multipart.getParameter("img_path");
		String img_path = "";
		if(f==null) {//수정 안하는경우
			//원본 파일명
//			fname = multipart.getParameter("fname");
			img_path = ofname;
		}else { //수정하는 경우
			//업로드 된 파일명
			img_path = "/img/" + f.getName();
			File delFile = new File(path + ofname);
			delFile.delete();
		}
		QuestionService service = new QuestionService();
		service.editQuestion(new QuestionVo(question_num, "", title, content, img_path, null));
		return "redirect:/question/listAll.do";
	}
}
