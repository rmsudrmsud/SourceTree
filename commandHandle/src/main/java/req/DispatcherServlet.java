package req;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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

import handler.Handler;

//실제 요청을 받는 하나의 서블릿. 커맨드핸들러를 쓰면 프로젝트에 서블릿하나만 사용
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//맵 : 키,값을 같이 저장. properties에 저장되어있는 (명령어, 실행할 Handler객체)를 쌍으로 저장하는 역할 
	private Map<String, Handler> map = new HashMap<>();//명령어와 핸들러객체를 담는 맵

	public DispatcherServlet() {
		super();
	}

	@Override
	//init 메서드 : 서블릿페이지가 맨처음 실행될때 한번 호출되어 초기화하는 메서드
	//자바가 컴파일해서 실행 메모리에 올라간다음에 맨처음한번 실행되는 메서드 / 밑의 두겟.두포스트는 요청이 있을때마다 수행
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
			//prop에저장된건 클래스이름문자열일뿐 객체가 아님.
			//그래서 keySet.iteratior 으로키값의 묶음을 꺼냄
			
			//properties의 키값 묶음에 반복자붙임
			Iterator iter = prop.keySet().iterator();//keyset: 순서가없이 중복안되는 키값 집합 iterator: 반복자,한칸한칸이동하면서 값을꺼냄 
			
			//읽을 키가 있을 동안 반복
			while (iter.hasNext()) {//hasNext:다음 읽을 데이터가 있으면 값 읽어오기true,false로
				String url = (String) iter.next();//iter.next로 키를 하나씩 읽어서 url에담기
				//키에 묶인값을 읽는다.(값 :클래스.ex)addHandler
				String className = prop.getProperty(url); //map.get처럼 prop의 url읽어옴. 클래스객체를 생성할라구(map에넣어야하니까)
				try {
					//Class -> 대문자클래스 :클래스에 대한 정보파일.
					//클래스 정보를 읽어서 반환해줌
					Class<?> handlerClass = Class.forName(className);
					//Class객체의 newInstance()메서드는 클래스를 기반으로 객체 생성. handlerClass.newInstance() => 객체생성
					//클래스명이 어떤것이 될지 모르기때문에 객체를 생성 ()
					//Handler 인터페이스형식 업캐스팅된변수 다담김
					Constructor<?> cons = handlerClass.getConstructor(null);
					Handler handler = (Handler) cons.newInstance();
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
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
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
		Handler handler = map.get(url); //맵에 저장된 녀석을키로 사용. 키=> command.properties에 앞의 명령어. 
		//process()
		//결과가 처리되는 3가지방식. 앞에아무것도안붙으면 forward, redirect, 몸체를 그냥주는거->"responsebody/"
		String view = handler.process(request, response); //뷰페이지 경로를 반환받음 process?찾아보기
		if (view.startsWith("redirect:")) { //받은 녀석이 redirect로 시작하면 ~
			String path = view.split(":")[1];// 1번방에잇는 경로를 쪼개서 redirect로 
			response.sendRedirect(request.getContextPath() + path);
		}else if(view.startsWith("responsebody/")){
			response.getWriter().append(view.split("/")[1]); //끊어낸것 뒤에있는녀석으로
		} 
		else { //redirect로 시작하지않ㄴ으면 forward로 보내라
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
