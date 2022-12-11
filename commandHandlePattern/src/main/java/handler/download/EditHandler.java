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

public class EditHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String path = "/Users/choigeunhyeong/Documents/down/";

		// 업로드 파일의 최대 크기
		int size = 100 * 1024 * 1024; // 100M

		// 업로드에 사용할 MultipartRequest 객체 생성
		MultipartRequest multipart = null;
		try {
			multipart = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 폼파라메터 읽기
		int num = Integer.parseInt(multipart.getParameter("num"));
		String title = multipart.getParameter("title");
		String content = multipart.getParameter("content");
		
		// 업로드된 파일 객체
		File f = multipart.getFile("file");
		String ofname = multipart.getParameter("down_path");
		String down_path = "";
		if (f == null) {
			// 원본파일명
			down_path = ofname;
		} else {
			// 업로드된 파일명
			down_path = f.getName();
			File delFile = new File(path + ofname);
			delFile.delete();
		}

		DownloadService service = new DownloadService();
		service.editDownload(new DownloadVo(num, "", null, title, content, down_path, 0));
		return "redirect:/download/getall.do";
	}

}
