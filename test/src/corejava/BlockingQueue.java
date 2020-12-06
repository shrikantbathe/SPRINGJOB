package corejava;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue<T> {

}

class BlockingQueue1<T> {

	private List<T> queue = new LinkedList<>();
	private int limit = 10;

	public BlockingQueue1(int limit) {
		this.limit = limit;
	}

	public synchronized void enqueue(T t) throws InterruptedException {
		while (this.queue.size() == this.limit) {
			wait();
		}
		if (this.queue.size() == 0) {
			notifyAll();
		}
		this.queue.add(t);
	}

	public synchronized T dequeue() throws InterruptedException {
		while (this.queue.size() == 0) {
			wait();
		}
		if (this.queue.size() == this.limit) {
			notifyAll();
		}

		return this.queue.remove(0);
	}

}