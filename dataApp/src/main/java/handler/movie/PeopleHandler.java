package handler.movie;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import handler.Handler;
import movie.PeopleVo;

public class PeopleHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String peopleNm = request.getParameter("peopleNm").split("/")[0];
		System.out.println(peopleNm);
		// 접근할 웹 페이지 주소
		URL url;
		try {
			url = new URL(
					"http://kobis.or.kr/kobisopenapi/webservice/rest/people/searchPeopleList.json?key=c4a9774cfe3a1142c4051cf7be3c2e13&peopleNm="
							+ peopleNm);
			// 웹 주소로 연결
			URLConnection conn = url.openConnection();
			// getInputStream(): 웹페이지에서 데이터를 읽을 수 있는 스트림 반환
			InputStream is = conn.getInputStream();
			// json 파일을 분석할 파서 생성
			JSONParser parser = new JSONParser();
			// 생성한 파서로 json파일 분석
			JSONObject obj = (JSONObject) parser.parse(new InputStreamReader(is));
			JSONObject res = (JSONObject) obj.get("peopleListResult");
			JSONArray list = (JSONArray) res.get("peopleList");
			ArrayList<PeopleVo> peoples = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				JSONObject p = (JSONObject) list.get(i);
				String pcode = (String) p.get("peopleCd");
				String name = (String) p.get("peopleNm");
				String filmo = (String) p.get("filmoNames");
				String[] filmos = filmo.split("|");
				System.out.println(name);
				System.out.println(pcode);
				System.out.println(filmo);
				//arraylist에 추가
				peoples.add(new PeopleVo(pcode, name, filmos));
			}
			request.setAttribute("list", peoples);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "/movie/peoples.jsp";
	}

}
