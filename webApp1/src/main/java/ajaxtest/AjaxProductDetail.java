package ajaxtest;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import product.ProductService;
import product.ProductVo;

/**
 * Servlet implementation class AjaxDetail
 */
@WebServlet("/ajax/productdetail")
public class AjaxProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxProductDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		int num = Integer.parseInt(request.getParameter("num"));
		ProductService service = new ProductService();
		//번호로제품 검색
		ProductVo vo = service.getByNum(num);
		//검색된 객체를 제이슨 객체로 반환
		JSONObject obj = new JSONObject();
		obj.put("num", vo.getNum());
		obj.put("name", vo.getName());
		obj.put("price", vo.getPrice());
		obj.put("amount", vo.getAmount());
		obj.put("seller", vo.getSeller());
		//제이슨객체를 문자열 반환
		String txt = obj.toJSONString();
		//출력
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
