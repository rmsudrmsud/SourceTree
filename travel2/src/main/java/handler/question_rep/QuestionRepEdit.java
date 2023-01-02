package handler.question_rep;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import Question_rep.Question_rep_Service;
import Question_rep.Question_rep_Vo;
import handler.Handler;

public class QuestionRepEdit implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	      try {
	          request.setCharacterEncoding("UTF-8");
	          response.setCharacterEncoding("UTF-8");
	          response.setContentType("text/html; charset=UTF-8");
	       } catch (UnsupportedEncodingException e1) {
	          // TODO Auto-generated catch block
	          e1.printStackTrace();
	       }

//		String path = "C:\\255\\myjava\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\webapps\\img\\";

		// 업로드 파일의 최대 크기
//		int size = 100 * 1024 * 1024; // 100M

		// 업로드에 사용할 MultipartRequest 객체 생성
//		MultipartRequest multipart = null;
//		try {
//			multipart = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		int num = Integer.parseInt(multipart.getParameter("question_rep_num"));
		
		int question_rep_num = Integer.parseInt(request.getParameter("question_rep_num"));
//		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Question_rep_Service service = new Question_rep_Service();
		service.editQuestion_rep(new Question_rep_Vo(question_rep_num, 0, "", content, null));
		Question_rep_Vo r = service.get(question_rep_num);
		
		JSONObject obj = new JSONObject();
		
		obj.put("question_rep_num", r.getQuestion_rep_num());
		obj.put("question_num", r.getQuestion_num());
		obj.put("id", r.getId());
		obj.put("content", r.getContent());
		obj.put("wdate", r.getWdate().toString());
		
		String txt = obj.toJSONString();
		
		return "responsebody/"+txt;
	}

}
