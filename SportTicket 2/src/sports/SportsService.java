package sports;

import java.util.ArrayList;

public class SportsService {

	SportsDao dao;

	public SportsService() {
		dao = new SportsDao();
	}

	public void printAll() {
		System.out.println("경기목록");

		ArrayList<SportsVo> list = dao.selectAll();
		for (SportsVo vo : list) {
			System.out.println(vo);
		}
		
	}
}
