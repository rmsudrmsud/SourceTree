package handler.download;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import download.DownloadService;
import download.DownloadVo;
import handler.Handler;

public class ListHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		DownloadService service = new DownloadService();
		ArrayList<DownloadVo> list =  service.getAll();
		request.setAttribute("list", list);
		
		return "/download/list.jsp";
	}

}
