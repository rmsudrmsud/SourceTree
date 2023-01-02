package handler.movie;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import handler.Handler;
import movie.MovieVo;

public class ListXmlHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			// 접근할 웹 페이지 주소
			URL url = new URL(
					"http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.xml?key=c4a9774cfe3a1142c4051cf7be3c2e13&targetDt=20221211");
			// 웹 주소로 연결
			URLConnection conn = url.openConnection();
			// getInputStream(): 웹페이지에서 데이터를 읽을 수 있는 스트림 반환
			InputStream is = conn.getInputStream();

			// xml 파서 생성
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// xml 파일 분석
			Document doc = builder.parse(is);

			// root 요소 추출
			Element root = doc.getDocumentElement();
			NodeList list = root.getElementsByTagName("weeklyBoxOffice");

			ArrayList<MovieVo> movielist = new ArrayList<>();

			for (int i = 0; i < list.getLength(); i++) {
				Element el = (Element) list.item(i);
				int rnum = Integer.parseInt(el.getElementsByTagName("rnum").item(0).getTextContent());
				int rank = Integer.parseInt(el.getElementsByTagName("rank").item(0).getTextContent());
				String movieCd = el.getElementsByTagName("movieCd").item(0).getTextContent();
				String movieNm = el.getElementsByTagName("movieNm").item(0).getTextContent();
				String openDt = el.getElementsByTagName("openDt").item(0).getTextContent();
				String audiAcc = el.getElementsByTagName("audiAcc").item(0).getTextContent();
				String salesAcc = el.getElementsByTagName("salesAcc").item(0).getTextContent();

				movielist.add(new MovieVo(rnum, rank, movieCd, movieNm, 
						openDt, audiAcc, salesAcc));
			}
			//System.out.println(movielist);
			request.setAttribute("movielist", movielist);
			is.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/movie/list.jsp";
	}

}
