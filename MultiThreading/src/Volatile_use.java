
public class Volatile_use {
	
	public static void main(String[] args) {
		Worker worker = new Worker();
		
		Thread t1 = new Thread(worker);
		
		
		t1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		worker.setTerminated(true);
		
		
	}

}


class Worker implements Runnable {
	private volatile boolean isTerminated = false;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!isTerminated) {
			System.out.println("Hello from worker class ");
			
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	public boolean isTerminated() {
		return isTerminated;
	}
	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}
}
