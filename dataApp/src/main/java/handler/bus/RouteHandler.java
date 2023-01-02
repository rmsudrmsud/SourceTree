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

import bus.StationVo;
import handler.Handler;

public class RouteHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			String busRouteId = request.getParameter("busRouteId");
			String serviceKey = "BYgs6%2FjSL0du1z8yK4GxYdW1SepukkJ0gXtUP3tGUQpjThEU4JeQKRlspdSnxTWcjia6U6r5oPxW%2F7tK7HZ2sg%3D%3D";
			URL url = new URL("http://ws.bus.go.kr/api/rest/busRouteInfo/getStaionByRoute?serviceKey="+serviceKey+"&busRouteId="+busRouteId);
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = builder.parse(is);
			Element root = doc.getDocumentElement();
			
			ArrayList<StationVo> list = new ArrayList<>();
			
			String arsid = "";
			String busRouteNm = "";
			String stationNm = "";
			String direction = "";
			NodeList itemList = root.getElementsByTagName("itemList");
			for(int i=0;i<itemList.getLength();i++) {
				NodeList child = itemList.item(i).getChildNodes();
				for(int j=0;j<child.getLength();j++) {
					String name = child.item(j).getNodeName();
					String val = child.item(j).getTextContent();
					switch(name) {
					case "arsid":
						arsid = val;
						break;
					case "busRouteNm":
						busRouteNm = val;
						break;
					case "stationNm":
						stationNm = val;
						break;
					case "direction":
						direction = val;
						break;
					}
				}
				StationVo vo = new StationVo(arsid, busRouteId, busRouteNm, stationNm, direction);
				list.add(vo);
			}
			
			is.close();
			request.setAttribute("busRouteNm", busRouteNm);
			request.setAttribute("list", list);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/bus/stationList.jsp";
	
	}

}
