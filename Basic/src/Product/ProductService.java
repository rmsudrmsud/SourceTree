package Product;

import java.util.Scanner;

public class ProductService {
	private ProductDao dao;

	public ProductService() {
		dao = new ProductDao();
	}

	// 추가: 제품명,가격, 수량 입력 받아서 배열에 추가
	public void addProduct(Scanner sc) {
		System.out.println("=== 제품 등록 ===");
		// 정보입력
		System.out.print("name:");
		String name = sc.next();
		System.out.print("price:");
		int price = sc.nextInt();
		System.out.print("amount:");
		int amount = sc.nextInt();

		// 배열에 저장
		dao.insert(new ProductVo(name, price, amount));
	}

	// 번호로검색
	public void getProductByNum(Scanner sc) {
		System.out.println("=== 제품 번호로 검색 ===");

		System.out.print("검색할 num:");
		int num = sc.nextInt();

		ProductVo vo = dao.selectByNum1(num);
		if (vo == null) {
			System.out.println("없는 번호");
		} else {
			System.out.println(vo);
		}
	}
	
	public ProductVo getByNum(int num) {
		return dao.selectByNum1(num);
	}

	// 이름으로 검색
	public void getProductByName(Scanner sc) {
		System.out.println("=== 제품 이름으로 검색 ===");

		System.out.print("검색할 name:");
		String name = sc.next();

		ProductVo[] res = dao.selectByName(name);
		if (res.length == 0) {
			System.out.println("검색된 이름이 없다");
		} else {
			for (ProductVo vo : res) {
				System.out.println(vo);
			}
		}
	}

	// 수정
	public void editProduct(Scanner sc) {
		System.out.println("=== 제품 수정 ===");

		System.out.print("수정할 num:");
		int num = sc.nextInt();

		ProductVo vo = dao.selectByNum1(num);
		if (vo == null) {
			System.out.println("없는 번호. 수정 취소");
		} else {
			System.out.println("수정 전 데이터");
			System.out.println(vo);
			System.out.print("new name:");
			vo.setName(sc.next());
			System.out.print("new price:");
			vo.setPrice(sc.nextInt());
			System.out.print("new amount:");
			vo.setAmount(sc.nextInt());
		}
	}

	// 삭제
	public void delete(Scanner sc) {
		System.out.println("=== 제품 삭제 ===");

		System.out.print("삭제할 num:");
		int num = sc.nextInt();

		dao.delete(num);
	}

	// 전체출력
	public void printAll() {
		ProductVo[] datas = dao.getDatas();
		for (int i = 0; i < dao.getCnt(); i++) {
			System.out.println(datas[i]);
		}
	}
	
	
}
