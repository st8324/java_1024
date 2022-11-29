package day27;

public class ThreadEx01 {

	public static void main(String[] args) {
		NewThread t = new NewThread();
		t.start();
		Thread thisThread = Thread.currentThread();
		for(int i = 0; i<20; i++) {
			System.out.println(thisThread.getName()+" 쓰레드 실행");
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class NewThread extends Thread {
	@Override
	public void run() {
		for(int i = 0; i<10; i++) {
			System.out.println(this.getName()+" 쓰레드 실행");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
