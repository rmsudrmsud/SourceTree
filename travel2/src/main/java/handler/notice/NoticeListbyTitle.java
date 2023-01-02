package handler.notice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import notice.NoticeService;
import notice.NoticeVo;

public class NoticeListbyTitle implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String fname = request.getParameter("fname");
		ArrayList<NoticeVo> list = (new NoticeService()).getByTitle(fname);
		request.setAttribute("list", list);
		return "/notice/list.jsp";
	}

}
