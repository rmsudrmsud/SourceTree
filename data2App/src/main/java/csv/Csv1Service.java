package csv;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import resource.Factory;

public class Csv1Service {
	private SqlSessionFactory sqlSessionFactory;

	public Csv1Service() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	public void loadData(ArrayList<Csv1Vo> list) {
		// 커넥션 수립
		SqlSession session = sqlSessionFactory.openSession();// session open
		// dao interface 구현체를 받아옴
		// dao는 기존의 dao객체와 같다
		Csv1Dao dao = (Csv1Dao) session.getMapper(Csv1Dao.class);// session을 통해 맵퍼 객체 획득
		// dao 메서드를 호출하여 db작업 수행
		for(Csv1Vo vo:list) {
			dao.insert(vo);
		}
		// 트랜잭션 커밋(쓰기작업에 필요)
		session.commit();
		// 커넥션 닫음
		session.close();
	}
	
	public ArrayList<Csv1Vo> getAll() {
		SqlSession session = sqlSessionFactory.openSession();
		Csv1Dao dao = (Csv1Dao) session.getMapper(Csv1Dao.class);
		ArrayList<Csv1Vo> list = dao.selectAll();
		session.close();
		return list;
	}
	
	public Csv1Vo getCsv(int cnt) {
		SqlSession session = sqlSessionFactory.openSession();
		Csv1Dao dao = (Csv1Dao) session.getMapper(Csv1Dao.class);
		Csv1Vo vo = dao.select(cnt);
		session.close();
		return vo;
	}
	
	public void delAll() {
		SqlSession session = sqlSessionFactory.openSession();
		Csv1Dao dao = (Csv1Dao) session.getMapper(Csv1Dao.class);
		dao.delete();
		session.commit();
		session.close();
	}
}
