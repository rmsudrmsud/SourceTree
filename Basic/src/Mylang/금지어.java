//금지어 배열 : ["개나리", "시베리안 허스키", "십장생" ...]
//
//키보드로 한글 텍스트 무한대 입력 . 
///stop 입력시 한글입력 중단
//
//금지어 입력시 금지어를 "삐리리" 로 변환

package Mylang;

import java.util.Scanner;

public class 금지어 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] words = { "개나리", "시베리안 허스키", "십장생", "진달래" };
		StringBuilder sb = new StringBuilder();
		while (true) {
			System.out.println("내용입력. 멈추려면 /stop");
			String buf = sc.nextLine();
			if (buf.startsWith("/stop")) {
				break;
			}
			sb.append(buf + "\n");
		}
		
		//StringBuilder를 String으로 변환
		String content = sb.toString();
		System.out.println("원본내용");
		System.out.println(content);
		
		for (String w : words) {
			if (content.contains(w)) {
				//System.out.println(w);
				content = content.replaceAll(w, "삐리리");
			}
		}
		
		System.out.println("필터링 후 내용");
		System.out.println(content);
	}

}
