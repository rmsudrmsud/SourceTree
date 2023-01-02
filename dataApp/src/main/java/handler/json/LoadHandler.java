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
		String path1 = "/WEB-INF/Files/serviceAreaFoods.json"; //하드 실제위치
		String path2 = request.getServletContext().getRealPath(path1); //웹에서 사용할수있는경로로 변경
		//파싱할땐 꼭 파일열어서 형태를 확인
		try {
			//파일의 입출력을 위한 스트림
			FileReader fr = new FileReader(path2);
			
			//파서: 파싱하는기계 , 파싱 : 팟 분석기 -> 각각을 토큰으로 끊어서 토큰의 순서를 분석하는 ?
			//json 파일을 분석할 파서 생성
			JSONParser parser = new JSONParser(); //제이슨을 파싱할 parser객체
			
			//json:객체 아니면 배열 {} , [] ->맨바깥쪽 {}:객체, []:배열. 제이슨 배열 일때 : JSONArray
			
			//생성한 파서로 json 파일 분석 . parse함수
			JSONObject obj = (JSONObject) parser.parse(fr); //스트림을 파라메터로 파싱하는 메서드 이번파일은 맨바깥이{}이니까 jsonobject. []이면 배열
			Iterator iter = obj.keySet().iterator(); //keySet() : 키묶음. 맵(키,값을같이저장) 키셋은iterator을 자주붙힘(순서가없어서..?)
			ArrayList<MenuVo> list = new ArrayList<>();
			
			while(iter.hasNext()) {
				String key = (String) iter.next();
				System.out.println("key: "+key);
				JSONObject value = (JSONObject) obj.get(key); //파라메터(key) obj.의키값 꺼내기
				//가격 추출
				JSONArray salePrice_arr = (JSONArray) value.get("http://data.ex.co.kr:80/link/def/salePrice"); //saleprice키의 값꺼내기. 값이배열형태였음
				JSONObject priceObj = (JSONObject) salePrice_arr.get(0);
				String price =(String) priceObj.get("value");
				//메뉴명 추출
				JSONArray menuPrice_arr = (JSONArray) value.get("http://data.ex.co.kr:80/link/def/batchMenu");
				JSONObject menuObj = (JSONObject) menuPrice_arr.get(0);
				String menu =(String) menuObj.get("value");
				//지역명 추출
				JSONArray area_arr = (JSONArray) value.get("http://data.ex.co.kr:80/link/def/serviceAreaName");
				JSONObject areaObj = (JSONObject) area_arr.get(0);
				String area =(String) areaObj.get("value");
				//고속도로명 추출
				JSONArray route_arr = (JSONArray) value.get("http://data.ex.co.kr:80/link/def/routeName");
				JSONObject routeObj = (JSONObject) route_arr.get(0);
				String route =(String) routeObj.get("value");
				//라벨명 추출
				JSONArray label_arr = (JSONArray) value.get("http://www.w3.org/2000/01/rdf-schema#label");
				JSONObject labelObj = (JSONObject) label_arr.get(0);
				String label =(String) labelObj.get("value");
				//방향 추출
				JSONArray direction_arr = (JSONArray) value.get( "http://data.ex.co.kr:80/link/def/direction");
				JSONObject directionObj = (JSONObject) direction_arr.get(0);
				String direction =(String) directionObj.get("value");
				
				System.out.println(menu + "/" + price + "/" + area+ "/" + route+ "/" + label+ "/" + direction);
				
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
		
		return "/json/menu_list.jsp";
	}
}

//package handler.json;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Iterator;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import handler.Handler;
//
//public class LoadHandler implements Handler {
//
//	@Override
//	public String process(HttpServletRequest request, HttpServletResponse response) {
//		// TODO Auto-generated method stub
//		String path1 = "/WEB-INF/Files/serviceAreaFoods.json";
//		String path2 = request.getServletContext().getRealPath(path1);
//		try {
//			FileReader fr = new FileReader(path2);
//
//			// json 파일을 분석할 파서 생성
//			JSONParser parser = new JSONParser();
//			// 생성한 파서로 json파일 분석
//			JSONObject obj = (JSONObject) parser.parse(fr);
//			Iterator iter = obj.keySet().iterator();
//			while (iter.hasNext()) {
//				String key = (String) iter.next();
//				System.out.println("key:" + key);
//				JSONObject value = (JSONObject) obj.get(key);
//
//				// 가격 추출
//				JSONArray salePrice_arr = (JSONArray) value.get("http://data.ex.co.kr:80/link/def/salePrice");
//				JSONObject priceObj = (JSONObject) salePrice_arr.get(0);
//				String price = (String) priceObj.get("value");
//
//				// 메뉴명 추출
//				JSONArray menuPrice_arr = (JSONArray) value.get("http://data.ex.co.kr:80/link/def/batchMenu");
//				JSONObject menuObj = (JSONObject) menuPrice_arr.get(0);
//				String menu = (String) menuObj.get("value");
//
//				System.out.println(menu + " / " + price);
//			}
//			fr.close();
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return null;
//	}
//
//}
