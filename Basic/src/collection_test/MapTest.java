package collection_test;

import java.util.HashMap;
import java.util.Iterator;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//맵 객체 생성
		//HashMap<키타입, 값타입>
		HashMap<String, String> map = new HashMap<>();
		
		//put(키,값) 데이터 추가 
		map.put("name","aaa");
		map.put("tel","111");
		map.put("address","대한민국");
		
		//요소 추출 : get(키) ->키이름을 정확히 알아야 추출 
		System.out.println(map.get("name"));
		System.out.println(map.get("tel"));
		System.out.println(map.get("address"));
	
		//키셋  추출
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()) {
			//키와 값 출력 
			String key = iter.next(); //키 값을 하나 꺼내서 변수 key 에 담음
			System.out.println(key + " : " + map.get(key));
		}
		
		//값만 추출 values
		//값 묶음 반환 
		iter = map.values().iterator();
		while(iter.hasNext()) {
			//키와 값 출력 
			String value = iter.next(); 
			System.out.println(value);
		}
		
		
	}

}
