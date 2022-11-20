package collection_test;

import java.util.ArrayList;
import java.util.Iterator;

//ArrayList 끝까지씀!! 열심히하기
public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//생성<타입한정자(general)>  ArrayList<타입값> 이름 = new ArrayList<>();
		ArrayList<String> list = new ArrayList<>();
		
		
		//add() 데이터 끝방에 추가
		list.add("aaa");
		list.add("bbb"); // aaa, bbb
		System.out.println(list);
	
		//add(방번호, data) 지정한 위치에 data 추가. 그뒤로 밀림
		list.add(0,"ccc"); //  ccc, aaa, bbb
		System.out.println(list);
		
		//set(방번호,new data) 지정한 위치에 새로운 data 값 변경
		list.set(0, "abc");
		System.out.println(list);
		
		//get(방번호) 지정한 방 번호 요소 추출
		String s = list.get(1);
		System.out.println(s);
		
		//size() 데이터 개수
		System.out.println("size: "+list.size());
		
		//iterator : 반복자(다음칸 이동하여 요소 하나 추출)
		Iterator<String> iter = list.iterator(); // 리스트 객체에 할당된 반복자를 반
		while(iter.hasNext()) { //hasNext() : 다음이터가 있으면 true,없으면 false
			System.out.println(iter.next()); // next() 다음요소 추출
		}
		
		//루프로 요소 전체를 하나씩 추출
		for(String str:list) {
			System.out.println(str);
		}
		
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		//contains(값) 값이 리스트에 있으면 true, 없으면 false
		if(list.contains("aaa")) {
			//indexOf(값) : 값이 몇번째 방에 있는지 반환. 없으면 -1 반환
			System.out.println(list.indexOf("aaa")+"번째 방에 있음");
		}else {
			System.out.println("없다");
		}
		
		//remove(방번호) 지정한 방번호 위치의 데이터 삭제
		//remove(0);
		String delVal = list.remove(0);
		System.out.println(delVal+"가 삭제됨");
		System.out.println(list);
		
		//remove(값) 값을 찾아서 삭제. 삭제가 정상처리 : true, 아니면 false반환
		boolean flag = list.remove("aaa");
		if(flag) {
		System.out.println("삭제가 완료되었음");
		}else {
			System.out.println("없는 데이터");
		}
		System.out.println(list);
		
		//list.isEmpty() 리스트가 비었으면 true, 아니면 false
		if(list.isEmpty()) {
			System.out.println("리스트 비었음");
		}else {
			list.clear(); //clear 모든 요소 삭제
			System.out.println("모든요소 삭제됨");
			System.out.println(list);
		}
		
	}

}
