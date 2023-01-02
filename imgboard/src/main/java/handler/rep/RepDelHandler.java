package handler.rep;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import rep.RepService;

public class RepDelHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		RepService service = new RepService();
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		service.delRep(num);
		return null;
	}

}
