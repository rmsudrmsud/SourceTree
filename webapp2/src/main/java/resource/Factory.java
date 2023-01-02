package resource;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Factory {
	//dao 구현하는 구현객체 생성, 작업조정하는객체
	private static SqlSessionFactory sqlSessionFactory;
	// 초기화 블록:멤버 변수 초기화하는 블록
	static {
		try {
			//환경설정파일을 읽어들이는 reader
			String resource = "resource/config.xml";
			Reader reader = Resources.getResourceAsReader(resource);

			if (sqlSessionFactory == null) {
				//sqlSessionFactory 객체생성
				//Builder : 객체 생성에 필요한 설정이 가능하고 설정한 내용으로 객체를 생성해줌
				//build() : config.xml의 내용을 설정에 활용
				//인터페이스로만든 구현체의 역할
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
				
				//구현할 맵퍼 등록 마이바티스에서 구현할인터페이스를 맵퍼라고 부름
				Class[] mapper = { member.MemberDao.class, board.BoardDao.class}; //맵퍼 파일이 여러개면 {a,b,c...}
				for (Class m : mapper) {
					//구현체를 만들 sqlSessionFactory 객체에 맵퍼 등록
					//구현체:member.MemberDao.class를 상속받아서 만든거~
					sqlSessionFactory.getConfiguration().addMapper(m);
				}
			}
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		} catch (IOException iOException) {
			iOException.printStackTrace();
		}
	}
	//겟터 sessionfactory 리턴, 서비스에서 객체를 가져가서 사용할 수 있도록
	public static SqlSessionFactory getSqlSessionFactory() { 
		return sqlSessionFactory;
	}
}
