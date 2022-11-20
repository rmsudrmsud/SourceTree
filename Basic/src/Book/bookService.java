package Book;

import java.util.ArrayList;
import java.util.Scanner;
//도서관리프로그램
//
//도서(번호(중복x), 제목, 분류, 글쓴이, 출판사)
//
//1. 도서등록
//2. 번호로 검색- 한개
//3. 도서명으로 검색 (검색단어 포함) 여러개
//4. 수정- 번호로 찾아서 분류/출판사 수정
//5. 삭제 (번호로)
//6. 전체 도서 출력
//7. 종료
public class bookService {
	Scanner sc = new Scanner(System.in);
	bookDao dao = new bookDao();
	//도서등록
	public void add(Scanner sc) {
		System.out.println("도서등록");
		System.out.println("num:");
		int num= sc.nextInt();
		System.out.println("title:");
		String title= sc.next();
		System.out.println("writer:");
		String writer= sc.next();
		System.out.println("type:");
		String type= sc.next();
		System.out.println("company:");
		String company = sc.next();
		
		book b = new book(num, title, writer,type, company);
		dao.insert(b);
		}
	
	// 번호로 검색
	public void printNum(Scanner sc) {
		
	    System.out.println("번호로 검색");
	    System.out.println("검색할 번호:");
	    int num=sc.nextInt();
	    int idx = sc.nextInt();
	    if(idx<0) {
	    	System.out.println("없는번호");
	    }else {
	    book b = dao.selectByIdx(idx);
	    }
	    dao.select(num);	    
	}

	//도서명으로 검색
	public void printName(Scanner sc) {
		System.out.println("도서명으로 검색");
		System.out.println("검색할 도서명:");
		String name=sc.next();
		ArrayList<book> a = dao.selectByTitle(name);
		if(a==null) {
			System.out.println("없는 도서");
		}else {
			dao.selectByTitle(name);
			System.out.println(a);
		}
	}
	
	//수정- 번호로 찾아서 분류/출판사 수정
		public void edit(Scanner sc) {
			System.out.println("수정");
			System.out.println("수정할 번호:");
			int num = sc.nextInt();
			int b = dao.select(num);
			
			
		}
	}

