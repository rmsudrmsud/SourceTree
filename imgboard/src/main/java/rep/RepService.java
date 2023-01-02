package rep;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import resource.Factory;

public class RepService {
	private SqlSessionFactory sqlSessionFactory;
	
	public RepService() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	public void addRep(RepVo vo) {
		SqlSession session = sqlSessionFactory.openSession();// session open
		RepDao dao = (RepDao) session.getMapper(RepDao.class);// session을 통해 맵퍼 객체 획득
		dao.insert(vo);
		session.commit();
		session.close();
	}
	
	public RepVo getRep(int num) {
		SqlSession session = sqlSessionFactory.openSession();// session open
		RepDao dao = (RepDao) session.getMapper(RepDao.class);// session을 통해 맵퍼 객체 획득
		RepVo vo = dao.select(num);
		session.close();
		return vo;
	}
	
	public ArrayList<RepVo> getAll(int parent){
		SqlSession session = sqlSessionFactory.openSession();// session open
		RepDao dao = (RepDao) session.getMapper(RepDao.class);// session을 통해 맵퍼 객체 획득
		ArrayList<RepVo> list = dao.selectAll(parent);
		session.close();
		return list;
	}
	
	public void editRep(RepVo vo) {
		SqlSession session = sqlSessionFactory.openSession();// session open
		RepDao dao = (RepDao) session.getMapper(RepDao.class);// session을 통해 맵퍼 객체 획득
		dao.update(vo);
		session.commit();
		session.close();
	}
	
	public void delRep(int num) {
		SqlSession session = sqlSessionFactory.openSession();// session open
		RepDao dao = (RepDao) session.getMapper(RepDao.class);// session을 통해 맵퍼 객체 획득
		dao.delete(num);
		session.commit();
		session.close();
	}
}

