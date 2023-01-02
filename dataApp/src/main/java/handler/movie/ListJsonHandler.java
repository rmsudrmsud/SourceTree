package handler.movie;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import movie.MovieVo;

public class ListJsonHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		// 접근할 웹 페이지 주소
		URL url;
		try {
			url = new URL(
					"http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?key=c4a9774cfe3a1142c4051cf7be3c2e13&targetDt=20221211");
			// 웹 주소로 연결
			URLConnection conn = url.openConnection();
			// getInputStream(): 웹페이지에서 데이터를 읽을 수 있는 스트림 반환
			InputStream is = conn.getInputStream();//연결된웹페이지에서 바이트단위로 읽을수있는 읽기스트림반환
			// json 파일을 분석할 파서 생성
			JSONParser parser = new JSONParser();
			// 생성한 파서로 json파일 분석
			JSONObject obj = (JSONObject) parser.parse(new InputStreamReader(is));
			JSONObject res = (JSONObject) obj.get("boxOfficeResult");
			String type = (String) res.get("boxofficeType");
			String showRange = (String) res.get("showRange");
//			System.out.println("type: " + type);
//			System.out.println("showRange: " + showRange);
			JSONArray arr = (JSONArray) res.get("weeklyBoxOfficeList"); //weeklyBoxOfficeList키로 작성된 배열에서
			ArrayList<MovieVo> list = new ArrayList<>();
			for (int i = 0; i < arr.size(); i++) {
				JSONObject o = (JSONObject) arr.get(i); //arr배열안에 객체가있으니까 (jsonobject)
				int rnum = Integer.parseInt((String) o.get("rnum"));
				int rank = Integer.parseInt((String) o.get("rank"));
				String movieCd = (String) o.get("movieCd");
				String movieNm = (String) o.get("movieNm");
				String openDt = (String) o.get("openDt");
				String audiAcc = (String) o.get("audiAcc");
				String salesAcc = (String) o.get("salesAcc");
				list.add(new MovieVo(rnum, rank, movieCd, movieNm, openDt, audiAcc, salesAcc));
			}
			
			request.setAttribute("type", type);
			request.setAttribute("showRange", showRange);
			request.setAttribute("movielist", list);
			is.close();
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

		return "/movie/list.jsp";
	}

}
