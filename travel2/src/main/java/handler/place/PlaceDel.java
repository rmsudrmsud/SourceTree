package handler.place;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import place.PlaceService;
import place.PlaceVo;

public class PlaceDel implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("place_num"));
		int city_num = Integer.parseInt(request.getParameter("city_num"));
		PlaceService service = new PlaceService();
		PlaceVo vo=service.getPlace(num);
		File f = new File("/Users/choigeunhyeong/Documents/Kosta/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/webapps/img"+vo.getImg_path());
		f.delete();
		service.delPlace(num);
		return "redirect:/place/getall.do?city_num="+city_num;
	}

}
