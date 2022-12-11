package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//요청을 처리할 클래스의 조상
public interface Handler {//모든 요청을처리할 클래스를 위해서
	String process(HttpServletRequest request, HttpServletResponse response);//요청을 처리하고 이동할 뷰페이지경로
	
}
