
public class Syncronized2 {
	
	private static int count1 = 0;
	private static int count2 = 0;
	
	static Object O1 = new Object();
	static Object O2 = new Object();
	
	
	private  static void add() {
		
		synchronized (O1) {
			count1++;
		}
		

	}
	
	private  static void add2() {
		synchronized (O2) {
			count2++;
		}
	}
	
	private static void compute() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 1000	; i++) {
			add();
			add2();
		}
		

	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						compute();
						
					}
				});
				
				Thread t2 = new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						

						compute();
						
						
					}
				});
				t1.start();
				t2.start();
				t1.join();
				t2.join();
				
				System.out.println(count1);
				System.out.println(count2);
				
				
		
	}

}
