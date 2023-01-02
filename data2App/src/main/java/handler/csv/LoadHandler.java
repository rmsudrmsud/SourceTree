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
			String path1 = "/WEB-INF/files/a_utf8.csv";
			String path2 = request.getServletContext().getRealPath(path1);
			FileReader fr = new FileReader(path2);
			char[] data = new char[10000];
			fr.read(data);

			// char배열을 String으로 변환
			String str = new String(data);

			// 엔터로 쪼개줌
			String[] str2 = str.split("\n");
			
			//제목줄의 각 제목을 배열에 저장
			String[] titles = str2[0].split(",");
			
			ArrayList<Csv1Vo> list = new ArrayList<>();

			for (int i = 1; i < str2.length; i++) {
				System.out.println(str2[i]);
				String[] s = str2[i].split(",");
				if (s.length < 12) {
					break;
				}
				list.add(new Csv1Vo(0, s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8], s[9], s[10], s[11]));
			}

//			request.setAttribute("titles", titles);
//			request.setAttribute("list", list);
			fr.close();
			service.delAll();
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
