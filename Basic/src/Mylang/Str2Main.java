package Mylang;

public class Str2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String 조작 클래스
		//문자열 편집을 빠르게 처리한다.(내부에 버퍼를 가지고있음)
		
		//스트링 빌더 객체 생성
		StringBuilder sb = new StringBuilder();
		
		//문자열 덧붙이는 함수
		sb.append("aaa");
		sb.append("bbb");
		sb.append("ccc");
		System.out.println(sb);//aaabbbccc
		sb.insert(2, "sdf"); // insert 2번위치에 끼워넣기 aa sdf abbbccc
		System.out.println(sb);
		
		// 문자열대체 9~11위치의 값 kkk로 수정
		sb.replace(9, 12, "kkk");
		System.out.println(sb);
		
		// 6~8위치의 문자 삭제
		sb.delete(6, 9);
		System.out.println(sb);
	}

}
