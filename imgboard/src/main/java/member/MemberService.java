package member;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import resource.Factory;


public class MemberService {
	//기존서비스: dao 객체생성해서 사용했었지만 여기선 인터페이스라 못만듬
	//서비스에서 만들어둔 맵퍼가지고와서 사용
	private SqlSessionFactory sqlSessionFactory;
	
	public MemberService() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	public void addMember(MemberVo m){
		//1번째 db작업: 커넥션수립. openSession 기존의 dbconncter연결
		SqlSession session = sqlSessionFactory.openSession();//session open
		//dao interface 구현체를 받아옴
		//업캐스팅으로 받음 Dao는 기존의 dao객체와 같다. 
		MemberDao dao = (MemberDao) session.getMapper(MemberDao.class);//session을 통해 맵퍼 객체 획득
		//dao 메서드를 호출하여 db작업 수행
		dao.addMember(m);
		//db작업이니까 커밋수행해줘야함. 트랜잭션 커밋(쓰기작업에 필요)
		session.commit();
		//커넥션 닫기
		session.close();
	}
	
	public MemberVo getMember(String id){
		SqlSession session = sqlSessionFactory.openSession();
		MemberDao dao = (MemberDao) session.getMapper(MemberDao.class);
		MemberVo m = dao.getMember(id);
		session.close();
		return m;
	}
	
	public void editMember(MemberVo m){
		SqlSession session = sqlSessionFactory.openSession();
		MemberDao mapper = (MemberDao) session.getMapper(MemberDao.class);
		mapper.editMember(m);
		session.commit();
		session.close();
	}
	
	public void delMember(String id){
		SqlSession session = sqlSessionFactory.openSession();
		MemberDao mapper = (MemberDao) session.getMapper(MemberDao.class);
		mapper.delMember(id);
		session.commit();
		session.close();
	}
}

