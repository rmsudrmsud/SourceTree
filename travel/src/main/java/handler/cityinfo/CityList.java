package handler.cityinfo;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cityinfo.CityInfoService;
import cityinfo.CityInfoVo;
import handler.Handler;

public class CityList implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		CityInfoService service = new CityInfoService();
		ArrayList<CityInfoVo> list = service.getAll();		
		request.setAttribute("list", list);
		return "/cityinfo/list.jsp";
	}

}
