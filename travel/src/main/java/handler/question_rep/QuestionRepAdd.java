package handler.question_rep;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Question_rep.Question_rep_Service;
import Question_rep.Question_rep_Vo;
import handler.Handler;

public class QuestionRepAdd implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		int question_rep_num = Integer.parseInt(request.getParameter("question_rep_num"));
		if (request.getMethod().toLowerCase().equals("get")) {
			return "/question/detail.jsp";
		}
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		int question_num = Integer.parseInt(request.getParameter("question_num"));

//		System.out.println(question_num);
//		System.out.println(content);
//		System.out.println(id);
		Question_rep_Service service = new Question_rep_Service();
		service.addQuestion_rep(new Question_rep_Vo(0, question_num, id, content,null));
		
		ArrayList<Question_rep_Vo> list = service.getQuestion_rep(question_num);
//		for(Question_rep_Vo vo : list) {
//			System.out.println(vo);
//		}
		JSONArray arr = new JSONArray();
		for(Question_rep_Vo r:list) {
			JSONObject obj = new JSONObject();
			obj.put("question_rep_num", r.getQuestion_rep_num());
			obj.put("parent", r.getQuestion_num());
			obj.put("id", r.getId());
			obj.put("content", r.getContent());
//			obj.put("wdate", r.getWdate());
			//원래 이거였는데 sysdate값을 가져올때 2022-11-11 이런식으로 가져오기때문에
			//문자열로 변경해줘야해서 toString으로 바꿔줘야함(문자열로)
			obj.put("wdate", r.getWdate().toString());
			
			arr.add(obj);
		}
		
		String txt = arr.toJSONString();
//		System.out.println(txt+"두둥");
		return "responsebody/"+txt;
	}
	
}
