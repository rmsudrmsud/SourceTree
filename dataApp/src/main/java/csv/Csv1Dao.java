package csv;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface Csv1Dao {
//한줄추가
	@Insert("insert into csv1 values(seq_csv1.nextval, to_date(#{yy_mon},'yyyy-mm'), #{cday}, #{derection}, #{num}, #{cstart},#{start_time},#{cend},#{end_time},#{clevel},#{people_num},to_date(#{date2},'yyyy-mm-dd'),#{station})")
	void insert(Csv1Vo vo);
//전체검색
	@Select("select * from csv1")
	ArrayList<Csv1Vo> selectAll();
	//삭제
	@Delete("delete from csv1")
	void delete();
	
	@Select("select * from scv1 where cnt=#{cnt}")
	Csv1Vo select(@Param("cnt") int cnt);
}
