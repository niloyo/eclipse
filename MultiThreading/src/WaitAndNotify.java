

class Processor{
	
	public void produce() throws InterruptedException {
		
		synchronized (this) {
			System.out.println("we are in producer method ");
			wait();
			System.out.println("again producer method ");
		}
	}
	
	public void consume() throws InterruptedException
	{
		Thread.sleep(1000);
		synchronized (this) {
			System.out.println("we are in consumer method ");
			notify();
		}
	}
	
	
}

public class WaitAndNotify {
	
	public static void main(String[] args)  throws InterruptedException{
		Processor processor = new Processor();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}

}
