package order;

import java.util.ArrayList;
import java.util.Scanner;

import member.MemberService;
import product.ProductVo;

public class OrderService {
	private OrderDao dao;
	
	public OrderService() {
		dao = new OrderDao();
	}
	
	//주문
	public void addOrder(Scanner sc, ProductVo pv) {
		System.out.print("주문수량:");
		int amount = sc.nextInt();
		int payment = pv.getPrice() * amount;
		dao.insert(new OrderVo(pv, amount, payment, 
				MemberService.loginId));
	}
	
	//내 주문목록
	public void printOrders() {
		System.out.println("내 주문 목록");
		ArrayList<OrderVo> list = dao.selectByOrderId(MemberService.loginId);
		for(OrderVo vo:list) {
			System.out.println(vo);
		}
	}
	
	//결제/미결제 목록 검색
	public OrderVo[] getByPay(boolean flag) {
		return null;
	}
	
	//출고/미출고 목록 검색
	public OrderVo[] getByOut(boolean flag) {
		return null;
	}
	
	//결제
	public void editPay(Scanner sc) {
		//결제할 주문번호 입력받아 결제 처리
	}
	
	//주문취소: 결제 안된 주문 취소 가능
	public void delOrder(Scanner sc) {
		
	}
}
