package handler.cityinfo;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cityinfo.CityInfoService;
import cityinfo.CityInfoVo;
import handler.Handler;

public class CityEdit implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int num = Integer.parseInt(request.getParameter("city_num"));
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		System.out.println(id+"id");
		System.out.println(num+"num");
		System.out.println(name+"name");
		CityInfoService service = new CityInfoService();
		service.editCity(new CityInfoVo(num,name,id));
		
		return "redirect:/cityinfo/getall.do";
	}

}
