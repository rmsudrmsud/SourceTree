package handler.togetherRep;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import togetherRep.TogetherRepService;
import togetherRep.TogetherRepVo;

public class TogetherRepGetAll implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		TogetherRepService service = new TogetherRepService();
		ArrayList<TogetherRepVo> list = service.getAll();	
		request.setAttribute("list", list);
		
		return "/together/detail.jsp";
	}

}
