package multithreading;


public class ExceptionHandling {

	public static void main(String[] args) {
		
		Thread.setDefaultUncaughtExceptionHandler( new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				
			}
			
		} );
		
	 	new Thread(new MyRunnable(1)).start();
	 	new Thread(new MyRunnable(2)).start();
	 	new Thread(new MyRunnable(3)).start();
	 	new Thread(new MyRunnable(4)).start();
	 	new Thread(new MyRunnable(5)).start();
		
		System.out.println("Main Complete");
		
		
		
		

	}
}	
	
 
class MyRunnable implements Runnable {

	MyExceptionHandler myExceptionHandler = new MyExceptionHandler();
	int t;
	
	MyRunnable(int t){
		this.t = t;
	}
	
	@Override
	public void run() {
		Thread.setDefaultUncaughtExceptionHandler(myExceptionHandler);
		 try {
			 System.out.println("Count: " + t);Thread.sleep(1000);
			 if(t == 5){
				 throw new RuntimeException(""+t);
			 }
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}

class MyExceptionHandler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		
		System.out.println("In Default handler: "+ ((Exception)e).getMessage());
		
	}
	
}




