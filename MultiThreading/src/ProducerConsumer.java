import java.util.ArrayList;
import java.util.List;

class Processor2{
	
	List<Integer> list = new ArrayList<Integer>();
	
	private final int LIMIT = 10;
	
	private final int BOTTOM = 0 ;
	
	private static final Object Lock = new Object();

	public void produce() throws InterruptedException {

		synchronized (Lock) {
			
			while(true) {
				if(list.size() == LIMIT) {
					System.out.println("WAITING FOR removing items from thread list... ");
					Lock.wait();
				}else {
					list.add(3);
					//Thread.sleep(1000);
					System.out.println(list.size() + "after  produced");
					Lock.notify();
				}
				
				Thread.sleep(1000);
				
			}
			
		}
	}

	public void consume() throws InterruptedException
	{
		
		synchronized (Lock) {
			while(true) {
				if(list.size() == BOTTOM) {
					System.out.println("waitinf for producer to produce ");
					Lock.wait();
				}else {
					list.remove(0);
					//Thread.sleep(1000);
					System.out.println(list.size() + "after  consumed");
					Lock.notify();
				}
				
				Thread.sleep(1000);
			}
			
		}
	}


}

public class ProducerConsumer {
	
	


	public static void main(String[] args) throws InterruptedException {
		Processor2 processor = new Processor2();

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
