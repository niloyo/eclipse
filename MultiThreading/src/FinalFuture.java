import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Processor4 implements Callable<String>{
	
	private int id;

	public Processor4(int id) {
		super();
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return "Id = " + id;
	}
	
	
}

public class FinalFuture {
	
	public static void main(String[] args) {
		ExecutorService executorService =  Executors.newFixedThreadPool(2);
		
		List < Future <String>> list = new ArrayList<>();
		
		for(int i = 0 ; i < 50 ; i++) {
			Future<String> future = executorService.submit(new Processor4(i+1));
			list.add(future);
		}
		for(Future<String> future : list) {
			try {
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		executorService.shutdown();
	}

}
