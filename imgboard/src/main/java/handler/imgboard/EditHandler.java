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

public class EditHandler implements Handler {

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
		int size = 100 * 1024 * 1024; // 100M
		MultipartRequest multipart = null;
		String fname = "";
		boolean flag = true;
		try {
			multipart = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
			// 업로드된 파일의 파일객체 반환
			File f = multipart.getFile("file");
			if (f != null) {
				// getName(): 파일명 반환
				fname = f.getName();// 파일명
			} else {
				flag = false;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImgBoardService service = new ImgBoardService();
		int num = Integer.parseInt(multipart.getParameter("num"));
		String title = multipart.getParameter("title");
		String content = multipart.getParameter("content");
		String img_path = "";
		String old_path = service.getImgBoard(num).getImg_path();
		if(flag) {
			img_path = "/img/" + fname;
			int idx = old_path.lastIndexOf('/'); //lastIndexOf 마지막위치
			String delfname = old_path.substring(idx+1);
			File delFile = new File(path+delfname);
			delFile.delete();
		}else {
			img_path = old_path;
		}
		service.editImgBoard(new ImgBoardVo(num, null, null, title, content, img_path));
		ImgBoardVo vo = service.getImgBoard(num);
		JSONObject obj = new JSONObject();
		obj.put("num", vo.getNum());
		obj.put("title", vo.getTitle());
		obj.put("img_path", vo.getImg_path().replace("/", "\\"));
		obj.put("content", vo.getContent());
		String txt = obj.toJSONString();
		return "responsebody/" + txt;
	}

}
