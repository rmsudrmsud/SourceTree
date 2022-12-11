package handler.download;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import download.DownloadService;
import handler.Handler;

public class DelHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num"));
		DownloadService service = new DownloadService();
		service.delDownload(num);
		
		return "redirect:/DispatcherServlet?url=/download/getall";
	}

}
