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
			URL url = new URL("http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.xml?key=c4a9774cfe3a1142c4051cf7be3c2e13&targetDt=20221211");
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			
			//돔파싱 위해
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
//			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
//			StringBuilder sb = new StringBuilder(); //네트워크를통해 한줄씩읽어들인것을 변환(?)
//			String line = "";
//			while((line = br.readLine())!=null) {//읽어들인 br을 line에 담기) 
//				System.out.println(line);
//				sb.append(line);
//				
//			}
			// xml 파일 분석
			Document doc = builder.parse(is);
			// root 요소 추출(가장상위요소) boxofficeresult
			Element root = doc.getDocumentElement();
			NodeList list = root.getElementsByTagName("weeklyBoxOffice");
			ArrayList<MovieVo> movielist = new ArrayList<>();
			for (int i = 0; i<list.getLength();i++) {
				Element el = (Element)list.item(i); //노드리스트에서 하나씩꺼내면 노드객체 를 element로 형변환해서 사용하면 getelementbytaname으로 ㅅ꺼낼수있음
				int rnum = Integer.parseInt(el.getElementsByTagName("rnum").item(0).getTextContent());
				//el :위클리박스오피스의 자식중 rnum태그 검색.(배열에담아줌).getTextContent: 노드값 꺼내기
				int rank = Integer.parseInt(el.getElementsByTagName("rank").item(0).getTextContent());
				String movieCd = el.getElementsByTagName("movieCd").item(0).getTextContent();
				String movieNm = el.getElementsByTagName("movieNm").item(0).getTextContent();
				String openDt = el.getElementsByTagName("openDt").item(0).getTextContent();
				String audiAcc = el.getElementsByTagName("audiAcc").item(0).getTextContent();
				String salesAcc = el.getElementsByTagName("salesAcc").item(0).getTextContent();
				movielist.add(new MovieVo(rnum,rank,movieCd,movieNm,openDt,audiAcc,salesAcc));
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
