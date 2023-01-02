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
import movie.DetailVo;
import movie.MovieVo;

public class DetailXmlHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String movieCd = request.getParameter("movieCd");
		URL url;
		try {
			url = new URL("https://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.xml?key=60647a5c241469eb9841dc1168a5008e&movieCd="+movieCd);
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			
			//돔파싱 위해
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
//		BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
//		StringBuilder sb = new StringBuilder(); //네트워크를통해 한줄씩읽어들인것을 변환(?)
//		String line = "";
//		while((line = br.readLine())!=null) {//읽어들인 br을 line에 담기) 
//			System.out.println(line);
//			sb.append(line);
//			
//		}
			// xml 파일 분석
			Document doc = builder.parse(is);
			// root 요소 추출(가장상위요소) boxofficeresult
			Element root = doc.getDocumentElement();
			
			NodeList list = root.getElementsByTagName("movieInfo");
		
			ArrayList<DetailVo> movielist = new ArrayList<>();
			for (int i = 0; i<list.getLength();i++) {
				Element el = (Element)list.item(i);
				
				String movieNm = el.getElementsByTagName("movieNm").item(0).getTextContent();
				int showTm = Integer.parseInt(el.getElementsByTagName("showTm").item(0).getTextContent());
				int openDt = Integer.parseInt(el.getElementsByTagName("openDt").item(0).getTextContent());
				String director = el.getElementsByTagName("peopleNm").item(0).getTextContent();
				String actor = el.getElementsByTagName("peopleNm").item(1).getTextContent();
				String actor2 = el.getElementsByTagName("peopleNm").item(2).getTextContent();
				String cast = el.getElementsByTagName("cast").item(0).getTextContent();
				
				movielist.add(new DetailVo(movieNm, showTm, openDt,director, actor, actor2, cast));
			}
			
			System.out.println(movielist);
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
		return "/movie/detail.jsp";
	}

}
