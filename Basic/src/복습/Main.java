//11월 3일
package 복습;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) { // 객체2개 :수강에 필요한 객체가2개
		// TODO Auto-generated method stub
		//기능구현시 공통된부분을 묶어서 사용하기위해 vo 사용
		//객체에 접근하려면 객체이름
		//메서드를 쓰는이유 :반복적인 기능을 많이 사용할 때 만들어두고 호출해서 사용하기 위해서
		//       코드가 훨씬 간결해짐.
		
		Scanner sc = new Scanner(System.in);
		수강 s1 = new 수강(1, "전산학개론", "아무개", 30, "교학관:101");  // => 값을 할당만해놓고 리턴값은없음 void
		//메서드호출 : 객체이름.메서드이름(파라메터 값); 괄호에 파라메터에 전달할 값을 개수와 타입이맞게 전달
		//메서드호출 : 메서드 작성한 부분으로 점프. 파라메터값 가지고 메서드 수행이후 호출한곳으로 다시 돌아옴.
//		s1.setData(1, "전산학개론", "아무개", 30, "교학관:101"); -> 생성자에서초기화했으니까.
//		s1.code = 1;
//		s1.name = "전산학개론";
//		s1.profName = "아무개";
//		s1.cnt = 30;
//		s1.room = "교학관:101";   
	
		//출력 
		//메서드로 만드려면? 현재멤버변수를 출력만하면 되기때문에 파라메터 필요없음.
		s1.printData();
//		System.out.println("code:"+s1.code);
//		System.out.println("name:"+s1.name);
//		System.out.println("profName:"+s1.profName);
//		System.out.println("cnt:"+s1.cnt);
//		System.out.println("room:"+s1.room);
		
		수강 s2 = new 수강(2, "자바학개론", "아무개2", 20, "공학관:302"); 
		
		s2.printData();
		//s2.proFname = "김유진";
		//private 멤버에 접근하려면 getter, setter가 필요하다.
		//setter : 이름:set변수명 => 파라메터로 멤버변수에 할당할 값을 받아서 멤버변수에 할당.
		
		s2.setProfName("김유진");
//		System.out.println("ProfName:"+s2.setProfName); 
		//profname 이 private멤버라서 클래스밖에서 보이지 않기떄문에 getter필요
		// 멤버변수의 타입과 동일한 get멤버변수명()return 멤버변수}
		s2.getProfName(); //현재 s2.getProfName()->김유진
		//변수에 할당해야함.
		String val = s2.getProfName();
		System.out.println("profName : "+ val);
		
		//메인에서 dao를 사용하려면 객체생성
		수강Dao dao = new 수강Dao();
		//dao에 s1,s2추가하기
		dao.insert(s1); //호출
		dao.insert(s2);
		
		ArrayList<수강> list = dao.selectAll(); //전체검색
		for(수강 s:list) {
			s.printData();
		
		//1. 검색할 수강 번호를 입력받아서 검색하기.(scanner)
		//검색한 결과(수강객체)를 출력하시오. 
		int idx = dao.select(1); //0번째방
		if(idx<0) {
			System.out.println("없는 코드");
		}else {
			System.out.println("===검색====");
		수강 res = dao.selectByIdx(idx); // 방번호로 객체꺼내오기
		res.printData();
		}
		
//		System.out.println("검색할 번호 입력하세요");
//		int i = sc.nextInt();
//		수강 sugang= dao.selectByIdx(i);
//		System.out.println("===========");
//		System.out.println(sugang);
		
		//2. 수정할 수강 번호를 입력받아서 검색하기
		//있으면 새 교수명, 새 강의실 입력받아 검색결과인 vo에담기
		//수정완료 update(방번호, 새 vo )
		//수정할 정보를담은 객체
		수강 edit = new 수강(1, "", "new prof",0, "새강의장" ); // 수정에필요한 정보 코드번호, 교수, 강의실만 입력, 나머지는 안쓸값
		dao.update(edit);
		
		System.out.println("수정 후 전체 데이터");
		list = dao.selectAll();
		for(수강 a : list){
			a.printData();
		}
		
//		System.out.println("수정할 번호 입력하세요");
//		int j = sc.nextInt();
//		수강 sugang2 = dao.selectByIdx(j);
//		if(dao.select(j)!=-1) {
//			System.out.println("새교수명 입력하세요");
//			String profName = sc.nextLine();
//			System.out.println("새강의실 입력하세요");
//			String room = sc.nextLine();
//			sugang2.setProfName(profName);
//			sugang2.setRoom(room);
//		}
//		
		//3. 삭제
		//삭제할 코드번호 입력받아서 delete()호출
		dao.delete(1);
		System.out.println("삭제후 전체 데이터");
		list = dao.selectAll();
		for(수강 a:list) {
			a.printData();
		}
//		int h = sc.nextInt();
//		dao.delete(h); 
		} 
				
	}

}
