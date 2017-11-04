import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Worker2 {
	private Lock lock = new ReentrantLock();
	
	private Condition condition = lock.newCondition();
	
	public void producer() throws InterruptedException {
		Thread.sleep(200);
		lock.lock();
		System.out.println("Producer........");
		condition.await();
		System.out.println("Producer again........");
		//lock.unlock();
	}
	
	public void consumer() throws InterruptedException {
		//Thread.sleep(200);
		lock.lock();
		//Thread.sleep(2000);
		System.out.println("Consumer method............");
		condition.signal();
		//lock.unlock();
	}
	
	
}

public class ProducerConsumerUnsingReentrantLock {
	
	private Lock lock = new ReentrantLock();
	
	private Condition condition = lock.newCondition();
	
	
	public static void main(String[] args) throws InterruptedException {
		Worker2 processor = new Worker2();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.producer();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.consumer();
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
