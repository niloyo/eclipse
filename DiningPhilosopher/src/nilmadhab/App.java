package nilmadhab;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = null;
		Philosopher[] philosophers = null;
		
		try {
			
			philosophers = new Philosopher[Constants.NUMBER_OF_PHILOSOPHER];
			ChopStick[] chopSticks = new ChopStick[Constants.NUMBER_OF_CHOPSTICK];
			
			for (int i = 0; i < Constants.NUMBER_OF_CHOPSTICK; i++) {
				chopSticks[i] = new ChopStick(i);
			}
			
			executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHER);
			
			for (int i = 0; i < Constants.NUMBER_OF_PHILOSOPHER; i++) {
				philosophers[i] = new Philosopher(i, chopSticks[i], chopSticks[(i+1)%Constants.NUMBER_OF_CHOPSTICK]);
				executorService.execute(philosophers[i]);
			}
			
			Thread.sleep(Constants.SIMULATION_RUNNING_TIME_IN_MILI);
			
			for(Philosopher philosopher: philosophers) {
				philosopher.setFull(true);
			}
			
		}finally {
			executorService.shutdown();
			while(!executorService.isTerminated()) {
				Thread.sleep(1000);
			}
			
			for(Philosopher p : philosophers) {
				System.out.println(p + " eats " + p.getEatingCounter());
			}
		}
		
	}

}
