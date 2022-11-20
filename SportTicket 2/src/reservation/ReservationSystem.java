package reservation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import member.MemberService;
import sports.SportsVo;

public class ReservationSystem {

	int stGubun = 0; // 좌석타입
	int stNum = 0; //// 좌석번호
	String num = " "; // 좌석번호(타입-번호)

	public ReservationSystem() {
		// TODO Auto-generated constructor stub
	}

	Scanner sc = new Scanner(System.in);

	String[][] seats = new String[4][10]; // 좌석구분 - S A B C각 10석씩.
	String[] list = { "S", "A", "B", "C" };
	ReservationDao dao = new ReservationDao();
	ReservationService service = new ReservationService();

	public void bookSeat(Scanner sc) { // 좌석예약
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 10; j++) {
				seats[i][j] = "__";
			}
		}
		// 예약 - 예약은 한 자리만 가능하고, 좌석 타입, 예약자 이름, 좌석 번호를 순서대로 입력받아 예약한다.
		// - 좌석은 S석,A석,B석,C석으로나뉘며,각각 10개의 좌석이 있다.

		System.out.println("경기종목을 선택해주세요");
		System.out.print("1.축구 2.야구");
		int n = sc.nextInt();
		System.out.println("===경기정보가 출력됩니다===");

		if (n == 1) {
			ArrayList<SportsVo> list = dao.printSoccer();
			for (SportsVo vo : list) {
				System.out.println(vo);
			}
		} else if (n == 2) {
			ArrayList<SportsVo> list = dao.printBasketball();
			for (SportsVo vo : list) {
				System.out.println(vo);
			}
		}

		int sport_seq;
		int stGubun;
		int stNum;
		
		System.out.print("원하시는 경기를 선택해주세요");
		sport_seq = sc.nextInt();
		System.out.println("원하시는 좌석등급을 선택하세요. 1.S석 2.A석 3.B석 4.C석 (숫자로 입력해주세요)");
		System.out.print("좌석등급 :");
		stGubun = sc.nextInt();
		
		int price = service.ticketPrice(stGubun);
		
		String num=" ";
		boolean flag= true;

		while (flag) {

			System.out.println("원하시는 좌석번호을 선택하세요. 1~10번");
			System.out.print("좌석번호 :");
			stNum = sc.nextInt();

			if (stNum > 10) {
				System.out.println("잘못된 좌석번호 입니다. 다시 입력해주세요.");
				stNum = sc.nextInt();
			} else if (!(dao.selectAll(stGubun + "-" + stNum ,sport_seq).isEmpty())) {
				System.out.println("이미 예매된 좌석입니다. 다른 좌석을 선택해주세요");
				continue;
			} else  {
				System.out.println("예약하신 좌석번호는 " + stGubun + "-" + stNum + "입니다");
				num = stGubun + "-" + stNum;
				flag=false;
			}
			
		}//while()
		System.out.println(num);

		System.out.println();
		System.out.print("0. 결제취소, 1. 결제하기  ");

		int payment = sc.nextInt();
		String dateStr = "2021년 06월 19일";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일");
		java.sql.Date d = java.sql.Date.valueOf("2012-03-15");

		if (payment == 1) {
			dao.insert(new ReservationVo(0, MemberService.loginId, sport_seq, num, payment, price, d));
			System.out.println("결제가 완료되었습니다");

		} else if (payment == 0) {
			System.out.println("결제를 취소하셨습니다");

		} else if (payment > 1 || payment < 0) {
			System.out.println("잘못된 번호입니다.");

		}
	}

	

}