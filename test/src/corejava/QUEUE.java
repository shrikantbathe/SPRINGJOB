package corejava;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QUEUE {

	public static void main(String[] args) {
        
		ExecutorService sadsd = Executors.newCachedThreadPool();
 
		
		Queue<String> pq = new PriorityQueue<>(); 
         
        pq.add("g"); 
        pq.add("f"); 
        pq.add("g"); 
        pq.add("x"); 
        pq.add("f"); 
        pq.add("s"); 
        pq.add("r"); 
        pq.add("d"); 
  
        System.out.println(pq); }

}
