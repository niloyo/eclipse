
public class FirstWay {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		FirstTask first = new FirstTask("thread1");
		first.start();
		
		FirstTask2 first1 = new FirstTask2("thread2");
		first1.start();
		
		first.join();
		
		//first1.join();
		
		System.out.println("main thread finished");
	}

}


class FirstTask extends Thread{
	
	private String TAG;
	
	public FirstTask(String TAG) {
		// TODO Auto-generated constructor stub
		this.TAG = TAG;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println("Tick Tick " + i + " " + TAG );
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class FirstTask2 extends Thread{
	
	private String TAG;
	
	public FirstTask2(String TAG) {
		// TODO Auto-generated constructor stub
		this.TAG = TAG;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Tick Tick " + i + " " + TAG );
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
