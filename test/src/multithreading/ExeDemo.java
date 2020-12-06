package multithreading;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExeDemo extends ThreadPoolExecutor {
	
    public ExeDemo() {
        super(  1, // core threads
                1, // max threads
                1, // timeout
                TimeUnit.MINUTES, // timeout units
                new LinkedBlockingQueue<Runnable>() // work queue
        );
    }

    protected void afterExecute(Runnable r, Throwable t) {
    	super.afterExecute(r, t);
    if (t == null && r instanceof Future<?>) {
        try {
            Future<?> future = (Future<?>) r;
            if (future.isDone()) {
                future.get();
            }
        } catch (CancellationException ce) {
            t = ce;
        } catch (ExecutionException ee) {
            t = ee.getCause();
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
    if (t != null) {
        System.out.println(t);
    }
}
    
    
    

    public static void main( String [] args) {
    	
    	ExeDemo threadPool = new ExeDemo();
    	
        threadPool.submit( 
                new Runnable() {
                    public void run() {
                        throw new RuntimeException("Ouch! Got an error.");
                    }
                }
        );
        threadPool.shutdown();
    }
}