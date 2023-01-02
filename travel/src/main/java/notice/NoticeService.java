package notice;

import java.util.ArrayList;

public class NoticeService {
	private NoticeDao dao;
	
	public NoticeService() {
		dao = new NoticeDao();
	}
	//공지사항 추가
	public void addNotice(NoticeVo vo) {
		dao.insert(vo);
	}
	//공지사항 번호로 검색
	public NoticeVo getNotice(int notice_num) {
		return dao.select(notice_num);
	}
	//공지사항 제목으로 검색
	public ArrayList<NoticeVo> getByTitle(String title){
		return dao.selectByTitle(title);
	}
		
	//공지사항 전체출력
	public ArrayList<NoticeVo> getAll(){
		return dao.selectAll();
	}

	//공지사항 수정
	public void editNotice(NoticeVo vo) {
		dao.update(vo);
	}
	//공지사항 삭제
	public void delNotice(int notice_num) {
		dao.delete(notice_num);
	}
}