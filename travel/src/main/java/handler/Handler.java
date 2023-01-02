package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//얘는 인터페이스 파일로 만들었다. 패키지는 핸들러로. 인터페이스명은 Handler로 만든 것.
//요청 처리 클래스의 조상. 요청 처리하는 것은 모두 Handler를 상속받는다.
public interface Handler {
//얘가 제공하는 메서드는 반환하는 것. 문자열을 반환. 처리하고 뷰페이지 이동하도록. 뷰페이지 경로를 문자열 형태로 변환해주고. 
	String  process(HttpServletRequest request, HttpServletResponse response);//구현하면 안되고. 선언만 해줘야된다. 인터페이스니까.
	//프로세스 안의 내용은 뭘 처리하느냐에 따라서 다르게 구현하면 된다. add라면 add에 맞는 것을. list라면 list에 맞는 것을.
}
