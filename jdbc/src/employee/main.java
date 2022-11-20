package employee;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpDao dao = new EmpDao();
//      전체검색
//		ArrayList<EmpVo> list = dao.selectAll();
//		for(EmpVo vo : list) {
//			System.out.println(vo);
//		}
		System.out.println("======");
		EmpVo vo = dao.select(1000);
		if(vo==null) {
			System.out.println("없는번호");
		}else {
			System.out.println(vo);
		}
	}

}
