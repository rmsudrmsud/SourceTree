package handler.download;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import download.DownloadService;
import download.DownloadVo;
import handler.Handler;

public class DelHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num"));
		DownloadService service = new DownloadService();
		DownloadVo vo = service.getDownload(num);
		File f = new File("/Users/choigeunhyeong/Documents/down/"+vo.getDown_path());
		f.delete();
		service.delDownload(num);
		return "redirect:/download/getall.do";
	}

}
