package handler.download;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import download.DownloadService;
import download.DownloadVo;
import handler.Handler;

public class DetailHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num"));
		DownloadVo vo = (new DownloadService()).getDownload(num);
		request.setAttribute("vo", vo);
		return "/download/detail.jsp";
	}

}
