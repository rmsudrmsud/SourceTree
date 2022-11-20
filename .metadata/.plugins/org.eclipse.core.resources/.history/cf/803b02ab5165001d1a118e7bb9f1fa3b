package start;

import java.util.Scanner;

import master.MasterService;
import member.MemberService;
import post.PostService;
import reservation.ReservationSystem;

public class Menu {

   MemberService meService;
   MasterService maService;
   PostService pService;

   public Menu() {
      meService = new MemberService();
      maService = new MasterService();
      pService = new PostService();
   }

   // 첫 화면
   public void run(Scanner sc) {
      System.out.println("=========================");
      System.out.println("스포츠 경기 티켓 예매 사이트");
      System.out.println("=========================");
      System.out.println("(1) 로그인");
      System.out.println("(2) 회원가입 ");
      System.out.println("=========================");
      System.out.print(": ");
      int num = sc.nextInt();

      if (num == 1) {
         meService.login(sc);

         if (meService.memType == 0) {
            memberRun(sc); // 회원 로그인 화면
         } else if (meService.memType == 1) {
            masterRun(sc); // 관리자 로그인 화면
         }
      } else if (num == 2) {
         meService.join(sc);
         run(sc);
      }
   }// run()

   // 회원 로그인 화면
   public void memberRun(Scanner sc) {
      boolean flag = true;
      while (flag) {
         System.out.println();
         System.out.println("(1) 스포츠 경기 예매 ");
         System.out.println("(2) 매점  ");
         System.out.println("(3) 회원정보  ");
         System.out.println("(4) 게시판  ");
         System.out.println("(5) 로그아웃 ");
         System.out.println("=========================");
         System.out.print("> ");
         int num = sc.nextInt();
         switch (num) {
         case 1:
            sportsRes(sc);
            break;
         case 2:
            break;
         case 3:
            memberInfo(sc);
            break;
         case 4:
        	 	post(sc);
            break;
         case 5:
            meService.logout(sc);
            run(sc);
         }
      } // while()
   }// memberRun()

   // 스포츠 경기 예매
   public void sportsRes(Scanner sc) {
      ReservationSystem rs = new ReservationSystem();
      boolean flag = true;

      while (flag) { // - 예약 시스템의 메뉴는 "예약", "조회", "취소", "끝내기"가 있다.
                  // - 없는 이름, 없는 번호, 없는 메뉴, 잘못된 취소 등에 대해서 오류 메시지를 출력하고 사용자가 다시시도하도록 한다.
         System.out.println();
         System.out.println("=============스포츠티켓 예약시스템입니다.==============");
         System.out.println("1.예약 2.끝내기");

         int service_num = sc.nextInt();
         switch (service_num) {
         case 1:
            rs.bookSeat(sc);
            break;

         case 2: // 끝내기
            System.out.println("시스템이 종료됩니다.");
            flag = false;
            break;
         default:
            System.out.println("잘못 누르셨습니다. 올바른 번호를 입력해주세요.");
         }
      }

   }// sportsRes()

