package multithreading;

import java.util.HashMap;
import java.util.LinkedList;



public class ODDEVEN {
	public ODDEVEN() {
		
	}
	LinkedList dsd=null;
	HashMap  dssd=null;
	int min= 1;
	int max= 20;
	boolean isOdd = false;
	
	synchronized void  printOdd() throws InterruptedException{
		
		while (min <= max) {
			while (isOdd) {
				wait();
			}
			System.out.println(min);
			min ++;
			notify();
		}
	}

	synchronized void printEven() throws InterruptedException{
		while (min <= max) {
			while (isOdd) {
				wait();
			}
			System.out.println(min);
			min ++;
			notify();
		}
	}
	
	
	
	public static void main(String[] args) {
		
		ODDEVEN ODDEVEN1 = new ODDEVEN();
		
		new Thread(()->{
			try {
				ODDEVEN1.printEven();
			} catch (Exception e) {
			}
		} ).start();
		
		new Thread(()->{
			try {
				ODDEVEN1.printOdd();
			} catch (Exception e) {
			}
		} ).start();
		
	}

	
	
}
