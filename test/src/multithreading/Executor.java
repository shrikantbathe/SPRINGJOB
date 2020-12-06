package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Executor {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executor = Executors.newFixedThreadPool(6);
		
		List<Future<String>> futList = null;// new LinkedList<Future<String>>(); 
		
		List<Callable<String>> workerList = new ArrayList<>();
		
		for (int i = 0; i < 6; i++) {
			Callable<String> worker = new WorkerThread("" + i);
			workerList.add(worker);
			//futList.add(executor.submit(worker));
		}
		
		futList  = executor.invokeAll(workerList);
		
		System.out.println("cccc: "+futList.size());
		
		
		/*for (int i = 0; i < 6; i++) {
			Callable<String> worker = new WorkerThread("" + i);
			futList.add(executor.submit(worker));
		}
		*/
		/*for (int i = 0; i < futList.size(); i++) {
			  Future<String> completed = futList.get(i);
				  try {
					completed.get();
				} catch (Exception e) {
				  	futList.forEach(f -> f.cancel(true));
				  	executor.shutdownNow();
					e.printStackTrace();
				}
			}
		*/
		  	executor.shutdown();
		  	while(!executor.isTerminated()){}
		System.out.println("Finished all threads");
	}

}

class WorkerThread implements Callable<String> {
	private String command;
	public WorkerThread(String s) {
		this.command = s;
	}

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName() + " Start Command = " + command);
		processCommand(command);
		System.out.println(Thread.currentThread().getName() + " End.");
		return null;
	}
	

	private void processCommand(String command) {
		try {
			Thread.sleep(5000);
			if (command.equals("2"))
				throw new RuntimeException();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
