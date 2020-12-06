package corejava;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Example {

	private static class Task implements Runnable {

		private CyclicBarrier barrier;
		private CyclicBarrier barrier2;
		public Task(CyclicBarrier barrier,CyclicBarrier barrier2) {
			this.barrier = barrier;
			this.barrier2 = barrier2;
		}

		@Override
		public void run() {
			try {
				System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
				
				barrier.await();
				
				System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
				
				barrier2.await();
				
				System.out.println(Thread.currentThread().getName() + "xxxxxxxxxxxxx");
				
				
			} catch (InterruptedException ex) {

			} catch (BrokenBarrierException ex) {

			}
		}
	}

	public static void main(String args[]) {

		final CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
			@Override
			public void run() {
				System.out.println("All parties are arrived "
						+ "at barrier, lets play");
			}
		});
		
		final CyclicBarrier cb2 = new CyclicBarrier(3, new Runnable() {
			@Override
			public void run() {
				System.out.println("22222222222222");
			}
		});
		

		Thread t1 = new Thread(new Task(cb,cb2), "Thread 1");
		Thread t2 = new Thread(new Task(cb,cb2), "Thread 2");
		Thread t3 = new Thread(new Task(cb,cb2), "Thread 3");

		t1.start();
		t2.start();
		t3.start();

	}
}
