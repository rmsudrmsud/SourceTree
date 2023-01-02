package handler.cityinfo;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cityinfo.CityInfoService;
import cityinfo.CityInfoVo;
import handler.Handler;

public class CityAdd implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if (request.getMethod().toLowerCase().equals("get")) {
			return "/cityinfo/add.jsp";
		}
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		CityInfoService service = new CityInfoService();
		
		service.addCity(new CityInfoVo(0, name, id));
	
		return "redirect:/cityinfo/getall.do";
	}

}
