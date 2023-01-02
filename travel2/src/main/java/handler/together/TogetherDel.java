package handler.together;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import together.TogetherService;
import together.TogetherVo;

public class TogetherDel implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	    int travel_num = Integer.parseInt(request.getParameter("travel_num"));
	    int city_num = Integer.parseInt(request.getParameter("city_num"));
	   
	    TogetherService service = new TogetherService();
	    TogetherVo vo = service.getNum(travel_num);
	    service.delTravel(travel_num);
	    
		return "redirect:/together/getall.do?city_num="+city_num;
	}

}
