package handler.bus;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import handler.Handler;

public class StationXmlHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String txt ="";
		try {
			String arsId = request.getParameter("arsId");
			//System.out.println(arsId);
			String serviceKey = "BYgs6%2FjSL0du1z8yK4GxYdW1SepukkJ0gXtUP3tGUQpjThEU4JeQKRlspdSnxTWcjia6U6r5oPxW%2F7tK7HZ2sg%3D%3D";
			URL url = new URL("http://ws.bus.go.kr/api/rest/stationinfo/getRouteByStation?serviceKey=" + serviceKey
					+ "&arsId=" + arsId);
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = builder.parse(is);
			Element root = doc.getDocumentElement();

			NodeList itemList = root.getElementsByTagName("itemList");
			
			JSONArray arr = new JSONArray();
			for (int i = 0; i < itemList.getLength(); i++) {
				Element item = (Element) itemList.item(i);
				String busRouteNm = item.getElementsByTagName("busRouteNm").item(0).getTextContent();
				arr.add(busRouteNm);
			}
			txt = arr.toJSONString();
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
		return "responsebody/"+txt;
	}

}
