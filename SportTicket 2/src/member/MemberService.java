package member;

import java.util.ArrayList;
import java.util.Scanner;

import master.MasterDao;
import master.MasterService;
import post.PostService;
import post.PostVo;
import reservation.ReservationDao;
import reservation.ReservationVo;

public class MemberService {
	
	private MemberDao dao;
	private ReservationDao resDao;
	private PostService poService;
	private MasterDao maDao;
	
	public static String loginId = null;
	public static int memType = 0;
	
	public MemberService() {
		dao = new MemberDao();
		resDao = new ReservationDao();
		poService = new PostService();
		maDao = new MasterDao();
	}
	
	//로그인
	public void login(Scanner sc) {
		System.out.println();
		System.out.println("(1)로그인");
		System.out.println("============");
		System.out.print("아이디: ");
		String id = sc.next();
		System.out.print("비밀번호: ");
		String pwd = sc.next();
		
		MemberVo result = dao.selectMember(id);
		if(result == null) {
			System.out.println("없는 아이디입니다.");
			login(sc);
		} else {
			if (result.getPwd().equals(pwd)){
				loginId = id;
				memType = result.getMaster();
			} else {
				System.out.println("잘못된 비밀번호 입니다.");
				login(sc);
			}
		}
	}//login()
	
	//미결제 회원에게 팝업 
	public void popMessage() {
		
		ArrayList<ReservationVo> list = maDao.payment();
		String nonPayId = "";
		for(int i=0; i<list.size();i++) {
			nonPayId = list.get(i).getMemId();
			
			if(nonPayId.equals(loginId)) {
				System.err.println(" *** 현재 예약상품이 미결제 상태입니다 ***");			
			} else {
				break;
			}
		}
	}//popMessage()
	
	public MemberVo getMember(String id) {
		return dao.selectMember(id);
	}
	
	//ID중복체크 , 없으면 TRUE
	public boolean checkId(String id) {
		return dao.selectMember(id) == null;
	}//checkId()
	
	
	//회원가입
	public void join(Scanner sc) {
		System.out.println("(2)회원가입");
		System.out.println("============");
		
		boolean flag = false;
		String id = " ";
		
		while(!flag) {
			System.out.print("아이디: ");
			id = sc.next();
			flag = checkId(id);
			
			if(!flag) {
				System.out.println("중복된 아이디입니다.");
			}
		}
		
		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("비밀번호: ");
		String pwd = sc.next();
		System.out.print("이메일: ");
		String email = sc.next();
		System.out.print("주소: ");
		String addr = sc.nextLine();
		sc.nextLine();
		
		dao.insertMember(new MemberVo(id, pwd, email, addr, 0, name, 0));
		System.out.println();
		System.out.println("회원가입이 완료되었습니다. ");
	}//join()
	
	
	//회원탈퇴 
	public void out(Scanner sc) {
		System.out.println("회원탈퇴");
		System.out.println("============");
		System.out.print("탈퇴하시겠습니까? (1)네 (2)아니오 : ");
		int num = sc.nextInt();
		
		if(num == 1) {
			dao.deleteMember(loginId);
			loginId = null;
		} else {
			System.out.println("메인으로 돌아갑니다.");
		}
	}//out()
	
	
	//로그아웃
	public int logout(Scanner sc) {
		System.out.println("로그아웃");
		System.out.println("============");
		System.out.print("로그아웃 하시겠습니까? (1)네 (2)아니오 : ");
		int num = sc.nextInt();
		
		if(num == 1) {
			loginId = null;
			return 0;
		} else {
			System.out.println("메인으로 돌아갑니다.");
			return 1;
		}
	}//logout()
	
	//내 정보 확인 
	public void checkInfo() {
		System.out.println("(1) 내 정보 확인 ");
		System.out.println("============");
		MemberVo res = dao.selectMember(loginId);
		System.out.println(res);
	}//checkInfo
	
	//내 정보 수정 
		public void editInfo(Scanner sc) {
			System.out.println("(2) 내 정보 수정  ");
			System.out.println("============");
			System.out.println("이름: ");
			String name = sc.next();
			System.out.println("비밀번호: ");
			String pwd = sc.next();
			System.out.println("이메일: ");
			String email = sc.next();
			System.out.println("주소: ");
			String addr = sc.next();
		
			MemberVo res = dao.selectMember(loginId);
			res =  new MemberVo(loginId, pwd, email, addr, res.getBlackList(), name, res.getMaster());
			
			dao.updateMember(res, loginId);
			System.out.println("정보 수정이 완료되었습니다. ");

		}//checkInfo
	
	
	//예매한 경기 확인
	public void checkRes() {
		System.out.println("예매한 경기 목록 확인");
		System.out.println("============");
		ArrayList<ReservationVo> res = resDao.printMyRes(loginId);
		for(ReservationVo vo : res) {
			System.out.println(vo);
		}
		System.out.println("============");
	}//checkRes()
	
	
	//예매한 경기 취소 
	public void deleteRes(Scanner sc) {
		System.out.println("예매한 경기 취소");
		System.out.println("============");
		checkRes();
		System.out.println("============");
		System.out.println("취소할 경기 번호: ");
		int num = sc.nextInt();
		resDao.deleteMyRes(loginId, num);
		System.out.println("경기가 취소되었습니다.");
	}//deleteRes

	
	//관리자 쪽지 확인
	
	
	//내가 쓴 게시글 확인
	public void checkPost() {
		System.out.println("내가 쓴 게시글 확인");
		System.out.println("============");
		poService.getForMemIdAll();
		System.out.println("============");
	}//checkPost
	
	//내가 쓴 게시글 수정 
	public void updatePost() {
		System.out.println("내가 쓴 게시글 수정 ");
		System.out.println("============");
		poService.getForMemIdAll();
		System.out.println("============");
		poService.editPost();
	}//checkPost
	
	//내가 쓴 게시글 확인
	public void deletePost() {
		System.out.println("내가 쓴 게시글 삭제 ");
		System.out.println("============");
		poService.getForMemIdAll();
		System.out.println("============");
		poService.deletePost();
	}//checkPost
	
}//MemberService
