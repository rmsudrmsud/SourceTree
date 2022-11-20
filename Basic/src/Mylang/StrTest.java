package Mylang;

public class StrTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "aaa";
		String b = new String("bbb");
		String c = new String(a);
		a+="abc"; // a에 "abc" 덧붙임
		String d = "aaa";
		String e = "aaa";
		
		System.out.println("e==d::"+(e==d)); //문자열 == 하면참조값만 비교.
		System.out.println(c);
		System.out.println("d==c:"+(d==c));
		
		String z = "abcdefghijklmnopde";
		System.out.println(z.charAt(3)); // z의 지정한 위치의문자 하나 반환
		System.out.println(z.concat("가나다"));//두 문자열 결합하여 반환
		System.out.println(z.contains("fg"));//파라메터 값을 포함하면 true 아니면 false
		System.out.println(z.indexOf("de"));//z에서 앞에서부터 처음만나는 ("")의 위치가 어디인가
		System.out.println(z.lastIndexOf("de"));//뒤에서부터 de의위치가 어디인가
		System.out.println(z.equals(a));//두 문자열 같으면 true, 다르면 false
		System.out.println(z.startsWith("ab"));//문자열이 파람으로 시작하면 true,아니면 false
		System.out.println(z.startsWith("zy"));
		System.out.println(z.endsWith("pde"));//문자열이 파람으로 끝나면 true,아니면 false
		
	}

}