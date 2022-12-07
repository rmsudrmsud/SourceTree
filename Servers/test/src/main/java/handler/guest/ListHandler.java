package handler.guest;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.GuestBookService;
import guestbook.GuestBookVo;
import handler.CommandHandler;

public class ListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		GuestBookService service = new GuestBookService();
		ArrayList<GuestBookVo> list = service.getAll();
		req.setAttribute("list", list);
		return "/guestbook/list.jsp";
	}

}
