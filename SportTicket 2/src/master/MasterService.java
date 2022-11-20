package master;

import java.util.ArrayList;
import java.util.Scanner;

import member.MemberVo;
import post.PostVo;
import reservation.ReservationVo;
import sports.SportsService;
import sports.SportsVo;

public class MasterService {
	private MasterDao dao;
	private SportsService s;

	public MasterService() {
		dao = new MasterDao();
		s = new SportsService();
	}

	// 전체회원정보확인
	public void getAll() {
		System.out.println("===전체회원정보확인===");
		ArrayList<MemberVo> list = dao.selectAll();
		for (MemberVo vo : list) { // 리스트에담겨있는 값 가져와서 하나씩 출력
			System.out.println(vo);
		}
	}

	// id로 회원정보검색
	public void printById(Scanner sc) {
		System.out.println("===회원정보검색===");
		System.out.print("검색할 Id:");
		String name = sc.next();
		MemberVo vo = dao.selectMemid(name);
		if (vo == null) {
			System.out.println("없는 id");
		} else {
			System.out.println(vo);
		}
	}

	// 회원정보 삭제delete - id로
	public void deleteMemid(Scanner sc) {
		System.out.println("=== 삭제 ===");
		System.out.print("삭제할 id:");
		String name = sc.next();
		dao.deleteMemid(name);

		MemberVo vo = dao.selectMemid(name);
		if (vo == null) {
			System.out.println("없는 id");
		} else {
			System.out.println(vo);
		}
	}

	// 회원블랙리스트 확인
	public void printBlack() {
		System.out.println("===블랙리스트확인===");
		dao.printBlacklist();
	}

	// 블랙리스트 회원 추가
	public void insertBlack(Scanner sc) {
		System.out.println("===블랙리스트 추가===");
		System.out.print("추가할 id:");
		String name = sc.next();
		dao.insertBlack(name);
	}

	// id로 블랙리스트 삭제
	public void deleteBlack(Scanner sc) {
		System.out.println("===블랙리스트에서 삭제===");
		System.out.print("삭제할 id:");
		String id = sc.next();
		dao.deleteBlack(id);
	}

	// 경기추가
	public void insertSports(Scanner sc) {
		System.out.println("===경기 추가===");
		System.out.print("경기 종목 :");
		String name = sc.next();
		System.out.print("경기 날짜(yyyy-mm-dd):");
		String date = sc.next();
		System.out.print("경기장 위치:");
		String location = sc.next();
		System.out.print("팀 :");
		String team = sc.next();
		System.out.print("상세설명 :");
		String txt = sc.next();

		dao.insertSports(new SportsVo(0, name, date, location, team, txt));
		System.out.println("===추가 완료===");
	}

	// 경기번호로 경기수정
	public void editSports(Scanner sc) {
       System.out.println("===경기 수정===");
       System.out.println("수정전 경기목록");
       s.printAll(); //경기쪽 전체목록출력
       
       boolean flag = true;
       while(flag) {
       System.out.print("수정할 경기번호:");
       int num = sc.nextInt();
       
       ArrayList<Integer> list = dao.selectSpo_seq();
       for(int i=0; i<list.size(); i++) {
          if (list.get(i) == num) {
             System.out.print("경기종목:");
             String name = sc.next();
             System.out.print("경기날짜:");
             String spo_date = sc.next();
             System.out.print("경기장위치:");
             String location = sc.next();
             System.out.print("팀:");
             String team = sc.next();
             System.out.print("상세설명:");
             String text = sc.next();
             
             dao.update(new SportsVo(list.get(i), name, spo_date, location, team, text));
             System.out.println("===수정완료===");
             flag = false;
          } 

       }  
       }//while()
    }

	// 경기삭제(글번호로)
	public void deleteSports(Scanner sc) {
		System.out.println("===경기삭제===");
		System.out.print("삭제할 경기번호:");
		int num = sc.nextInt();
		dao.deleteSports(num);
		System.out.println("삭제완료");

	}

	// 게시글검색(id로)
	public void selectPost(Scanner sc) {
		System.out.println("==게시글 확인===");
		System.out.print("확인할 id:");
		String name = sc.next();

		PostVo vo = dao.selectById(name);
		if (vo != null) {
			System.out.println("없는 id");
		} else {
			System.out.println(vo);
		}
	}

	// 게시글삭제(글번호로)
	public void deletePost(Scanner sc) {
		System.out.println("===게시글삭제===");
		System.out.print("삭제할 게시글번호:");
		int num = sc.nextInt();
		dao.deletePost(num);
		System.out.println("삭제완료");
	}

	// 경기별 결제/미결제 회원확인
	public void payment() {
		System.out.println("===미결제회원목록===");
		ArrayList<ReservationVo> list = dao.payment();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getMemId());
		}
	}
}