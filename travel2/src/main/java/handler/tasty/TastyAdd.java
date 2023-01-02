package handler.tasty;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Tasty.TastyService;
import Tasty.TastyVo;
import handler.Handler;

public class TastyAdd implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if (request.getMethod().toLowerCase().equals("get")) {
			return "/tasty/addForm.jsp";
		}
//		response.setContentType("text/html; charset=UTF-8");
		
		String ipath = "/Users/choigeunhyeong/Documents/Kosta/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/webapps/img";

		// 업로드 파일의 최대 크기
		int size = 100 * 1024 * 1024; // 100M

		// 업로드에 사용할 MultipartRequest 객체 생성
		MultipartRequest multipart = null;
		try {
			multipart = new MultipartRequest(request, ipath, size, "utf-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 폼파라메터 읽기
		String id = multipart.getParameter("id");
		String title = multipart.getParameter("title");
		String content = multipart.getParameter("content");
		
		//업로드된 이미지파일 객체
		File f = multipart.getFile("file");
		// 업로드된 이미지파일명
		String fname = f.getName();
		String img_path = "/img/" + fname;
HttpSession session = request.getSession();
		
		int city_num = (int) session.getAttribute("city_num");

		
		//업로드 된 파일객체
//		File ff = multipart.getFile("file2");		

		TastyService service = new TastyService();
		service.addTasty(new TastyVo(0, id, city_num, title, content, img_path, null));
		return "redirect:/tasty/listAll.do?city_num="+ city_num;
	}

}
