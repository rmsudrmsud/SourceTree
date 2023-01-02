package handler.web;

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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import handler.Handler;
import xml.DataVo;
import xml.LocationVo;

public class LoadXmlHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			//접근할 웹페이지 주소
			URL url = new URL("http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109");
			//웹 주소로 연결 네트워크에 연결하는메서드
			URLConnection conn = url.openConnection();
			//conn객체와 연결한곳에서 읽어들임 getInputStream() : 웹페이지에서 데이터를 읽을 수 있는 스트림 반환
			//1바이트단위는 글자가 꺠질수있음
			InputStream is = conn.getInputStream();
//			//bufferedReader 스트림에 버퍼장착->속도개선
//			//InputStreamReader 바이트단위로 읽어들인것을 문자단위로 변환
//			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
//			StringBuilder sb = new StringBuilder(); //네트워크를통해 한줄씩읽어들인것을 변환(?)
//			String line = "";
//			while((line = br.readLine())!=null) {//읽어들인 br을 line에 담기) 
//			System.out.println(line);
//				sb.append(line);
//			}
			
			// xml 파서 생성
						DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
						DocumentBuilder builder = factory.newDocumentBuilder();

						// xml 파일 분석
						Document doc = builder.parse(is);

						// root 요소 추출
						Element root = doc.getDocumentElement();

						// root 하위의 요소들 중 태그명으로 검색
						Node author_node = root.getElementsByTagName("author").item(0);
						Node category_node = root.getElementsByTagName("category").item(0);
						Node title_node = root.getElementsByTagName("title").item(1);
						//여러개 나올 확률높아서 배열로만들기

						// getFirstChild(): 첫번째 자식 노드
						// getNodeValue(): 노드의 텍스트값 반환(값읽어오기) or textcontext? 사용
						String author = author_node.getFirstChild().getNodeValue();
						String category = category_node.getFirstChild().getNodeValue();
						String title = title_node.getFirstChild().getNodeValue();

						System.out.println("author: " + author);
						System.out.println("category: " + category);
						System.out.println("title: " + title);
						ArrayList<LocationVo> list = new ArrayList<>();
						// 모든 location 태그 추출
						NodeList loc_nodes = root.getElementsByTagName("location"); //dom객체 node 여러개가 들어있는 배열 nodelist
						for (int i = 0; i < loc_nodes.getLength(); i++) {

							// location을 하나씩 꺼내서
							Node loc_node = loc_nodes.item(i); //item: 돔요소에서 원하는위치의값 꺼내오는메서드
							// 자식 추출. city, data태그들
							NodeList loc_childs = loc_node.getChildNodes();
							String city = "";
							ArrayList<DataVo> datas = new ArrayList<>();
							for (int j = 0; j < loc_childs.getLength(); j++) {
								Node loc_child = loc_childs.item(j);
								String nodeName = loc_child.getNodeName();
								// 태그명 city이면
								if (nodeName.equals("city")) {
									city = loc_child.getTextContent();
									System.out.println("city: " + city);
								} else if (nodeName.equals("data")) {
									// data 태그이면 그 자식 노드를 추출
									// tmEf:날짜시간, wf:날씨, tmn:최저기온, tmx:최고기온
									String tmEf = "";
									String wf = "";
									String tmn = "";
									String tmx = "";
									NodeList data_childs = loc_child.getChildNodes();
									for (int k = 0; k < data_childs.getLength(); k++) {
										Node data = data_childs.item(k);
										String name = data.getNodeName();

										switch (name) {
										case "tmEf":
											tmEf = data.getTextContent();
											System.out.println("날짜/시간: " + tmEf);
											break;
										case "wf":
											wf = data.getTextContent();
											System.out.println("날씨:" + wf);
											break;
										case "tmn":
											tmn = data.getTextContent();
											System.out.println("최저기온:" + tmn);
											break;
										case "tmx":
											tmx = data.getTextContent();
											System.out.println("최고기온:" + tmx);
											break;
										}
									}
									datas.add(new DataVo(tmEf, wf, tmn, tmx));
								}
							}
							list.add(new LocationVo(city, datas));
						}
						request.setAttribute("list", list);
						request.setAttribute("title", title);
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

					return "/xml/weather.jsp";
	}

}
