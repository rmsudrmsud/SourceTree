package imgboard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imgboard.ImgBoardService;
import imgboard.ImgBoardVo;
import imgboard.rep.RepService;

/**
 * Servlet implementation class ImgBoarrdList
 */
@WebServlet("/imgboard/list")
public class ImgBoarrdList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgBoarrdList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ImgBoardService service = new ImgBoardService();
		RepService repservice = new RepService();
		ArrayList<ImgBoardVo> list = service.getAll();
		//각원글에 등록되어있는댓글 리스트에 넣어줌
		for(ImgBoardVo vo:list) {
			vo.setReps(repservice.getAll(vo.getNum()));
		}
		request.setAttribute("list", list);
		RequestDispatcher dis =request.getRequestDispatcher("/imgboard/list.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
