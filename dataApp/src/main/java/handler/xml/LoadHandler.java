package handler.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import handler.Handler;

public class LoadHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String path1 = "/WEB-INF/Files/data.xml";
		String path2 = request.getServletContext().getRealPath(path1);
		try {
			FileInputStream fr = new FileInputStream(path2);
			//dom에 대한 parser사용할 객체 생성
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			//파싱할수있는 documentbuilder
			DocumentBuilder builder = factory.newDocumentBuilder();
			//xml 파일 분석
			Document doc = builder.parse(fr);
			//root 요소 추출(최상위요소). <books>요소 추출
			Element el = doc.getDocumentElement();
			// <books>의 자식 노드들 추출
			NodeList list = el.getChildNodes();

			for (int i = 0; i < list.getLength(); i++) {
				// <book> 태그 하나씩 추출
				// item(i) : NodeList에서 i번째 요소 추출
				//node: 태그요소 하나
				Node node = list.item(i);
				NodeList child = node.getChildNodes();
				for (int j = 0; j < child.getLength(); j++) {
					Node c = child.item(j);
					//getNodeName() : 태그명 반환
					System.out.println("node name:" + c.getNodeName());
					//getTextContent() : 태그의 텍스트값 반환
					System.out.println("node value:" + c.getTextContent());
				}
			}
			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

