package handler.bus;

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

import bus.BusVo;
import bus.StationVo;
import handler.Handler;

public class InfoByRouteIdHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String busRouteId = request.getParameter("busRouteId");
		String serviceKey = "BYgs6%2FjSL0du1z8yK4GxYdW1SepukkJ0gXtUP3tGUQpjThEU4JeQKRlspdSnxTWcjia6U6r5oPxW%2F7tK7HZ2sg%3D%3D";
		String url_str = "http://ws.bus.go.kr/api/rest/busRouteInfo/getRouteInfo";
		String param = "?ServiceKey=" + serviceKey + "&busRouteId=" + busRouteId;
		
		String serviceKey2 = "BYgs6%2FjSL0du1z8yK4GxYdW1SepukkJ0gXtUP3tGUQpjThEU4JeQKRlspdSnxTWcjia6U6r5oPxW%2F7tK7HZ2sg%3D%3D";
		String url_str2 = "http://ws.bus.go.kr/api/rest/busRouteInfo/getStaionByRoute";
		String param2 = "?ServiceKey=" + serviceKey2 + "&busRouteId=" + busRouteId;
		
		try {
			URL url = new URL(url_str + param);
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
			String headerCd = root.getElementsByTagName("headerCd").item(0).getTextContent();
			//태그이름으로 검색하기위해 엘리먼트태그 필요
			//노드는 하위요소의 child 를 순차적으로 뽑는방법밖에없어서 
			//태그이름으로 찾기위해 element타입을써서 메소드 제공 getElementsBy
			Element itemList = (Element) root.getElementsByTagName("itemList").item(0);
			//값 하나만 주니까 배열 필요 x
			if (headerCd.equals("0")) {
				String busId = itemList.getElementsByTagName("busRouteId").item(0).getTextContent();
				String busNm = itemList.getElementsByTagName("busRouteNm").item(0).getTextContent();
				String corpNm = itemList.getElementsByTagName("corpNm").item(0).getTextContent();
				String stStationNm = itemList.getElementsByTagName("stStationNm").item(0).getTextContent();
				String edStationNm = itemList.getElementsByTagName("edStationNm").item(0).getTextContent();
				String term = itemList.getElementsByTagName("term").item(0).getTextContent();
				String firstBusTm = itemList.getElementsByTagName("firstBusTm").item(0).getTextContent();
				String lastBusTm = itemList.getElementsByTagName("lastBusTm").item(0).getTextContent();
				
				BusVo vo = new BusVo(busId, busNm, corpNm, stStationNm, edStationNm, term, firstBusTm, lastBusTm);
				request.setAttribute("vo", vo);
				
			} else {
				return "/bus/error.jsp";
			}
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
		
		try {
			URL url2 = new URL(url_str2 + param2);
			URLConnection conn = url2.openConnection();
			// getInputStream(): 웹페이지에서 데이터를 읽을 수 있는 스트림 반환
			InputStream is = conn.getInputStream();
			// xml 파서 생성
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// xml 파일 분석
			Document doc = builder.parse(is);
			// root 요소 추출
			Element root = doc.getDocumentElement();
			String headerCd = root.getElementsByTagName("headerCd").item(0).getTextContent();
			//태그이름으로 검색하기위해 엘리먼트태그 필요
			//노드는 하위요소의 child 를 순차적으로 뽑는방법밖에없어서 
			//태그이름으로 찾기위해 element타입을써서 메소드 제공 getElementsBy
			ArrayList<StationVo> list = new ArrayList<>();
			//값 하나만 주니까 배열 필요 x
			if (headerCd.equals("0")) {
				NodeList itemList = root.getElementsByTagName("itemList");
				for (int i = 0; i < itemList.getLength(); i++) {
					Element item = (Element) itemList.item(i);
				String busId = item.getElementsByTagName("busRouteId").item(0).getTextContent();
				String busNm = item.getElementsByTagName("busRouteNm").item(0).getTextContent();

				String stationNm = item.getElementsByTagName("stationNm").item(0).getTextContent();
				String direction = item.getElementsByTagName("direction").item(0).getTextContent();
			
				list.add(new StationVo(busId, busNm, stationNm, direction));
				}
				request.setAttribute("list", list);
			} else {
				return "/bus/error.jsp";
			}
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
		return "/bus/businfo.jsp";
	}

}
