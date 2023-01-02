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


/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.do") //원래는 Dispathcersuvlet이었으나 별표로 바꿈으로써 모든 요청을 받음
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Map은 키와 값을 함께 저장한다.=> 이 맵은 properties에 등록되어있는, url과 값을 동시에 담을 수 있따.
	//명령어와 명령어에 따른 실행할 handler객체를 쌍으로 저장할 맵을 생성한 것이다.
	private Map<String, Handler> map = new HashMap<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	//init메서드는 서블릿을 초기화하는 메소드
	@Override
	public void init() throws ServletException { 
		// TODO Auto-generated method stub
		Properties prop = new Properties();//프로퍼티스 객체를 생성.=> 얘는 맵이랑 똑같음
		//map과 비슷하게 키와 값을 저장하는 클래스. 
		
		//여기는 프로퍼티스 파일의 경로이다.
		String path = "/WEB-INF/command.properties";
		
		//이 파일의 웹 주소로 변경
		String path2 = getServletContext().getRealPath(path);
		try {
			//파일의 내용을 문자단위로 읽어서 properties에 복구
			prop.load(new FileReader(path2));//파일리더는 파일을 문자단위로 읽어들이는 스트림. 입출력 스트림을 보면 알 수 있다.
			//키셋은 맵에 있는 키 묶음. 맵 키는 순서가 없으므로 리스트가 아니라 set이다. 순서가 없는 중복되지 않는 데이터 집합. 그래서 현재 prop.keyset. 키셋을 가져와서 iterator반복자를 붙인다.
			//키 값 묶음에 반복자를 붙임
			Iterator iter = prop.keySet().iterator();
			
			//읽을 키가 있을 동안 키를 하나씩 읽어서 url 변수에 담고 그 키에 해당하는 키에 묶인 값을 반복해서 읽음. 그 값이란=> 클래스명.
			while (iter.hasNext()) {//그러고나서 has 넥스트. 다음에 읽을 값이 있으면.
				String url = (String) iter.next();//키 값을 하나 읽어온다.
				String className = prop.getProperty(url);//url을 받아와서 클래스의 이름을 알아내는 것임.
				try {
					//클래스 정보를 읽어서 반환을 해준다.
					Class<?> handlerClass = Class.forName(className);//대문자 클래스는 클래스에 대한 정보파일. 클래스 이름은 뭐고 정보는 뭐고 메소드는 뭐고 등등
					//그 클래스 정보로 객체를 생성. Class객체의 newInstance()메서드는 저 클래스 정보를 기반으로해서 객체를 생성해준다.
					Constructor<?> cons = handlerClass.getConstructor(null);
					Handler handler = (Handler) cons.newInstance();
					
					//명령어와 핸들러 객체를 쌍으로 등록함.
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
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
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
//두 겟 두 포스트는 요청이 올 때마다 반복됨. 포스트로 와도 doget이 처리.
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String url = request.getParameter("url");
		
		String url = request.getServletPath();//요청 url정보
		System.out.println("요청받은 url:"+url);
		//명령어로 등록되어있는 핸들러 객체를 꺼낸다.(커맨드 프로퍼티 파일에서 유알엘 오른편에 있는) 
		Handler handler = map.get(url);//요청 url을 보내면, 그 url에 해당하는 명령어가 있을테니
		//process()를 호출해서 view페이지 경로를 반환받음.그리고 그 경로가 redirect로 시작하면 sendredirect하겠다는 것
		String view = handler.process(request, response);
		if(view==null) {
//			int num = Integer.parseInt(request.getParameter("num"));
			return;
		}
		
		if (view.startsWith("redirect:")) {
			String path = view.split(":")[1];
			response.sendRedirect(request.getContextPath() + path);
		} else if(view.startsWith("responsebody/")) {
			//리스폰스 바디로 시작되면
			String body = view.split("/")[1];
			System.out.println("body:" + body);
			response.getWriter().append(body);
			//뒤에있는 제이슨 값만..출력하시오..?!
			//0번방이 앞에 있고 1번방이 뒤에있으니까 뒤에있는 애를 가져오는건가..?
			//
		} else {//redirect로 시작하지 않는다면 foward이므로
			RequestDispatcher dis = request.getRequestDispatcher(view);
			dis.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
