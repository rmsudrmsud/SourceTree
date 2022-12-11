package imgboard.rep.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import imgboard.rep.Rep;
import imgboard.rep.RepService;

/**
 * Servlet implementation class RepEdit
 */
@WebServlet("/rep/edit")
public class RepEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RepEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String content = request.getParameter("content");
		
		RepService service = new RepService();
		service.editRep(new Rep(num, "", content, 0));
		Rep r = service.getRep(num);
		JSONObject obj = new JSONObject();
		obj.put("num", r.getNum());
		obj.put("writer", r.getWriter());
		obj.put("content", r.getContent());
		
		String txt = obj.toJSONString();
		response.getWriter().append(txt);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
