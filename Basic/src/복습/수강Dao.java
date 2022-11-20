//11월 3일
package 복습;

import java.util.ArrayList;

//dao : db(ArrayList) 작업클래스
//사용자가 원하는 기능을 필요할 때 마다 가져다 쓸 수 있게 메서드별로 쪼개서 작성
//기능 중 ArrayList와 관련된 부분만 구현한다.! 사용자가 입력한다던가 하는 작업은 -> service
//dao는 리스트 추가, 검색, 수정, 삭제, 전체목록 메서드제공!
public class 수강Dao {
	//ArrayList<타입> 객체생성!
	//1,2 둘중 아무거나 사용
	private ArrayList<수강> list; //1. ArrayList 선언
	
	public 수강Dao() { //2. 생성자에서 ArrayList 초기화
		list = new ArrayList<>();
	}
	
		//추가 : 파라메터로 vo 객체를 받아서 ArrayList에 추가 add.(반환값 없음.->void)
	public void insert(수강 vo) { //파라메터 : 수강
		list.add(vo); //파람으로 받은 객체를 리스트에 추가
	}

		//검색(select) : code값이 동일한 객체를 찾아서 반환
	    //검색할 코드값을 파라메터로 받아옴
	    //ArrayList의 요소를 하나씩 꺼내 vo객체의 code와 파라메터로 받은 값 동일한지 비교
	    //같은 객체가 있으면 방번호. 없으면 -1 반환
	    //메서드 반환타입 : int. 메서드 파라메터 타입 : int
		public int select(int code) {
		int i;
		for(i=0; i<list.size();i++) {
			수강 s = list.get(i); //get(i) : i번째 요소 추출
			if(s.getCode()==code) {
				return i;
			}
		}
		return -1;
		
	}
		//파라메터로 방번호를 받음. 그 방에 있는 객체를 리턴. 이름: selectByIdx
		public 수강 selectByIdx(int idx) {
			수강 x = list.get(idx);
			return x;
//			return list.get(idx);  위의것과 같음
		}
		
		
		//수정.
		public void update(수강 s) { //파라메터 수정정보가 담긴 vo객체. 수정할code번호, 새정
			int idx = select(s.getCode());
			if(idx<0) {
				System.out.println("없는코드");
			}else {
				수강 old = selectByIdx(idx);
				old.setProfName(s.getProfName());
				old.setRoom(s.getRoom());
			}
		}

		
		//삭제할 객체의 code값을 받아서 삭제. 리턴값 없음
		public void delete(int code) {
			int idx = select(code); // select arraylist 찾아보기
			if(idx<0) {
				System.out.println("없는코드");
			}else {
				list.remove(idx); //방번호 찾아서 삭제
			}
			
		}
		
		//전체 검색 : arraylist를 반환하기. : 반환타입->어레이리스
		public ArrayList<수강> selectAll(){
			return list;
		}
	}
