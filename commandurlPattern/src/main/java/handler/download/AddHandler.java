package handler.download;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import download.DownloadService;
import download.DownloadVo;
import handler.Handler;

public class AddHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if (request.getMethod().toLowerCase().equals("get")) {
			return "/download/add.jsp";
		}
		String path = "/Users/choigeunhyeong/Documents/down/";

		// 업로드 파일의 최대 크기
		int size = 100 * 1024 * 1024; // 100M

		// 업로드에 사용할 MultipartRequest 객체 생성
		MultipartRequest multipart = null;
		try {
			multipart = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 폼파라메터 읽기
		String writer = multipart.getParameter("writer");
		String title = multipart.getParameter("title");
		String content = multipart.getParameter("content");
		//업로드된 파일 객체
		File f = multipart.getFile("file");
		// 업로드된 파일명
		String fname = f.getName();

		DownloadService service = new DownloadService();
		service.addDownload(new DownloadVo(0, writer, null, title, content, fname, 0));
		return "redirect:/DispatcherServlet?url=/download/getall";
	}

}
