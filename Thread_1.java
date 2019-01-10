package studywell;

public class Thread_1 implements Runnable{　//实现Runnable接口
	public void run(){
		for(;;) {
			try {
				Thread.sleep(1000);  //线程休息一秒
				
			} catch (InterruptedException e) {}　//捕获异常
			System.out.println("Hello");
		}
	}
	public static void main(String[] args) {
		Thread_1 t=new Thread_1();　　//创建对象
		Thread thread=new Thread(t);　//创建线程
		thread.start();　　//启动线程
	}
}
