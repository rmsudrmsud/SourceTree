package handler.together;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import together.TogetherService;
import together.TogetherVo;

public class TogetherAdd implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		if(request.getMethod().toLowerCase().equals("get")) {
			return "/together/addForm.jsp";
		}
		
		int city_num = Integer.parseInt(request.getParameter("city_num"));
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int ppl = Integer.parseInt(request.getParameter("ppl"));
		
		TogetherVo vo = new TogetherVo(0,city_num,id,title,content,ppl,null);
		TogetherService service = new TogetherService();
		
		service.addTravel(vo);
		
		return "redirect:/together/getall.do?city_num="+city_num;
	}

}
