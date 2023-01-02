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

public class DetailJsonHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String movieCd = request.getParameter("movieCd");
		// 접근할 웹 페이지 주소
		URL url;
		try {
			url = new URL(
					"http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=c4a9774cfe3a1142c4051cf7be3c2e13&movieCd="
							+ movieCd);
			// 웹 주소로 연결
			URLConnection conn = url.openConnection();
			// getInputStream(): 웹페이지에서 데이터를 읽을 수 있는 스트림 반환
			InputStream is = conn.getInputStream();
			// json 파일을 분석할 파서 생성
			JSONParser parser = new JSONParser();
			// 생성한 파서로 json파일 분석
			JSONObject obj = (JSONObject) parser.parse(new InputStreamReader(is));
			JSONObject res = (JSONObject) obj.get("movieInfoResult");
			JSONObject info = (JSONObject) res.get("movieInfo");
			String movieNm = (String) info.get("movieNm");
			String showTm = (String) info.get("showTm");
			String openDt = (String) info.get("openDt");
			JSONArray direcs = (JSONArray) info.get("directors");
			ArrayList<String> directors = new ArrayList<>();
			for (int i = 0; i < direcs.size(); i++) {
				JSONObject d = (JSONObject) direcs.get(i);
				directors.add((String) d.get("peopleNm"));
			}
			JSONArray acs = (JSONArray) info.get("actors");
			ArrayList<String> actors = new ArrayList<>();
			for (int i = 0; i < acs.size(); i++) {
				JSONObject d = (JSONObject) acs.get(i);
				String name = (String) d.get("peopleNm");
				String cast = (String) d.get("cast");
				actors.add(name + "/배역:" + cast);
			}
			request.setAttribute("movieNm", movieNm);
			request.setAttribute("showTm", showTm);
			request.setAttribute("openDt", openDt);
			request.setAttribute("directors", directors);
			request.setAttribute("actors", actors);
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

		return "/movie/detail.jsp";
	}

}
