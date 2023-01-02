package imgboard;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ImgBoardDao {
	//글추가시 그 글번호를 알기위해
	@Select("select seq_imgboard.nextval from dual") //시퀀스에서 다음번호생성 
	int selectNum();
	
	//vo에서 가져온 #{num}
	@Insert("insert into imgboard values(#{num},#{writer},sysdate,#{title},#{content},#{img_path})")
	void insert(ImgBoardVo vo);
	
	@Select("select * from imgboard where num=#{num}")
	ImgBoardVo select(@Param("num") int num);
	
	@Select("select * from imgboard order by num desc")
	ArrayList<ImgBoardVo> selectAll();

	@Update("update imgboard set title=#{title}, content=#{content}, img_path=#{img_path} where num=#{num}")
	void update(ImgBoardVo vo);

	@Delete("delete from imgboard where num=#{num}")
	void delete(@Param("num") int num);
}
