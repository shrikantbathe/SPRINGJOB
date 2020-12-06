package PrintEvenOddTester;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenLock {

	public static void main(String[] args) {
		
		OddEven OddEven1 = new OddEven();
		
		new Thread (()-> {
			try {
				OddEven1.printOdd();
			} catch (Exception e) {
			}
			
		}).start();
		new Thread (()-> {
			try {
				OddEven1.printEven();
			} catch (Exception e) {
			}
			
		}).start();
		
	}

}


class OddEven {
	
	Lock lock  =  new ReentrantLock(); 
	Condition oddCond = lock.newCondition();
	Condition evenCond = lock.newCondition();
	boolean isOdd = false;
	int min = 1;
	int max = 20;
	
	void printOdd() throws InterruptedException {
		lock.lock();
		while(min < max) {
			while(isOdd) {
				oddCond.await();
			}
			System.out.println("--> "+min);
			min++;
			evenCond.signal();
		}
		lock.unlock();
	}
	
	void printEven() throws InterruptedException {
		lock.lock();
		while(min < max) {
			while(!isOdd) {
				evenCond.await();
			}
			System.out.println("--> "+min);
			min++;
			oddCond.signal();
		}
		lock.unlock();
	}
	
	
}

