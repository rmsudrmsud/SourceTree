package json;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import resource.Factory;

public class MenuService {
	private SqlSessionFactory sqlSessionFactory;
	
	public MenuService() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	public void loadMenu(ArrayList<MenuVo> list) {
		SqlSession session = sqlSessionFactory.openSession();
		MenuDao dao = (MenuDao) session.getMapper(MenuDao.class);
		for(MenuVo vo:list) {
			dao.insert(vo);
		}
		session.commit();
		session.close();
	}
	
}
