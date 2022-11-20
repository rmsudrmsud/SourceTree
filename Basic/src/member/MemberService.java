package member;

import java.util.Scanner;

public class MemberService {
	private MemberDao dao;
	// logout:loginId가null / login:loginId값할당
	public static String loginId;

	public MemberService() {
		dao = new MemberDao();
	}

	// 로그인
	public void login(Scanner sc) {
		System.out.println("=== 로그인 ===");
		System.out.print("id:");
		String id = sc.next();
		System.out.print("pwd:");
		String pwd = sc.next();

		MemberVo vo = dao.select(id);
		if (vo == null) {
			System.out.println("없는 id");
		} else {
			if (pwd.equals(vo.getPwd())) {
				System.out.println("로그인 성공");
				loginId = vo.getId();
			} else {
				System.out.println("패스워드 불일치");
			}
		}
	}

	// 가입
	public void join(Scanner sc) {
		System.out.println("=== 회원가입 ===");
		String id = "";
		while (true) {
			System.out.print("id:");
			id = sc.next();
			if (dao.select(id) == null) {
				break;
			} else {
				System.out.println("중복된 id. 다른 아이디 입력하시오");
			}
		}
		System.out.print("pwd:");
		String pwd = sc.next();
		System.out.print("email:");
		String email = sc.next();
		System.out.print("tel:");
		String tel = sc.next();

		dao.insert(new MemberVo(id, pwd, email, tel));
	}

	// 로그아웃
	public void logout() {
		if (loginId == null) {
			System.out.println("로그인 먼저 하시오");
		} else {
			loginId = null;// 로그아웃
		}
	}

	// 내정보확인
	public MemberVo printMyInfo() {
		if (loginId == null) {
			System.out.println("로그인 먼저 하시오");
			return null;
		} else {
			MemberVo vo = dao.select(loginId);
			System.out.println(vo);
			return vo;
		}
	}

	// 내정보수정
	public void editMyInfo(Scanner sc) {
		MemberVo vo = printMyInfo();
		if (vo != null) {
			System.out.print("new pwd:");
			vo.setPwd(sc.next());
			System.out.print("new tel:");
			vo.setTel(sc.next());
		}
	}

	// 탈퇴
	public void out() {
		if (loginId == null) {
			System.out.println("로그인 먼저 하시오");
		} else {
			dao.delete(loginId);
			loginId = null;// 로그아웃
		}
	}
}
