package except_test;
//예외처리! try, catch, finally
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("프로그램 시작");
		String str = null;
		try { //예외 발생코드. try 밖에서 예외 발생하면처리안
			System.out.println(str.charAt(0)); // NullPointerException에러는 catch{}의 ArithmeticException가 아님으로 예외처리안됨 
			                                   //charAt() - String으로 저장된 문자열 중에서 한 글자만 선택해서 char타입으로 변환해주는 녀석
		int a = 3/0; //예외발생. 0으로나눌수 없음 
		   System.out.println(a);
		} catch(ArithmeticException e){ //ArithmeticException 예외종류  catch 가 여러개가 있더라도 첫예외 하나만 실행
			System.out.println(e);
		} catch(NullPointerException e){ //NullPointerException 예외종류 
			System.out.println(e);
		}
		catch(Exception e){ //Exception : 모든 예외가 상속받는 클래스 (다른 예외들을 Exception 으로 업캐스팅해서받으면 됨)
			                //모든것을 다받기 때문에 맨 끝에 위해야함. 위쪽에 놓으면 에러
			System.out.println(e);
		}
		finally {
			System.out.println("종료전 무조건 실행");
		}
		System.out.println("프로그램 종료");
	}
	
}

//예외를 출력하는 다양한 방법 

/*
 * 			System.out.println("==에외 객체 출력 ==");
			System.out.println(e);
			
			System.out.println("==printStackTrace() ==");
			e.printStackTrace();
			
			System.out.println("==getMessage()==");
			System.out.println(e.getMessage());
			
		}
 */
