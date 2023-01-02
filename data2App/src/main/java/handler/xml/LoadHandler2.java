package handler.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

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
import xml.BookVo;

public class LoadHandler2 implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String path1 = "/WEB-INF/files/data.xml";
		String path2 = request.getServletContext().getRealPath(path1);

		FileInputStream fr;
		try {
			fr = new FileInputStream(path2);

			// dom parser를 생성
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// xml 파일 분석
			Document doc = builder.parse(fr);

			// root 요소 추출. <books>요소 추출
			Element books = doc.getDocumentElement();

			// books 하위 태그중 이름이 book인 요소들 추출
			NodeList bookList = books.getElementsByTagName("book");
			int bookid = 0, price = 0;
			String title = "", author = "";
			ArrayList<BookVo> list = new ArrayList<>();
			for (int i = 0; i < bookList.getLength(); i++) {
				Node book = bookList.item(i);
				NodeList child = book.getChildNodes();

				for (int j = 0; j < child.getLength(); j++) {
					Node n = child.item(j);
					String nodeName = n.getNodeName();
					String val = n.getTextContent();
					switch (nodeName) {
					case "bookid":
						bookid = Integer.parseInt(val);
						break;
					case "title":
						title = val;
						break;
					case "author":
						author = val;
						break;
					case "price":
						price = Integer.parseInt(val);
						break;
					}
				}

				list.add(new BookVo(bookid, title, author, price));

			}
			fr.close();
			request.setAttribute("list", list);
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
		return "/xml/bookList.jsp";
	}

}
