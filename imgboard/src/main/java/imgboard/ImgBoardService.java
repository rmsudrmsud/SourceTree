package imgboard;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import resource.Factory;

public class ImgBoardService {
	private SqlSessionFactory sqlSessionFactory;

	public ImgBoardService() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	//글번호주는? 서비스
	public int getNum() {
		SqlSession session = sqlSessionFactory.openSession();// session open
		ImgBoardDao dao = (ImgBoardDao) session.getMapper(ImgBoardDao.class);// session을 통해 맵퍼 객체 획득
		int num = dao.selectNum();
		session.close();
		return num;
	}
	public void addImgBoard(ImgBoardVo vo) {
		SqlSession session = sqlSessionFactory.openSession();// session open
		ImgBoardDao dao = (ImgBoardDao) session.getMapper(ImgBoardDao.class);// session을 통해 맵퍼 객체 획득
		dao.insert(vo);
		session.commit();
		session.close();
	}
	
	public ImgBoardVo getImgBoard(int num) {
		SqlSession session = sqlSessionFactory.openSession();// session open
		ImgBoardDao dao = (ImgBoardDao) session.getMapper(ImgBoardDao.class);// session을 통해 맵퍼 객체 획득
		ImgBoardVo vo = dao.select(num);
		session.close();
		return vo;
	}
	
	public ArrayList<ImgBoardVo> getAll(){
		SqlSession session = sqlSessionFactory.openSession();// session open
		ImgBoardDao dao = (ImgBoardDao) session.getMapper(ImgBoardDao.class);// session을 통해 맵퍼 객체 획득
		ArrayList<ImgBoardVo> list = dao.selectAll();
		session.close();
		return list;
	}
	
	public void editImgBoard(ImgBoardVo vo) {
		SqlSession session = sqlSessionFactory.openSession();// session open
		ImgBoardDao dao = (ImgBoardDao) session.getMapper(ImgBoardDao.class);// session을 통해 맵퍼 객체 획득
		dao.update(vo);
		session.commit();
		session.close();
	}
	
	public void delImgBoard(int num) {
		SqlSession session = sqlSessionFactory.openSession();// session open
		ImgBoardDao dao = (ImgBoardDao) session.getMapper(ImgBoardDao.class);// session을 통해 맵퍼 객체 획득
		dao.delete(num);
		session.commit();
		session.close();
	}
}
