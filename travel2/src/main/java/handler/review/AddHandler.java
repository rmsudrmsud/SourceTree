package handler.review;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import handler.Handler;
import review.ReviewService;
import review.ReviewVo;

public class AddHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if (request.getMethod().toLowerCase().equals("get")) {
			return "/review/addForm.jsp";
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
		String imgpath = "/Users/choigeunhyeong/Documents/Kosta/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/webapps/img";
		
		int size = 100 * 1024 * 1024; // 100M
		MultipartRequest multipart=null;
		try {
			multipart = new MultipartRequest(request, imgpath, size, "UTF-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//업로드된 파일의 파일객체 반환
		File f = multipart.getFile("file");
		//getName(): 파일명 반환
		String imgfname = f.getName();//파일명
		
		
		
		String id = multipart.getParameter("id");
		String title = multipart.getParameter("title");
		String content = multipart.getParameter("content");
		String img_path = "/img/"+imgfname;
		
		int city_num=Integer.parseInt(multipart.getParameter("city_num"));
		ReviewService service= new ReviewService();
		ReviewVo vo=new ReviewVo(0,city_num,id,title,content,img_path,null); 
		service.addReview(vo);
		
		return "redirect:/review/getall.do?city_num="+city_num;
		
	
	}

}
