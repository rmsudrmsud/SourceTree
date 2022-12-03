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
@WebServlet("/ajax/detail")
public class AjaxDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxDetail() {
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
		
		ProductService service = new ProductService();
		ArrayList<ProductVo> list = service.getAll();
		JSONArray arr = new JSONArray(); //제이슨배열 생성
		for(ProductVo p : list) {
			JSONObject obj = new JSONObject(); //꼭 다넣지 않아도 내가보고싶은것만 넣어도됨
			obj.put("num", p.getNum());
			obj.put("name", p.getName());
			obj.put("price", p.getPrice());
			arr.add(obj);
		}
		
		String txt = arr.toJSONString();
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
