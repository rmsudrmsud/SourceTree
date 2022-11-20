//11월 4일
package Book;

import java.util.ArrayList;
import java.util.Scanner;

import addr.Person;
import 복습.수강;

public class bookDao {
	private ArrayList<book> list;
	
	//도서등록
	public bookDao() {
		list = new ArrayList<>();
	}
	
	public void insert(book b) {
		list.add(b);
	}
	
	//번호로 검색해서 방번호 리턴
	//select()
	public int select(int num) {
		int i;
		for(i=0; i<list.size(); i++) { //size: arraylist에저장된 데이터의 개수니까 size까지 루프
			book b = list.get(i); //i번째 book객체꺼냄
			if(b.getNum()==num) { // 꺼낸 객체의 getnum과 파라메터 num이같은가 검색
				return i;
			}
		}
		return -1;	
	}
	
	//방번호 위치에있는 book개체 반환
	public book selectByIdx(int idx) { //book개체를 받을거니까 book 타입. 
		return list.get(idx);
	}
	
	//제목으로 검색하는 메서드. selectByTitle
	//똑같은단어 여러개를 반환할수도 있기때문에 ArrayList<book> 에담
	public ArrayList<book> selectByTitle(String title){
		ArrayList<book> aaa = new ArrayList<book>();
		for (book p : list) {
//			if (p.getTitle().equals(aaa)) {
//			return aaa;
			if (p.getTitle().contains(title)) { //contains() 는 특정 문자열을 포함했는지 확인하는 기능
				aaa.add(p);
			}
		}
		return aaa;
		
	}
	//수정 book 객체에 수정할 책의 번호, 새분류/새출판사를 담아서 파람으로받음
	// (리턴값 없음) void update(Book b){}
	public void update(book b) {
		int idx = select(b.getNum());
		if(idx<0) {
			System.out.println("없는 책번호");
		}else {
			book old = selectByIdx(idx);
			old.setType(b.getType());
			old.setCompany(b.getCompany());
		}
	}
	
	//삭제 : 파람으로 삭제할 책 번호 받음.
	//책 번호로 검색해서 삭제완료. 반환값 x.
	//public void delete(int num){}
	public void delete(int num) {
		int idx = select(num);
		if(idx<0) {
			System.out.println("없는 책번호");
		}else {
			list.remove(idx);
		}
	}
	
	//전체검색 : list 전체 반환
	//ArrayList<book> .selectAll(){}
	public ArrayList<book> selectAll() {
		return list;
	}
}
