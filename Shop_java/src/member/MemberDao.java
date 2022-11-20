package member;

import java.util.ArrayList;

//dao
//db 작업 기능이 목적인 클래스
public class MemberDao {
	private ArrayList<MemberVo> datas;

	public MemberDao() {
		datas = new ArrayList<>();
	}

	// 추가
	public void insert(MemberVo vo) {
		datas.add(vo);
	}

	// 검색해서 객체 반환
	public MemberVo select(String id) {
		for (MemberVo vo : datas) {
			if (id.equals(vo.getId())) {
				return vo;
			}
		}
		return null;
	}

	// 검색해서 인덱스 반환
	public int select2(String id) {
		// ArrayList의 size():데이터 개수
		for (int i = 0; i < datas.size(); i++) {
			MemberVo vo = datas.get(i);// ArrayList의 get(i):i번째 요소 추출
			if (id.equals(vo.getId())) {
				return i;
			}
		}
		return -1;
	}

	// 삭제
	public void delete(String id) {
		int idx = select2(id);
		if (idx < 0) {
			System.out.println("없는 id");
		} else {
			//ArrayList의 remove(방번호): 방번호로 데이터 삭제
			datas.remove(idx);
		}
	}
}
