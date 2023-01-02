package handler.csv;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import csv.Csv1Service;
import csv.Csv1Vo;
import handler.Handler;

public class ListHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Csv1Service service = new Csv1Service();
		ArrayList<Csv1Vo> list = service.getAll();
		request.setAttribute("list", list);
		return "/csv/csv1_list.jsp";
	}

}
