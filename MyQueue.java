/*
 * Implementation of Queue Data structure
  */

public class MyQueue {
	public int back=0;
	public int front=0;
	public String[] QueueArray;
	
	public MyQueue(){
		
		
		QueueArray = new String[20];
	}	

	public void push(String Item) {
		QueueArray[front]=Item;
		front++;
		
		
	}
	public void pop() {
		QueueArray[back]="-1";
		back++;
		
	}
	
	public void Display() {
		for (int i=back;i<front;i++) {
			System.out.println(QueueArray[i]);
		}
	}
	
}
