package corejava;

public class PrintEvenOddTester {
	
	boolean odd;
	int start = 1;
	int max = 10;

	PrintEvenOddTester() { }

	public synchronized void printOdd() {
		while (start < max) {
			while (!odd) {
				try { wait(); } catch (InterruptedException e) {}
			}
			System.out.println("printOdd - " + start);
			start++;
			odd = false;
			notify();
		}
	}
	
	public synchronized void printEven() {
		while (start < max) {
			while (odd) {
				try { wait(); } catch (InterruptedException e) {}
			}
			System.out.println("printEven - " + start);
			start++;
			odd = true;
			notify();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		PrintEvenOddTester printer = new PrintEvenOddTester();
		printer.odd = true;
		new Thread(()-> printer.printOdd()).start();
		new Thread(()-> printer.printEven()).start();
	}

}
