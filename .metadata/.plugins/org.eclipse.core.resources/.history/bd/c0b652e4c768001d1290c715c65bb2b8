package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormTest
 */
@WebServlet("/FormTest") // 서블릿도 웹페이지이기 때문에 url로 접근해야한다.
public class FormTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub;
		// 요청 파라메터의 인코딩
		request.setCharacterEncoding("EUC-KR");
		// 현재 페이지 마임타입 지정(마임타입 : 페이지 종류)
		response.setContentType("text/html;charset=EUC-KR");
		//응답페이지 인코딩 셋 ->
		response.setCharacterEncoding("EUC-KR");
		
		String name = request.getParameter("nameval"); // 요청받은 nameval받아서 변수에 담기
		response.getWriter().append("<body><h3>do get 메서드 실행<br/>"+name+"님 반갑습니다</h3></body>");
	}

	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html;charset=EUC-KR");
		response.setCharacterEncoding("EUC-KRr");
		
		String pwd = request.getParameter("pwd");
		String subj = request.getParameter("ra");
		String[] ch = request.getParameterValues("ch");
		String selVal = request.getParameter("sel");
		String content = request.getParameter("contetnt");
		
		response.getWriter().append("<body><h3>입력한 비밀번호는 : ");
		response.getWriter().append(pwd+"<br/>");
		response.getWriter().append("선택과목:"+subj);
		response.getWriter().append("</h3></body>");
		response.getWriter().append("선택과일:");
		for(String i:ch) {
			response.getWriter().append(i+",");
		}
		response.getWriter().append("<br/>");
		response.getWriter().append("선택DB:"+selVal+"<br/>");
		response.getWriter().append("내용:"+content+"<br/>");
		response.getWriter().append("</h3></body>");
		
		
	}

}
