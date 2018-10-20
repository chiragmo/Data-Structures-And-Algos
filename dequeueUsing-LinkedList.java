 package queue;

 public class Main {
 	public static void main(String[] args) {
 		Queue obj = new Queue();
 		obj.insertFront(10);  // Adds item to the queue from Front
 		obj.insertFront(20);
 		obj.insertRear(30); // Adds item to the queue from rear
 		obj.insertRear(40);
 		obj.printFromFront();  // Prints items from Front-to-Rear
 		obj.printFromRear();   // Prints items from Rear-to-Front
 		obj.deleteRear();      // Deletes item from rear
 		obj.deleteFront();     // Deletes item from front
 		obj.printFromFront();  
 		obj.printFromRear();
 		System.out.println(obj.isEmpty());
 		System.out.println(obj.front());
 		System.out.println(obj.rear());

 	}
 }
 
 class Node {
 	int num;
 	Node next;
 	Node prev;
 }

 public class Queue {
 	private Node front;
 	private Node rear;
 	
 	Queue() {
 		front = null;
 		rear = null;
 	}

 	void insertRear(int n) {
 		Node node = new Node();
 		node.num = n;
 		if(front == null && rear == null) {
  		 node.next = null;
  		 node.prev = null;
  		 front = rear = node;
  		 return;
 		}
 		Node temp = rear;	
 		rear.next = node;
 		rear= node;
 		rear.prev = temp;
 	}

 	void insertFront(int n) {
 		Node node = new Node();
 		node.num = n;
 		if(front == null && rear == null) {
  		 node.next = null;
  		 front = rear = node;
  		 return;
 		}	
 		Node temp = front;
 		front = node;
 		front.next = temp;
 		temp.prev = front;
 	}


 	void deleteRear() {
 		if(front == null && rear == null) {
 			System.out.println("Underflow operation");
 			return;
 		}
 		if(front == rear) {
 			front = null;
 			rear = null;
 			return;
 		}
 		Node temp = rear.prev;
 		rear= null;
 		rear = temp;
 		temp.next = null;
 	}

 	void deleteFront() {
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
 		front.prev = null;
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

 	void printFromFront() {
 		Node temp = front;

 		while(temp !=null) {
 			System.out.print(temp.num+"\t");
 			temp = temp.next;
 		}
 		System.out.println();
 	}

 	void printFromRear() {
 		Node temp = rear;

 		while(temp !=null) {
 			System.out.print(temp.num+"\t");
 			temp = temp.prev;
 		}
 		System.out.println();
 	}
 }
