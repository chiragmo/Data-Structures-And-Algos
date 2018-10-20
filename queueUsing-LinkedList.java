 package queue;

 public class Main {
 	public static void main(String[] args) {
 		Queue obj = new Queue();
 		obj.enqueue(10);  // Adds item to the queue from rear
 		obj.enqueue(20); 
 		obj.enqueue(30);
 		obj.printQueue();
 		System.out.println(obj.rear());  // gets the item at the rear of the queue; returns INT_MIN if empty
 		System.out.println(obj.front()); // gets the item at the front of the queue; returns INT_MIN if empty
 		obj.dequeue();
 		obj.dequeue();
 		System.out.println(obj.isEmpty());
 	}
 }
 
 class Node {
 	int num;
 	Node next;
 }

  class Queue {
 	private Node front;
 	private Node rear;
 	
 	Queue() {
 		front = null;
 		rear = null;
 	}

 	void enqueue(int n) {
 		Node node = new Node();
 		node.num = n;
 		if(front == null && rear == null) {
  		 node.next = null;
  		 front = rear = node;
  		 return;
 		}	
 		rear.next = node;
 		rear= node;
 	}

 	void dequeue() {
 		if(front == null && rear == null) {
 			System.out.println("Underflow operation");
 			return;
 		}
 		if(front == rear) {
 			front = null;
 			rear = null;
 			return;
 		}
 		Node temp = front.next;
 		front = null;
 		front = temp;
 	}

 	boolean isEmpty() {
 		if(front == null && rear == null) {
 			return true;
 		}
 		return false;
 	}

 	int front() {
 	if(front == null && rear == null) {
 			return Integer.MIN_VALUE;
 		}
 		return front.num;
 	}

 	int rear() {
 	if(front == null && rear == null) {
 			return Integer.MIN_VALUE;
 		}
 		return rear.num;
 	}

 	void printQueue() {
 		Node temp = front;

 		while(temp !=null) {
 			System.out.println(temp.num);
 			temp = temp.next;
 		}
 	}
 }
