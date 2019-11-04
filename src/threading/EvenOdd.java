package threading;

import java.util.concurrent.atomic.AtomicInteger;

public class EvenOdd {
	
	public static void main(String[] args) {
		EvenOddPrint oddThread = new EvenOddPrint(1);
		EvenOddPrint evenThread = new EvenOddPrint(0);
		Thread thread1 = new Thread(evenThread, "Even Thread");
		Thread thread2 = new Thread(oddThread, "Odd Thread");
		thread1.start();
		thread2.start();
	}

}
class EvenOddPrint implements Runnable {

	static Object lock = new Object();
	static AtomicInteger value = new AtomicInteger(1);
	private int remainder;
	
	public EvenOddPrint(int remainder) {
		// TODO Auto-generated constructor stub
		this.remainder = remainder;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(value.get() < 10) {
			synchronized (lock) {
				while(value.get()%2 != this.remainder) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + value.getAndIncrement());
				lock.notifyAll();
			}
		}
	}
}
