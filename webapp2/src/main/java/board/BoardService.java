package board;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import resource.Factory;

public class BoardService {
	private SqlSessionFactory sqlSessionFactory;

	public BoardService() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	public void addBoard(BoardVo vo) {
		//세션수립 커넥션생성. db와연결
		SqlSession session = sqlSessionFactory.openSession();
		//구현체 객체 받아오기
		BoardDao mapper = (BoardDao) session.getMapper(BoardDao.class);
		//구현체 메서드 호출하여 db작업 실행
		mapper.insert(vo);
		//쓰기작업은세션 커밋이 필요함
		session.commit();
		//Db연결종료
		session.close();
	}

	public BoardVo getBoard(int num) {
		SqlSession session = sqlSessionFactory.openSession();
		BoardDao mapper = (BoardDao) session.getMapper(BoardDao.class);
		BoardVo vo = mapper.select(num);
		session.close();
		return vo;
	}

	public ArrayList<BoardVo> getAll() {
		SqlSession session = sqlSessionFactory.openSession();
		BoardDao mapper = (BoardDao) session.getMapper(BoardDao.class);
		ArrayList<BoardVo> list = mapper.selectAll();
		session.close();
		return list;
	}

	public ArrayList<BoardVo> getByWriter(String writer) {
		SqlSession session = sqlSessionFactory.openSession();
		BoardDao mapper = (BoardDao) session.getMapper(BoardDao.class);
		ArrayList<BoardVo> list = mapper.selectByWriter(writer);
		session.close();
		return list;
	}

	public ArrayList<BoardVo> getByTitle(String title) {
		SqlSession session = sqlSessionFactory.openSession();
		BoardDao mapper = (BoardDao) session.getMapper(BoardDao.class);
		ArrayList<BoardVo> list = mapper.selectByTitle("%"+title+"%");
		session.close();
		return list;
	}

	public void editBoard(BoardVo vo) {
		SqlSession session = sqlSessionFactory.openSession();
		BoardDao mapper = (BoardDao) session.getMapper(BoardDao.class);
		mapper.update(vo);
		session.commit();
		session.close();
	}
	
	public void delBoard(int num) {
		SqlSession session = sqlSessionFactory.openSession();
		BoardDao mapper = (BoardDao) session.getMapper(BoardDao.class);
		mapper.delete(num);
		session.commit();
		session.close();
	}
	
	// 댓글 검색
	public ArrayList<BoardVo> getByParent(int parent_num) {
		SqlSession session = sqlSessionFactory.openSession();
		BoardDao mapper = (BoardDao) session.getMapper(BoardDao.class);
		ArrayList<BoardVo> list = mapper.selectByParent(parent_num);
		session.close();
		return list;
	}
	
}
