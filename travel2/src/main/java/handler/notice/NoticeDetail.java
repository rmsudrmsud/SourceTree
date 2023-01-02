package handler.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import notice.NoticeService;
import notice.NoticeVo;

public class NoticeDetail implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("notice_num"));
		NoticeVo vo = (new NoticeService()).getNotice(num);
		request.setAttribute("vo", vo);
		return "/notice/detail.jsp";
	}

}
