package handler.imgboard;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import imgboard.ImgBoardService;
import imgboard.ImgBoardVo;

public class DelHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String path = "/Users/choigeunhyeong/Documents/Kosta/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/webapps/img";
		int num = Integer.parseInt(request.getParameter("num"));
		ImgBoardService service = new ImgBoardService();
		ImgBoardVo vo = service.getImgBoard(num);//이미지보드 db 에서 그 한줄검색
		String fname = vo.getImg_path(); //경로 뽑아내기
		//이미지경로로 파일객체생성 후 파일삭제
		int idx = fname.lastIndexOf('/'); 
		String delfname = fname.substring(idx + 1);
		System.out.println("del file:" + delfname);
		File delFile = new File(path + delfname);
		delFile.delete();
		service.delImgBoard(num);
		return null;//응답보낼게없음
	}

}
