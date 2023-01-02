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
		SqlSession session = sqlSessionFactory.openSession();
		Csv1Dao dao = (Csv1Dao) session.getMapper(Csv1Dao.class);
		for(Csv1Vo vo:list) {
			dao.insert(vo);
		}
		//db작업이니까 커밋수행해줘야함. 트랜잭션 커밋(쓰기작업에 필요)
		session.commit();
		//커넥션 닫기
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
		session.close();
		session.close();
	}
}