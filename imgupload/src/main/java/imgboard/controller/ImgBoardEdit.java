package imgboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imgboard.ImgBoardService;
import imgboard.ImgBoardVo;

/**
 * Servlet implementation class ImgBoardEdit
 */
@WebServlet("/imgboard/edit")
public class ImgBoardEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgBoardEdit() {
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
		ImgBoardService service = new ImgBoardService();
		ImgBoardVo vo = service.getImgBoard(num);
		request.setAttribute("vo", vo);
		
		
		RequestDispatcher dis =request.getRequestDispatcher("/imgboard/edit.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		ImgBoardService service = new ImgBoardService();
		service.editImgBoard(new ImgBoardVo(num, null, null, title, content, null));
		
		response.sendRedirect(request.getContextPath()+"/imgboard/list");
	}

}
