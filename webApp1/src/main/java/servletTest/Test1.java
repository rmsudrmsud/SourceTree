package servletTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test1
 */
@WebServlet("/Test1") // 클라이언트 요청 받음. 웹페이지. url로 실행 -> (/"Test1")이 url. 설정이나 자바코드가 변경되면 서버 재실행
public class Test1 extends HttpServlet {
	private static final long serialVersionUID = 1L; //직렬화 : 다른 메모리에 있는객체에 접근할 때 멤버변수값을 하나씩 꺼냄. L:롱타임
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test1() { //생성자
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter pw = response.getWriter();
		response.getWriter().append("<html><body>Served at: ").append(request.getContextPath()); //request.getContextPath() : 현재 프로젝트의 기본경로 읽어오기
		response.getWriter().append("<br/><h3>get req</h3>");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		response.getWriter().append("<h3>id: "+id+"</h3> ");
		response.getWriter().append("<h3>pwd: "+pwd+"</h3> ");
		response.getWriter().append("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("<html></body>Served at: ").append(request.getContextPath());
		response.getWriter().append("<br/><h3>post req</h3>");
		String id = request.getParameter("id2");
		String pwd = request.getParameter("pwd2");
		response.getWriter().append("<h3>id2: "+id+"</h3> ");
		response.getWriter().append("<h3>pwd2: "+pwd+"</h3> ");
		response.getWriter().append("</body></html>");
	}

}
