package member;

import java.util.Scanner;

import board.BoardService;

public class Menu {
	private MemberService mservice = new MemberService();
	private BoardService bservice = new BoardService();
	
	public Menu() {
		mservice = new MemberService();
		bservice = new BoardService();
	}
	
	public void run(Scanner sc) {
		boolean flag = true;
		int m=0;
		while(flag) {
			if(MemberService.loginId==null) {
			System.out.println("1.로그인 2.회원가입 3.종료");
			} else {
			System.out.println("4.개인정보관리 5.게시판 3.종료");
			}
			m = sc.nextInt();
			switch(m) {
			case 1:
				mservice.login(sc);
				break;
			case 2:
				mservice.join(sc);
				break;
			case 3:
				flag = false;
				break;
			case 4:
				mrun(sc);
				break;
			case 5:
				brun(sc);
				break;
			}
		}
	}
	
	public void mrun(Scanner sc) {
		boolean flag = true;
		int m=0;
		while(flag) {
			System.out.println("1.내정보확인 2.내정보수정 3.로그아웃 4.탈퇴 5.종료");
			m = sc.nextInt();
			switch(m) {
			case 1:
				mservice.printMemberInfo();
				break;
			case 2:
				mservice.editMemberInfo(sc);
				break;
			case 3:
				mservice.logout();
				flag = false;
				break;
			case 4:
				mservice.out();
				flag = false;
				break;
			case 5:
				flag = false;
				break;
			}
		}
	}
	
	public void brun(Scanner sc) {
		boolean flag = true;
		int m=0;
		while(flag) {
			System.out.println("1.글작성 2.번호검색 3.작성자검색 4.제목검색 5.글목록 6.수정 7.삭제 8.종료");
			m = sc.nextInt();
			switch(m) {
			case 1:
				bservice.addBoard(sc);
				break;
			case 2:
				bservice.print(sc);
				break;
			case 3:
				bservice.printByWriter(sc);
				break;
			case 4:
				bservice.printByTitle(sc);
				break;
			case 5:
				bservice.getAll();
				break;
			case 6:
				bservice.editBoard(sc);
				break;
			case 7:
				bservice.delete(sc);
			case 8:
				flag = false;
				break;
			}
		}
	}
	
}