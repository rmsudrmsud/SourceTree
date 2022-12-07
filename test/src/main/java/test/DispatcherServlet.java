package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.CommandHandler;

//실제 요청을 받는 하나의 서블릿. 커맨드핸들러를 쓰면 프로젝트에 서블릿하나만 사용
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//맵 : 키,값을 같이 저장. properties에 저장되어있는 (명령어, 실행할 Handler객체)를 쌍으로 저장하는 역할 
	private Map<String, CommandHandler> map = new HashMap<>();

	public DispatcherServlet() {
		super();
	}

	@Override
	//init 메서드 : 서블릿페이지가 맨처음 실행될때 한번 호출되어 초기화하는 메서드
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//properties객체 생성. == Map과 비슷하게 키와 값 저장하는 클래스.
		Properties prop = new Properties();
		
		//properties 파일의 경로
		String path = "/WEB-INF/command.properties";
		//파일의 웹 주소로 변경 
		String path2 = getServletContext().getRealPath(path);
		try {
			//파일의 내용을 읽어서 properties에 복구. 키,값 저장(키:명렁어/값:핸들러)
			prop.load(new FileReader(path2));//fileReader 문자단위로 파일을 읽어들이는 스트림 --(basic) io.test등등 입출력스트림 예제코드부분 살펴보기
			
			//properties의 키값 묶음에 반복자붙임
			Iterator iter = prop.keySet().iterator();//keyset: 순서가없이 중복안되는 키값 집합 iterator: 반복자
			
			//읽을 키가 있을 동안 반복
			while (iter.hasNext()) {//hasNext:다음 읽을 데이터가 있으면 값 읽어오기
				String url = (String) iter.next();//키를 하나씩 읽어서 url에담기
				//키에 묶인값을 읽는다.(값 :클래스.ex)addHandler
				String className = prop.getProperty(url);
				try {
					//Class -> 대문자클래스 :클래스에 대한 정보파일.
					//클래스 정보를 읽어서 반환해줌
					Class<?> handlerClass = Class.forName(className);
					//Class객체의 newInstance()메서드는 클래스를 기반으로 객체 생성. handlerClass.newInstance() => 객체생성
					//클래스명이 어떤것이 될지 모르기때문에 객체를 생성 ()
					//commandHandler : 인터페이스형식 업캐스팅된변수 다담김
					CommandHandler handler = (CommandHandler) handlerClass.newInstance();
					//Map에 명령어와 핸들러객체를 쌍으로 등록
					map.put(url, handler);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getParameter("url"); //요청url을 보낸
		//map.get(url)로 명령어를 보내면 명령어로 등록되어있는 핸들러 객체를 꺼내옴
		CommandHandler handler = map.get(url);
		//process()
		String view = handler.process(request, response); //뷰페이지 경로를 반환받음
		if (view.startsWith("redirect:")) { //받은 녀석이 redirect로 시작하면 ~
			String path = view.split(":")[1];// 1번방에잇는 경로를 쪼개서 redirect로 
			response.sendRedirect(request.getContextPath() + path);
		} else { //redirect로 시작하지않ㄴ으면 forward로 보내라
			RequestDispatcher dis = request.getRequestDispatcher(view);
			dis.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
