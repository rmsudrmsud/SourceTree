package except_test;
class MyNumException extends Exception{
	public MyNumException() {}//디폴트 생성자
	//메시지를 받는 생성자
	public MyNumException(String msg) {
		super(msg);
	}
}

class MyNum{
	//num은 5보다크면안된다는 규칙이있다면? 
	private int num;
	
	public void setNum(int num) throws Exception{
		if(num>5) {
			//예외 발생. 예외 객체 생성자에 String을 할당하면 예외 메시지로 설정.
			throw new Exception("num은 5를 넘을 수 없음"); 
		}else {
			this.num = num;
		}
	}
	
	public int getNum() {
		return num;
	}
}


public class 예외발생 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	MyNum n = new MyNum();
	try {
		n.setNum(14);
	} catch (MyNumException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
	System.out.println("num:" + n.getNum());

	}

}
