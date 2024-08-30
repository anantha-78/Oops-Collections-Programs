package MultiThreading;

import java.util.Scanner;

class Demo2 extends Thread
{
	@Override
	public void run() {
		
		String name = Thread.currentThread().getName();
		
		if(name.equals("ADD")) {
			add();
		}
		else if(name.equals("PRINTCHAR")) {
			printChar();
		}
		else {
			printNum();
		}
	}
		
		public void add() 
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter n1: ");
			int n1 = scan.nextInt();
			System.out.println("Enter n2: ");
			int n2 = scan.nextInt();
			scan.close();
			int sum = n1 + n2;
			System.out.println("Sum of n1 and n2 are " + sum);
		}
		
		public void printChar() {
			System.out.println("Printing Characters ...");
			for(int i=65; i<=75; i++) {
				System.out.println((char)i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
			
		public void printNum() {
			System.out.println("Printing Numbers...");
			for(int i=1; i<=10; i++) {
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}

public class Demo1 {
	public static void main(String[] args) {
		
		Demo2 d = new Demo2();
		
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);
		Thread t3 = new Thread(d);
		
		t1.setName("ADD");
		t2.setName("PRINTCHAR");
		t3.setName("PRINTNUM");
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}
