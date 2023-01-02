package handler.cityinfo;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cityinfo.CityInfoService;
import cityinfo.CityInfoVo;
import handler.Handler;

public class CityMain implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if (request.getMethod().toLowerCase().equals("get")) {
			int city_num=Integer.parseInt(request.getParameter("city_num"));
			CityInfoService service = new CityInfoService();
			CityInfoVo vo = service.getbyNum(city_num);
			request.setAttribute("vo",vo);
			return "/cityinfo/citymain.jsp";
		}
		return null;
	}

}
