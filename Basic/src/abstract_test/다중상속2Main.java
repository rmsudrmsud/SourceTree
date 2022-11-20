package abstract_test;

import java.awt.Frame;

class Test extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		int i;
		for (i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(100); //스레드 0.1초동안 재우기
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class Test2 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		char i;
		for (i = 'a'; i < 'k'; i++) {
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class MyTest extends Frame implements Runnable{//Frame ui에서 윈도우화면창 만드는것
	//Runnalbe 스레드 상속을 못받을 때 대신받아주는 인터페이스

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i;
		for(i=1; i<=10; i++) {
			this.setTitle("my frame:"+i); //윈도우창에 제목을 출력
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	} 
	
}

public class 다중상속2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTest mt = new MyTest();
		mt.setSize(300,200);//frame 클래스에서 제공해주는 윈도우창 크기조절메서드(가로, 세로)
		mt.setVisible(true);//setVisible 화면에 보이게 설정할것이냐 true of false
		Thread th = new Thread(mt); //쓰레드로 생성
		th.start(); //쓰레드 실행
		
//		Test t = new Test();
//		Test2 t2 = new Test2();
//		t.start();
//		t2.start();
	}

}
