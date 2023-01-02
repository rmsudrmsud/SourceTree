package handler.tasty;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Tasty.TastyService;
import Tasty.TastyVo;
import handler.Handler;

public class TastyDel implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		int tasty_num = Integer.parseInt(request.getParameter("tasty_num"));
		int city_num = Integer.parseInt(request.getParameter("city_num"));
//		int city_num = Integer.parseInt(request.getParameter("city_num"));
		TastyService service = new TastyService();
		TastyVo vo = service.getByTastyNum(tasty_num);
		File f = new File("/Users/choigeunhyeong/Documents/Kosta/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/webapps/img"+vo.getImg_path());
		f.delete();
		service.delTasty(tasty_num);
		
		return "redirect:/tasty/listAll.do?city_num="+city_num;
	

	}

}