   // 회원 정보
   public void memberInfo(Scanner sc) {
      boolean flag = true;
      while (flag) {
         System.out.println();
         System.out.println("(1) 내 정보  ");
         System.out.println("(2) 예매 경기 ");
         System.out.println("(3) 결제 정보 확인 ");
         System.out.println("(4) 작성한 게시글 ");
         System.out.println("=========================");
         System.out.print("> ");
         int num = sc.nextInt();
         switch (num) {
         case 1:
            System.out.println();
            System.out.println("(1) 내 정보 확인  ");
            System.out.println("(2) 내 정보 수정 ");
            System.out.println("(3) 회원 탈퇴 ");
            System.out.println("=========================");
            System.out.print("> ");
            num = sc.nextInt();
            switch (num) {
            case 1:
               meService.checkInfo();
               break;
            case 2:
               meService.editInfo(sc);
               break;
            case 3:
               meService.out(sc);
               System.out.println();
               break;
            }
            memberRun(sc);

         case 2:
            System.out.println();
            System.out.println("(1) 예매경기 확인 ");
            System.out.println("(2) 예매경기 취소  ");
            System.out.println("=========================");
            System.out.print("> ");
            num = sc.nextInt();
            switch (num) {
            case 1:
               meService.checkRes();
               System.out.println();
               break;
            case 2:
               meService.deleteRes(sc);
               System.out.println();
               break;
            }
            memberRun(sc);

         case 3:
//            meService.checkStore();
            System.out.println();
            memberRun(sc);
            break;

         case 4:
            System.out.println();
            System.out.println("(1) 게시글 전체목록 확인 ");
            System.out.println("(2) 작성한 게시글 수정  ");
            System.out.println("(3) 작성한 게시글 삭제 ");
            System.out.println("=========================");
            System.out.print("> ");
            num = sc.nextInt();
            switch (num) {
            case 1:
               meService.checkPost();
               System.out.println();
               break;
            case 2:
               meService.updatePost();
               break;
            case 3:
               meService.deletePost();
               break;
            }
            memberRun(sc);
         }
      } // while()
   }// memberInfo()
   
   
   //게시판 
   public void post(Scanner sc) {
		Boolean flag = true;
		while (flag) {
			int i = 0;
			System.out.println("1: 게시글 목록 조회 \n2: 글 상세 확인 \n3: 글 작성 \n4: 글 수정 \n5: 글 삭제 \n6: 종료 ");
			i = sc.nextInt();
			switch (i) {
			case 1:
				pService.getAll();
				break;
			case 2:
				pService.getPostDetail();
				break;
			case 3:
				pService.addPost();
				break;
			case 4:
				pService.editPost();
				break;
			case 5:
				pService.deletePost();
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				flag = false;
				break;

			}
		}
	}

   // 관리자 로그인 화면
   public void masterRun(Scanner sc) {
      boolean flag = true;
      while (flag) {
         System.out.println();
         System.out.println("(1) 회원 관리 ");
         System.out.println("(2) 블랙리스트 관리 ");
         System.out.println("(3) 경기 관리 ");
         System.out.println("(4) 게시판  관리 ");
         System.out.println("(5) 결제 관리 ");
         System.out.println("=========================");
         System.out.print("> ");
         int num = sc.nextInt();

         switch (num) {
         case 1:
            System.out.println();
            System.out.println("(1) 전체 회원 정보 확인  ");
            System.out.println("(2) 회원 정보 검색 ");
            System.out.println("(3) 회원 정보 삭제 ");
            System.out.println("=========================");
            System.out.print("> ");
            num = sc.nextInt();

            switch (num) {
            case 1:
               maService.getAll();
               break;
            case 2:
               maService.printById(sc);
               break;
            case 3:
               maService.deleteMemid(sc);
               break;
            }
            masterRun(sc);

         case 2:
            System.out.println();
            System.out.println("(1) 블랙리스트 확인 ");
            System.out.println("(2) 블랙리스트 추가 ");
            System.out.println("(3) 블랙리스트 삭제 ");
            System.out.println("=========================");
            System.out.print("> ");
            num = sc.nextInt();

            switch (num) {
            case 1:
               maService.printBlack();
               break;
            case 2:
               maService.insertBlack(sc);
               break;
            case 3:
               maService.deleteBlack(sc);
               break;
            }
            masterRun(sc);

         case 3:
            System.out.println();
            System.out.println("(1) 경기 정보 추가  ");
            System.out.println("(2) 경기 정보 수정 ");
            System.out.println("(3) 경기 정보 삭제 ");
            System.out.println("=========================");
            System.out.print("> ");
            num = sc.nextInt();

            switch (num) {
            case 1:
               maService.insertSports(sc);
               break;
            case 2:
               maService.editSports(sc);
               break;
            case 3:
               maService.deleteSports(sc);
               break;
            }
            masterRun(sc);

         case 4:
            System.out.println();
            System.out.println("(1) 게시글 검색 ");
            System.out.println("(2) 게시글 삭제");
            System.out.println("=========================");
            System.out.print("> ");
            num = sc.nextInt();

            switch (num) {
            case 1:
               maService.selectPost(sc);
               break;
            case 2:
               maService.deletePost(sc);
               break;
            }
            masterRun(sc);

         case 5:
            System.out.println();
            System.out.println("(1) 경기별 회원 결제여부 확인  ");
            System.out.println("(2) 경기별 미결제 회원에게 알림 ");
            System.out.println("=========================");
            System.out.print("> ");
            num = sc.nextInt();

            switch (num) {
            case 1:
               maService.payment();
               break;
            case 2:
               break;
            }
            masterRun(sc);
            break;
         }
      } // while()
   }// masterRun()

}// Menu