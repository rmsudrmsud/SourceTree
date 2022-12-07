package handler.guest;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.GuestBookService;
import guestbook.GuestBookVo;
import handler.CommandHandler;

public class ListHandler implements CommandHandler { //커맨드 핸들러를 상속받은 구현클래스(listHandelr)

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) { //list는 겟방식, 포스트방식을 구분하지않음으로 한번에
		// TODO Auto-generated method stub
		GuestBookService service = new GuestBookService();
		ArrayList<GuestBookVo> list = service.getAll();
		req.setAttribute("list", list);
		return "/guestbook/list.jsp"; //앞에 아무것도 없으면 forword방식으로 이동 
	}

}
