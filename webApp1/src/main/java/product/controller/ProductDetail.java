package product.controller;

import java.io.IOException;

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
 * Servlet implementation class ProductDetail
 */
@WebServlet("/product/detail")
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//폼파람으로 제품번호 받아서 제품 검색해서 request에 담아서 /product/editForm.jsp로 이동하여 텍스트박스에 정보출력
		
		ProductService service = new ProductService();
		int num = Integer.parseInt(request.getParameter("num"));
		ProductVo vo = service.getByNum(num);
		request.setAttribute("vo", vo);
		String path = "/product/editForm.jsp";
		HttpSession session = request.getSession(false);
		int type = (int) session.getAttribute("type");
		if (type == 1) {
			path = "/order/addForm.jsp";
		}
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ProductService service = new ProductService();
		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		String seller = request.getParameter("seller");
		service.editProduct(new ProductVo(num, name, price, amount, ""));
		response.sendRedirect("/webApp1/product/getbyseller?seller="+seller);
	}

}
