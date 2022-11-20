package reservation;

public class ReservationService {

	ReservationDao dao = new ReservationDao();

	public ReservationService() {
		dao = new ReservationDao();
	}

	// 티켓가격
	public int ticketPrice(int stGubun) {
		int tp = 10000;
		int seat_S = tp * 5;
		int seat_A = tp * 3;
		int seat_B = tp * 2;
		int seat_C = tp;
		int price = 0;
		if (stGubun == 1) {
			System.out.println("S석, 가격:" + seat_S + "원");
			price = seat_S;
		} else if (stGubun == 2) {
			System.out.println("A석, 가격:" + seat_A + "원");
			price = seat_A;
		} else if (stGubun == 3) {
			System.out.println("B석, 가격:" + seat_B + "원");
			price = seat_B;
		} else if (stGubun == 4) {
			System.out.println("C석, 가격:" + seat_C + "원");
			price = seat_C;
		} else {
			System.out.println("해당하지 않는 좌석입니다. 선택취소");

		}
		return price;

	}

}