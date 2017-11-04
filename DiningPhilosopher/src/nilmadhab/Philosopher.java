package nilmadhab;

import java.util.Random;

public class Philosopher implements Runnable {
	
	private int id;
	private ChopStick leftChopStick;
	private ChopStick rightChopStick;
	
	private volatile boolean isFull = false;
	
	public boolean isFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}

	public int getEatingCounter() {
		return eatingCounter;
	}

	public void setEatingCounter(int eatingCounter) {
		this.eatingCounter = eatingCounter;
	}

	private Random random;
	
	private int eatingCounter;

	public Philosopher(int id, ChopStick leftChopStick, ChopStick rightChopStick) {
		super();
		this.id = id;
		this.leftChopStick = leftChopStick;
		this.rightChopStick = rightChopStick;
		random = new Random();
	}

	@Override
	public void run() {
		while(!isFull) {
			try {
				think();
				if(leftChopStick.pickUp(this, State.LEFT)) {
					if(rightChopStick.pickUp(this, State.RIGHT)) {
						eat();
						rightChopStick.putDown(this, State.RIGHT);
						
					}
					leftChopStick.putDown(this, State.LEFT);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private void eat() throws InterruptedException {
		System.out.println(this +  " is eating ....");
		eatingCounter ++;
		Thread.sleep(random.nextInt(1000));
		
	}

	private void think()  throws InterruptedException{
		System.out.println(this + " is thinking ");
		Thread.sleep(random.nextInt(1000));
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Philosopher " + id;
	}
	
	
	
	

}
