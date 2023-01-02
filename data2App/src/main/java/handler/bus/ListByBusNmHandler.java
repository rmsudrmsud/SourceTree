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
import handler.Handler;

public class ListByBusNmHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// 검색하기위해 입력한 버스번호
		String busRouteNm = request.getParameter("busRouteNm");
		String serviceKey = "BYgs6%2FjSL0du1z8yK4GxYdW1SepukkJ0gXtUP3tGUQpjThEU4JeQKRlspdSnxTWcjia6U6r5oPxW%2F7tK7HZ2sg%3D%3D";
		String url_str = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList";
		String param = "?ServiceKey=" + serviceKey + "&strSrch=" + busRouteNm;

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
			ArrayList<BusVo> list = new ArrayList<>();
			if (headerCd.equals("0")) {
				NodeList itemList = root.getElementsByTagName("itemList");
				for (int i = 0; i < itemList.getLength(); i++) {
					Element item = (Element) itemList.item(i);
					String busRouteId = 
						item.getElementsByTagName("busRouteId")
						.item(0)
						.getTextContent();
					String busNm = 
							item.getElementsByTagName("busRouteNm")
							.item(0)
							.getTextContent();
					list.add(new BusVo(busRouteId, busNm,"","","","",""
							,""));
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

		return "/bus/list.jsp";
	}

}
