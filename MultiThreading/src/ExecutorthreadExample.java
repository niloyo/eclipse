import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker3 implements Runnable{
	public String name;
	 public Worker3( String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	@Override
	public void run() {
		Random random = new Random();
		int num = random.nextInt(10);
		for (int i = 0; i < num; i++) {
			System.out.println(i + " done out of "+ num + " for worker" + name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(name + " finished executing ****************************");
		
	}
	
}

public class ExecutorthreadExample {
	
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 5; i++) {
			executorService.submit(new Worker3(""+i));
		}
		
		executorService.shutdown();
	}

}
