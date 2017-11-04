
public class SynchronizedExample {
	
	
	private volatile static int counter = 0;
	
	public synchronized static void increase() {
		counter +=1;
	}
	
	public static void process() throws InterruptedException {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				for (int i = 0; i < 10000; i++) {
					increase();
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				for (int i = 0; i < 10000; i++) {
					increase();
				}
				
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		process();
		System.out.println("" + counter);
	}

}
