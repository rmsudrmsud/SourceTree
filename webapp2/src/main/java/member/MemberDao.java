package member;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MemberDao {
	@Insert("insert into member1 values(#{id}, #{pwd}, #{name}, #{email}, #{type})")
	void addMember(MemberVo m);
	
	@Select("select * from member1 where id=#{id}")
	MemberVo getMember(@Param("id") String id);
	
	@Update("update member1 set pwd=#{pwd} where id=#{id}")
	void editMember(MemberVo m);
	
	@Delete("delete from member1 where id=#{id}")
	void delMember(@Param("id") String id);
}
