package handler.imgboard;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import handler.Handler;
import imgboard.ImgBoardService;
import imgboard.ImgBoardVo;

public class AddHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path = "/Users/choigeunhyeong/Documents/Kosta/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/webapps/img";
		MultipartRequest multipart = null;
		String fname="";
		int size = 100*1024*1024; //100m
		
		//업로드에 사용할 multipartrequest 객체
//		MultipartRequest multipart;
		try {
			multipart = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
			File f = multipart.getFile("file");
			//getName(): 파일명반환
			fname=f.getName();//파일명
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImgBoardService service = new ImgBoardService();
		int num = service.getNum();
		String writer=multipart.getParameter("writer");
		String title=multipart.getParameter("title");
		String content=multipart.getParameter("content");
		String img_path = "/img/"+fname;
		service.addImgBoard(new ImgBoardVo(num, writer, null, title, content, img_path));
		
		ImgBoardVo vo = service.getImgBoard(num);
		JSONObject obj = new JSONObject();
		obj.put("num", vo.getNum());
		obj.put("writer", vo.getWriter());
		obj.put("w_date", vo.getW_date().toString());
		obj.put("title", vo.getTitle());
		obj.put("img_path", vo.getImg_path().replace("/","\\"));
		obj.put("content", vo.getContent());
		String txt = obj.toJSONString();
		System.out.println(txt);
		return "responsebody/"+txt;
	}

}
