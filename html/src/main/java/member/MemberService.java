package member;

import java.util.Scanner;

public class MemberService {
	
	private MemberDao dao;
	
	public MemberService() {
		dao = new MemberDao();
	}

	public void join(MemberVo vo) {
		dao.insert(vo);
	}

	public MemberVo getMember(String id) {
		return dao.select(id);		
	}

	public void editMember(MemberVo vo) {
		dao.update(vo);
	}

	public void delMember(String id) {	
		dao.delete(id);
	}
}
