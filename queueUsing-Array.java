 public class Main {
 	public static void main(String[] args) {
 		int sizeOfQueue = 3;
 		Queue obj = new Queue(sizeOfQueue);
 		obj.enqueue(10);  // Adds item to the queue from rear
 		obj.enqueue(20); 
 		obj.enqueue(30);
 		System.out.println(obj.rear());  // gets the item at the rear of the queue
 		System.out.println(obj.front()); // gets the item at the front of the queue
 		obj.dequeue();  // Deletes item to the queue from front
 		obj.dequeue();
 		obj.dequeue();
 		System.out.println(obj.isEmpty()); // checks if queue is empty or not
 		obj.printQueue(); 
 	}
 }
 
 class Queue {
 	private int arr[];
 	private int sizeOfQueue;
 	private int front;
 	private int rear;
 	Queue(int sizeOfQueue) {
 		this.sizeOfQueue = sizeOfQueue;
 		this.front = -1;
 		this.rear = -1;
 		arr = new int[sizeOfQueue];
 	}

 	void enqueue(int n) {
 		if(front == -1 && rear == -1) {
 			front = 0;
 			rear = 0;
 			arr[0] = n;
 			return;
 		}
 		 int pos = (rear + 1) % sizeOfQueue;
 		if(pos == front) {
 			System.out.println("Overflow condition");
 			return;
 		}
 		rear = pos;
 	    arr[rear] = n;
 	    		
 	}

 	void dequeue() {
 		if(front == -1 && rear == -1) {
 			System.out.println("Underflow condition");
 			return; 			
 		}
 		if(front == rear) {
 			front = -1;
 			rear = -1;
 			return;
 		} 
 		front = (front + 1) % sizeOfQueue;
 	}

 	boolean isEmpty() {
 		 if(front == -1 && rear == -1) {
 			return true;
 		}
 		return false;
 	}

 	int rear() {
 		 if(front != -1 && rear != -1) {
 			return arr[rear];
 		}
 		return Integer.MIN_VALUE;
 	}

 	int front() {
 		if(front != -1 && rear != -1) {
 			return arr[front];
 		}
 		return Integer.MIN_VALUE;
 	}

 	void printQueue() {
 		if(front == -1 && rear == -1) {
 			return;
 		}
 		int f = front;
 		int r = rear;
  	
  
       while(f!=r) {
       	System.out.println(arr[f]);
       	f = (f + 1) % sizeOfQueue;
       }
       System.out.println(arr[f]);

 	}



 }
