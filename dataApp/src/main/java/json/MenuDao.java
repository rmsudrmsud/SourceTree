package json;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MenuDao {

	@Insert("insert into menu values(seq_menu.nextval, #{menuName},#{price},#{area},#{routeName},#{direction})")
	void insert(MenuVo vo);

	// 전체검색
	@Select("select * from menu")
	ArrayList<MenuVo> selectAll();

	// 삭제
	@Delete("delete from menu")
	void delete();

	//번호로 검색
	@Select("select * from menu where cnt=#{cnt}")
	MenuVo select(@Param("cnt") int cnt);

}
