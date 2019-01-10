package studywell;

public class Thread_1 implements Runnable{
	public void run(){
		for(;;) {
			try {
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {}
			System.out.println("Hello");
		}
	}
	public static void main(String[] args) {
		Thread_1 t=new Thread_1();
		Thread thread=new Thread(t);
		thread.start();
	}
}
