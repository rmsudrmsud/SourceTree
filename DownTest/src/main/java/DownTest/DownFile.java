package DownTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownFile
 */
@WebServlet("/DownFile")
public class DownFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		//다운로드파일 꺼낼 폴더
		String downDir = "/Users/choigeunhyeong/Documents/down/";
		//사용자가 클릭한 파일명
		String fname = request.getParameter("fname");
		String path = downDir + fname; // 다운로드할 파일 전체 경로
		
		//파일객체 만들기: 파일에대한 정보를 가지고있는 클래스(크기,읽기모드, 실ㅇ행가능, 존재하는지 유무..)
		File file = new File(path);
		
		//다운로드할 파일의 내용을 읽을 스트림 생성
		//FileInputStream : 파일안의 내용을 바이트단위로 읽고싶을때
		FileInputStream in = new FileInputStream(path);
		
		//파일명인코딩(한글이깨지지 않기위해서)
		//String객체 생성. fname(파일명).getbytes
		fname = new String(fname.getBytes("UTF-8"), "8859_1");
		
		//setContentType : 파일의 마임설정. 파일의 종류.
		//다운로드 응답을 보내기위한 response 설정
		//octet-stream 바이너리파일의 한 종류 8진수 스트림. 바이너리 파일은 데이터의 저장과 처리를 목적으로 0과 1의 이진 형식으로 인코딩된 파일
		response.setContentType("application/octet-stream"); 
		//헤더설정. 패킷의 현재 중요 정보를 설정. Content-Disposition:첨부파일을 보내겠다는 헤더설정
		response.setHeader("Content-Disposition", "attachment; filename="+fname); //클라이언트 컴퓨터에서 파일이름으로 저장하라고 첨부파일명(fname) 넣어줌
		
		//다운로드파일 내용을 response에 출력할 출력스트림
		//outputStream 바이트단위로출력하는 최대단위 스트림.
		OutputStream os = response.getOutputStream();

		int length;
		//다운로드 파일에서 읽은 내용을 담을 byte배열을 파일크기와 동일하게 생성
		byte[] b = new byte[(int) file.length()];
		//파일에서 읽은 내용을 response에 출력
		while ((length = in.read(b)) > 0) { //read : 스트림에서 읽어들이는 함수
			os.write(b, 0, length); //write :스트림에서 출력하는 함수
		}
		
		//스트림 복습하면서 책을 읽어보기!
		
		os.flush(); //버퍼의 내용 강제출력
		
		//사용한스트림 닫기
		os.close();
		in.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
