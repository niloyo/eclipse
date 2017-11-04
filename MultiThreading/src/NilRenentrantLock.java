
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NilRenentrantLock {

	private static int counter = 0;
	private final static Lock lock = new ReentrantLock();
	
	public static void increment() {
		lock.lock();
		for (int i = 0; i < 10000; i++) {
			counter +=1;
		}
		
		lock.unlock();
		
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				increment();
			}
		});
		
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				increment();
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();
		
		System.out.println(" current value of counter " + counter);
	}




}
