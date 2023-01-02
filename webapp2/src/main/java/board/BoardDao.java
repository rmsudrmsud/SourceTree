package board;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BoardDao {
	@Insert("insert into board values(seq_board.nextval, #{writer}, sysdate, #{title}, #{content}, #{parent_num})")
	void insert(BoardVo vo); //추가니까 반환타입 없음
	
	@Select("select * from board where num=#{num}")
	BoardVo select(@Param("num") int num); //한가지검색해서 반환이니까 vo에 담기
	
	@Select("select * from board where parent_num=0 order by num desc")
	ArrayList<BoardVo> selectAll(); //여러가지 검색  결과값반환 반환타입 : arraylist
	
	@Select("select * from board where writer=#{writer} and parent_num=0 order by num desc")
	ArrayList<BoardVo> selectByWriter(@Param("writer") String writer); //여러가지 검색  결과값반환 반환타입 : arraylist 검색할파라메터
	
	@Select("select * from board where title like #{title} and parent_num=0 order by num desc")
	ArrayList<BoardVo> selectByTitle(@Param("title") String title);
	
	@Update("update board set title=#{title}, content=#{content} where num=#{num}")
	void update(BoardVo vo); //수정은 보통 파라메터로 vo를받아옴
	
	@Delete("delete from board where num=#{num}")
	void delete(@Param("num") int num);
	
	//부모번호로 댓글검색하는
	@Select("select * from board where parent_num=#{parent_num} order by num desc")
	ArrayList<BoardVo> selectByParent(@Param("parent_num") int parent_num);
}
