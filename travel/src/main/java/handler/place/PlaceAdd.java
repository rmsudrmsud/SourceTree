package handler.place;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import handler.Handler;
import place.PlaceService;
import place.PlaceVo;

public class PlaceAdd implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if (request.getMethod().toLowerCase().equals("get")) {
			return "/place/add.jsp";
		}

		//post 일때
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
		//getName(): 파일명반환
		String fname=f.getName();//파일명
		String id=multipart.getParameter("id");
		String title=multipart.getParameter("title");
		String content=multipart.getParameter("content");
		String img_path = "/img/"+fname;
		System.out.println(multipart.getParameter("ctiy_num"));
		HttpSession session = request.getSession();
		
		int city_num = (int) session.getAttribute("city_num");

		PlaceService service = new PlaceService();
		service.addPlace(new PlaceVo(0, city_num, id, title, content, img_path, null));
		return "redirect:/place/getall.do?city_num="+city_num;
	}

}
