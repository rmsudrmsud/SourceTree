package rep;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface RepDao {
	@Insert("insert into img_rep values(seq_img_rep.nextval,#{writer},#{content},#{parent})")
	void insert(RepVo vo);
	
	@Select("select * from img_rep where num=#{num}")
	RepVo select(@Param("num") int num); 
	
	@Select("select * from img_rep where parent=#{parent} order by num")
	ArrayList<RepVo> selectAll(@Param("parent") int parent);
	
	@Update("update img_rep set content=#{content} where num=#{num}")
	void update(RepVo vo);
	
	@Delete("delete from img_rep where num=#{num}")
	void delete(@Param("num") int num);
	
}

