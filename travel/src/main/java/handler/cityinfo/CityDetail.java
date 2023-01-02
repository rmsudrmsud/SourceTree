package handler.cityinfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cityinfo.CityInfoService;
import cityinfo.CityInfoVo;
import handler.Handler;

public class CityDetail implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("city_num"));
		System.out.println(num);
		CityInfoVo vo = (new CityInfoService()).getbyNum(num);
		request.setAttribute("vo", vo);
		return "/cityinfo/detail.jsp";
	}

}
