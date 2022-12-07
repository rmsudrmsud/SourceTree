package handler.guest;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.GuestBookService;
import guestbook.GuestBookVo;
import handler.CommandHandler;

public class AddHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		if(req.getMethod().toLowerCase().equals("get")) { //toLowerCase: 문자를 소문자로변환<->toUpperCase는 대문자로 변환
			return "/guestbook/addForm.jsp";
		}
		try {
			req.setCharacterEncoding("euc-kr");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		res.setCharacterEncoding("euc-kr");
		
		String writer = req.getParameter("writer");
		String pwd = req.getParameter("pwd");
		String content = req.getParameter("content");
		
		GuestBookService service = new GuestBookService();
		service.addBook(new GuestBookVo(0, writer, null, pwd, content));
		return "redirect:/guestbook/list";
	}

}
