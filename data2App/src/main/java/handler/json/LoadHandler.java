package handler.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import handler.Handler;
import json.MenuVo;

public class LoadHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String path1 = "/WEB-INF/files/serviceAreaFoods.json";
		String path2 = request.getServletContext().getRealPath(path1);
		try {
			FileReader fr = new FileReader(path2);

			// json 파일을 분석할 파서 생성
			JSONParser parser = new JSONParser();
			// 생성한 파서로 json파일 분석
			JSONObject obj = (JSONObject) parser.parse(fr);
			Iterator iter = obj.keySet().iterator();
			ArrayList<MenuVo> list = new ArrayList<>();
			while (iter.hasNext()) {
				String key = (String) iter.next();
				System.out.println("key:" + key);
				JSONObject value = (JSONObject) obj.get(key);

				// 가격 추출
				JSONArray salePrice_arr = (JSONArray) value.get("http://data.ex.co.kr:80/link/def/salePrice");
				JSONObject priceObj = (JSONObject) salePrice_arr.get(0);
				String price = (String) priceObj.get("value");

				// 메뉴명 추출
				JSONArray menu_arr = (JSONArray) value.get("http://data.ex.co.kr:80/link/def/batchMenu");
				JSONObject menuObj = (JSONObject) menu_arr.get(0);
				String menu = (String) menuObj.get("value");

				// 지역명 추출
				JSONArray area_arr = (JSONArray) value.get("http://data.ex.co.kr:80/link/def/serviceAreaName");
				JSONObject areaObj = (JSONObject) area_arr.get(0);
				String area = (String) areaObj.get("value");

				// 고속도로명 추출
				JSONArray route_arr = (JSONArray) value.get("http://data.ex.co.kr:80/link/def/routeName");
				JSONObject routeObj = (JSONObject) route_arr.get(0);
				String route = (String) routeObj.get("value");

				// 방향 추출
				JSONArray direction_arr = (JSONArray) value.get("http://data.ex.co.kr:80/link/def/direction");
				JSONObject directionObj = (JSONObject) direction_arr.get(0);
				String direction = (String) directionObj.get("value");
				// 지역명, 고속도로명, 방향

				System.out.println(menu + " / " + price);
				System.out.println(area + " / " + route + " / " + direction);
				
				list.add(new MenuVo(menu, price, area, route, direction));
			}
			fr.close();
			request.setAttribute("list", list);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "/json/menuList.jsp";
	}

}
