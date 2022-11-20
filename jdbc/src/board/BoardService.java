package board;

import java.util.ArrayList;
import java.util.Scanner;

import member.MemberService;

public class BoardService {
	private BoardDao dao;

	public BoardService() {
		dao = new BoardDao();
	}
	//글작성
	public void addBoard(Scanner sc) {
		System.out.println("==글작성==");
		System.out.println("title:");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.println("content(멈추려면 /stop:");
		StringBuilder buf = new StringBuilder(); // 한줄씩 입력받을때마다 stringbuilder에저장
		while (true) {
			String str = sc.nextLine();
			if (str.startsWith("/stop")) {
				break;
			}
			buf.append(str + "\n");
		}
		String content = buf.toString(); // stringbuilder 의 값을 string으로 변환해주는 메서드
		dao.insert(new BoardVo(0, MemberService.loginId, null, title, content));
	}
//	글번호로검색 select 
	public void print(Scanner sc) {
		System.out.println("==검색==");
		System.out.println("검색할 번호:");
		int num = sc.nextInt();
		BoardVo vo = dao.select(num);
		if(vo==null) {
			System.out.println("없는번호");
		}else {
			System.out.println(vo);
		}
	}	
//	글작성자로검색 selectByWriter
	public void printByWriter(Scanner sc) {
		System.out.println("==작성자로검색==");
		System.out.println("검색할 작성자:");
		String name = sc.next();
		BoardVo vo = dao.selectByWriter(name);
		if(vo==null) {
			System.out.println("없는 작성자");
		}else {
			System.out.println(vo);
		}
	}
	//	글제목으로검색 selectByTitle
	public void printByTitle(Scanner sc) {
		System.out.println("==글제목으로검색==");
		System.out.println("검색할 제목:");
		String title = sc.next();
		ArrayList<BoardVo> list = dao.selectByTitle("%"+title+"%");
		for(BoardVo x :list) {
			System.out.println(x);
		}		
	}
	// 글목록
	public void getAll() {
		System.out.println("==전체글목록==");
		ArrayList<BoardVo> list = dao.selectAll();
		for (BoardVo vo : list) { // 리스트에담겨있는 값 가져와서 하나씩 출력
			System.out.println(vo);
		}
	}

	// 수정
	public void editBoard(Scanner sc) {
		System.out.println("==글수정==");
		System.out.println("수정할 글 번호:");
		int num = sc.nextInt();

		BoardVo vo = dao.select(num);
		if (vo == null) {
			System.out.println("없는글. 수정취소");
		} else {
			if (MemberService.loginId.equals(vo.getWriter())) {
				System.out.println(vo);
				System.out.print("new title:");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.print("new content(멈추려면 /stop):");
				StringBuilder buf = new StringBuilder();
				while (true) {
					String str = sc.nextLine();
					if (str.startsWith("/stop")) {
						break;
					}
					buf.append(str + "\n");
				}
				String content = buf.toString();
				dao.update(new BoardVo(num, null, null, title, content));
			} else {
				System.out.println("다른사람의 글은 수정불가");
			}
		}
	}
	
	// 삭제
	public void delete(Scanner sc) {
		System.out.println("=== 삭제 ===");
		System.out.println("삭제할 num:");
		int num = sc.nextInt();
		dao.delete(num);
	}
	
	//페이징
	public void printAllByPaging(Scanner sc) {
		int total = dao.getCnt(); // 총 줄수
		int amount = 3; //한 페이지당 보여줄 양 담은변수
		int pageNum = total/amount+1; //페이지의 수 .만약 4페이지면 4/3 =1. +1 페이지수
		System.out.println("읽을 수 있는 페이지 목록");
		for(int i=1; i<=pageNum; i++) {
			System.out.print("["+i+"]\t");
		}
		System.out.println();
		System.out.println("읽을 페이지 선택");
		int page = sc.nextInt();
		if(page>pageNum || page<=0) {
			System.out.println("없는 페이지. 읽기취소");
			return; //취소
		}
		int start = (page-1)*amount+1;
		int end = page*amount;
		ArrayList<BoardVo> list = dao.selectAllPaging(start, end);
		for(BoardVo vo:list) {
			System.out.println(vo);
		}
	}
	
}
