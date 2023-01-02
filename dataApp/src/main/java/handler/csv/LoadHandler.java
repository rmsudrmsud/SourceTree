package handler.csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import csv.Csv1Service;
import csv.Csv1Vo;
import handler.Handler;

public class LoadHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Csv1Service service = new Csv1Service();
			try {
				String path1 = "/WEB-INF/Files/a_utf8.csv"; //하드 실제위치
				String path2 = request.getServletContext().getRealPath(path1); //웹에서 사용할수있는경로로 변경
				FileReader fr = new FileReader(path2);
				char[] data = new char[10000];
				fr.read(data);//읽기 쓰기write
				
				//char배열을 String으로 변환
				String str = new String(data);
				//str 문자열하나를 엔터로 쪼개기
				String [] str2 = str.split("\n");
				//제목줄의 각 제목을 배열에 저장 0번째줄 csv특성상 각데이터가 ,로 구분되어있으서 split으로 끊음 이번 파일은 첫번째줄은 제목이 들어가있었어서 제목따로 끊기
				//파일에 따라 자료형태가 달라서 파일을보고 처리할 방법 찾아야함
				String[] titles = str2[0].split(",");
				
				ArrayList<Csv1Vo> list = new ArrayList<>();
				
				//1번줄부터 마지막까지
				for(int i=1; i<str2.length; i++) {
					String[] s = str2[i].split(",");
					if(s.length < 12) {
						break;
					}
					list.add(new Csv1Vo(0,s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9],s[10],s[11]));
					
				}
				
//				request.setAttribute("titles", titles);
//				request.setAttribute("list", list);
				fr.close();
				service.delAll(); //삭제한번하고 읽은 새로운데이터로
				service.loadData(list);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:/index.jsp";
	}
}
