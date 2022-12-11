package req;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do") //*:와일드카드. 컴퓨터에서 모든걸 의미,
public class DispathcerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DispathcerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getServletPath();
		String view = "";
		switch(url) {
		case "/menu1.do":
			view = "d.jsp";
			break;
		case "/menu2.do":
			view = "e.jsp";
			break;
		case "/menu3.do":
			view = "f.jsp";
			break;
		case "/menu4.do":
			view = "g.jsp";
			break;
		default:
			view="c.jsp";
			break;
		}
		request.setAttribute("view", view);
		RequestDispatcher dis = request.getRequestDispatcher("/index.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
