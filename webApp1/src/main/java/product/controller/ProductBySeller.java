package product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import product.ProductService;
import product.ProductVo;

/**
 * Servlet implementation class ProductBySeller
 */
@WebServlet("/product/getbyseller")
public class ProductBySeller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductBySeller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductService service = new ProductService();
		String seller = request.getParameter("seller");
		ArrayList<ProductVo> list = service.getBySeller(seller);
		request.setAttribute("list", list);
		String path = "/product/list.jsp";//구매자용 목록
		HttpSession session = request.getSession(false);
		int type = (int) session.getAttribute("type");
		if(type==2) {//판매자용 목록
			path = "/product/list2.jsp";
		}
		RequestDispatcher dis =request.getRequestDispatcher(path);
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
