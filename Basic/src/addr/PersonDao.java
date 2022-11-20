package addr;

public class PersonDao {
	// Person 객체 담을 배열
		Person[] datas;
		int cnt; // Person 객체의 개수 카운팅

		// 생성자
		PersonDao() {
			datas = new Person[30];
		}

		// 배열에 새 Person 객체를 추가
		void insert(Person p) {// p:새 이름,전화,주소 들어있음
			if (cnt >= datas.length) {
				System.out.println("가득참");
				return;// 종료
			}
			datas[cnt++] = p;
		}

		// 이름으로 검색해서 있으면 검색된 객체를, 없으면 null을 반환
		Person select(String name) {
			for (Person p : datas) {
				if (p == null)
					break;
				if (name.equals(p.name)) {
					return p;
				}
			}
			return null;
		}

		// select2: 이름으로 검색해서 인덱스(방번호)반환
		int select2(String name) {
			for (int i = 0; i < cnt; i++) {
				if (datas[i].name.equals(name)) {
					return i;
				}
			}
			return -1;
		}

		void delete(String name) {
			// 1. 이름으로 위치 찾음
			int idx = select2(name);
			if (idx < 0) {
				System.out.println("not found. 삭제 취소");
				return;
			}
			// 2. 검색되 위치 방을 삭제: 삭제할 방 뒤의 모든 객체를 한칸씩 앞으로 이동
			for (int i = idx; i < cnt; i++) {
				datas[i] = datas[i + 1];
			}
			// 3. cnt 1감소
			cnt--;
		}
}