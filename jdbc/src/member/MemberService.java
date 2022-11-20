package member;

import java.util.Scanner;

public class MemberService {
	//db작업할 dao객체
	private MemberDao dao;
	
	//static 로그인아이디를 여러클래스에서 공용으로 써야하기때문에 로그인한 사람아이디 보관
	//로그인 아이디를 저장. loginId=null :로그아웃/ loginId!=null : 로그인
	//다른클래스 어디에서도 로그인하기위해 public. 
	public static String loginId = null; 
	
	public MemberService() {
		dao = new MemberDao();
	}
	//id 중복체크
	public boolean checkId(String id) {
		//==:비교연산자. true or false 검색된값이 null -> true 사용가능한 id,중복안됨
		return dao.select(id) == null; 
	}
	
	//회원가입: id, pwd, name, email입력받아
	//Vo에담아서 dao의 insert(vo)
	public void join(Scanner sc) {
		boolean flag = false;
		String id = null;
		
		System.out.println("===회원가입===");
		while(!flag) { //!flag -> true
			System.out.print("id:");
			id = sc.next();
			
			//아이디 입력시 중복체크
			flag = checkId(id);
			//중복체크 결과가 flase(중복된경우)에 실행
			if(!flag) { //!flag
				System.out.println("중복된아이디. 다시입력하시오");
			}
		}
		
		System.out.print("pwd:");
		String pwd = sc.next();
		System.out.print("name:");
		String name = sc.next();
		System.out.print("email:");
		String email = sc.next();
		
		//입력받은 정보를 db에추가.
		dao.insert(new MemberVo(id, pwd, name, email));
	}
	
	//로그인 기능 -> id,pwd 가 db에 저장된것 과 일치해야 성공.
	public void login(Scanner sc) {
		System.out.println("==로그인==");
		System.out.print("ID:");
		String id = sc.next();
		System.out.print("pwd:");
		String pwd = sc.next();
		
		MemberVo vo = dao.select(id);
		if(vo==null) {
			System.out.println("없는 아이디");
		}else {//검색된 객체 있으면 패스워드 비교
			if(pwd.equals(vo.getPwd())) { //pwd와 vo pwd 같으면 성공
				System.out.println("로그인성공");
				loginId = id; //로그인성공시 로그인아이디 저장
			}else {
				System.out.println("비밀번호 일치하지않음");
			}
		}
	}
	
	//내정보확인
	public void printMemberInfo() {
		System.out.println("==내정보확인==");
		if(loginId==null) {
			System.out.println("로그인 먼저 하시오.");
			return;
		}
		System.out.println(dao.select(loginId));
	}
	
	//내정보 수정
	public void editMemberInfo(Scanner sc) {
		System.out.println("==비밀번호수정==");
		if(loginId==null) {
			System.out.println("로그인 먼저 하시오.");
			return;
		}
		System.out.println("new pwd:");
		String pwd = sc.next();
		dao.update(new MemberVo(loginId,pwd,"","")); //pwd 컬럼값 수정
	}
	
	//로그아웃
	public void logout() {
		System.out.println("==로그아웃==");
		if(loginId==null) {
			System.out.println("로그인 먼저 하시오.");
			return;
		}
		loginId = null; //로그인 아이디를 null로처리해서 로그아웃
	}
	
	//탈퇴
	public void out() {
		System.out.println("==탈퇴==");
		if(loginId==null) {
			System.out.println("로그인 먼저 하시오.");
			return;
		}
		dao.delete(loginId);
		loginId = null; //로그아웃
	}
}
