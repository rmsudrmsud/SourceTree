package order;

import java.util.ArrayList;

public class OrderDao {
	private ArrayList<OrderVo> orders;

	public OrderDao() {
		orders = new ArrayList<OrderVo>();
	}

	public void insert(OrderVo vo) {
		orders.add(vo);// 주문추가
	}

	// 주문자별 주문목록 검색
	public ArrayList<OrderVo> selectByOrderId(String orderId) {
		ArrayList<OrderVo> list = new ArrayList<OrderVo>();
		for (OrderVo vo : orders) {
			if (orderId.equals(vo.getOrderId())) {
				list.add(vo);
			}
		}
		return list;
	}

	// 주문 번호로 검색하여 주문 객체 반환
	public OrderVo selectByNum1(int num) {
		for (OrderVo vo : orders) {
			if (num == vo.getNum()) {
				return vo;
			}
		}
		return null;
	}

	// 주문 번호로 검색하여 인덱스 반환
	public int selectByNum2(int num) {
		for (int i = 0; i < orders.size(); i++) {
			if (num == orders.get(i).getNum()) {
				return i;
			}
		}
		return -1;
	}

	// pay값이 true/false인거 검색해서 배열에 담아 리턴
	public ArrayList<OrderVo> selectByPay(boolean pay) {
		ArrayList<OrderVo> list = new ArrayList<>();
		for (OrderVo vo : orders) {
			if (vo.isPay() == pay) {
				list.add(vo);
			}
		}
		return list;
	}

	// 주문삭제. 결제 안한것만 취소 가능
	public void delete(int num) {
		int idx = selectByNum2(num);
		if (idx < 0) {
			System.out.println("없는 번호. 주문취소 불가");
		} else {
			if (orders.get(idx).isPay()) {
				System.out.println("이미 결제한 주문은 취소 불가");
			} else {
				orders.remove(idx);
			}
		}
	}
}
