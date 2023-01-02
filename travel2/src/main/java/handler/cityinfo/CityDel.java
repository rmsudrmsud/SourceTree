package handler.cityinfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cityinfo.CityInfoService;
import handler.Handler;

public class CityDel implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("city_num"));
		CityInfoService service = new CityInfoService();
		service.delCity(num);
		return "redirect:/cityinfo/getall.do";
	}

}
