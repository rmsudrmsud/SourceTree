package handler.notice;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import handler.Handler;
import notice.NoticeService;
import notice.NoticeVo;

public class NoticeEdit implements Handler {

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
		
		String path = "/Users/choigeunhyeong/Documents/Kosta/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/webapps/img";

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
		File f = multipart.getFile("file");
		int num = Integer.parseInt(multipart.getParameter("notice_num"));
		String title = multipart.getParameter("title");
		String content = multipart.getParameter("content");
		String ofname = multipart.getParameter("img_path");
		String img_path = "";
		if (f == null) {
			// 원본파일명
			img_path = ofname;
		} else {
			// 업로드된 파일명
			img_path ="/img/"+ f.getName();
			File delFile = new File(path + ofname);
			delFile.delete();
		}
		NoticeService service = new NoticeService();
		service.editNotice(new NoticeVo(num,null,title,content,img_path,null));
		
		return "redirect:/notice/getall.do";
	}
}
