package handler.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import notice.NoticeService;

public class NoticeDel implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("notice_num"));
		NoticeService service = new NoticeService();
		service.delNotice(num);
		return "redirect:/notice/getall.do";
	}

}
