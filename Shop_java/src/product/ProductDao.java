package product;

public class ProductDao{
	private ProductVo[] datas;
	private int cnt; // 데이터 개수

	public ProductDao() {
		datas = new ProductVo[30];
	}

	// insert
	public void insert(ProductVo vo) {
		if (cnt >= datas.length) {
			System.out.println("가득참");
			return;
		}
		datas[cnt++] = vo;
	}

	// selectByNum1: 번호로 검색하여 객체 반환
	public ProductVo selectByNum1(int num) {
		for (int i = 0; i < cnt; i++) {
			if (datas[i].getNum() == num) {
				return datas[i];
			}
		}
		return null;
	}

	// selectByNum2: 번호로 검색하여 인덱스 반환
	public int selectByNum2(int num) {
		for (int i = 0; i < cnt; i++) {
			if (datas[i].getNum() == num) {
				return i;
			}
		}
		return -1;
	}

	// selectByName
	public ProductVo[] selectByName(String name) {
		// datas배열에서 제품명에 name이 포함된 제품을 검색하여 저장할 배열
		ProductVo[] dd = new ProductVo[cnt];
		int cnt1 = 0;// 검색된 개수
		for (int i = 0; i < cnt; i++) {
			if (datas[i].getName().contains(name)) {
				dd[cnt1++] = datas[i];
			}
		}
		ProductVo[] res = new ProductVo[cnt1];
		// 배열 복사. param1:원본배열, param2:원본배열복사시작위치
		// param3:타겟배열, param4:타겟배열복사시작위치, param5:복사할 요소 개수
		System.arraycopy(dd, 0, res, 0, cnt1);
		return res;
	}

	// delete
	public void delete(int num) {
		int idx = selectByNum2(num);
		if (idx < 0) {
			System.out.println("없는 번호");
			return;
		}
		for (int i = idx; i < cnt; i++) {
			datas[i] = datas[i + 1];
		}
		cnt--;
	}

	public ProductVo[] getDatas() {
		return datas;
	}

	public int getCnt() {
		return cnt;
	}
		
}
