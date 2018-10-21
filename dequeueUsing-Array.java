 package queue;

 public class Main {
 	public static void main(String[] args) {
 		int sizeOfQueue = 10;
 		Queue obj = new Queue(sizeOfQueue);
 		obj.insertFront(10);  // Adds item to the queue from Front
 		obj.insertFront(20);
 		obj.insertRear(30); // Adds item to the queue from rear
 		obj.insertRear(40);
 		obj.printDequeueFrontToRear();  // Prints items from Front-to-Rear
 		obj.printDequeueRearToFront();   // Prints items from Rear-to-Front
 		obj.deleteRear();      // Deletes item from rear
 		obj.deleteFront();     // Deletes item from front
 		obj.printDequeueFrontToRear();  // Prints items from Front-to-Rear
 		obj.printDequeueRearToFront();   // Prints items from Rear-to-Front
 		System.out.println(obj.isEmpty());
 		System.out.println(obj.front());
 		System.out.println(obj.rear());
 	}
 }
 
  package queue;

 public class Queue {
 private int arr[];
 private int sizeOfDequeue;
 private int front;
 private int rear;

  Queue(int sizeOfDequeue) {
  	this.sizeOfDequeue = sizeOfDequeue;
  	arr = new int[sizeOfDequeue];
  	front = rear = -1;
  }	

  void insertFront(int n) {
  	if(front == -1 && rear == -1) {
  		front = rear = 0;
  		arr[0] = n;
  		return;
  	}

  	int pos = (front + (sizeOfDequeue -1)) %sizeOfDequeue;
 	if(pos == rear) {
 		System.out.println("Overflow condition");
 		return;
 	}
  	arr[pos] = n;
  	front = pos;
  }

  void insertRear(int n) {
  	if(front == -1 && rear == -1) {
  		front = rear = 0;
  		arr[0] = n;
  		return;
  	}
  	int pos = (rear + 1) %sizeOfDequeue;
 	if(pos == front) {
 		System.out.println("Overflow condition");
 		return;
 	}
  	arr[pos] = n;
  	rear = pos;
  }

  void deleteFront() {
  if(front == -1 && rear == -1) {
  		return;
  	}
  if(front == rear) {
  	front = rear = -1;
  	return;
  }
  front = (front + 1)%sizeOfDequeue;
  }

    void deleteRear() {
  if(front == -1 && rear == -1) {
  		return;
  	}
  if(front == rear) {
  	front = rear = -1;
  	return;
  }

  rear = (rear + (sizeOfDequeue-1))%sizeOfDequeue;
  }

 boolean isEmpty() {
   if(front == -1 && rear == -1) {
  		return true;
  	}
  	return false;
 }

 int front() {
 	if(front == -1 && rear == -1) {
  		return Integer.MIN_VALUE;
  	}
  	return arr[front];
 }

  int rear() {
 	if(front == -1 && rear == -1) {
  		return Integer.MIN_VALUE;
  	}
  	return arr[rear];
 }


  void printDequeueFrontToRear() {
  	if(front == -1 && rear == -1) {
  		return;
  	}
  	int f = front;
  	int r = rear;

  	while(f!=rear) {
  		System.out.print(arr[f]+"\t");
  		f = (f+1)%sizeOfDequeue;
  	}
  	System.out.println(arr[f]);
  }


  void printDequeueRearToFront() {
  	if(front == -1 && rear == -1) {
  		return;
  	}
  	int f = front;
  	int r = rear;
  
  	while(r!=front) {
  		System.out.print(arr[r]+"\t");
  		r = (r+(sizeOfDequeue-1))%sizeOfDequeue;
  	}
  	
  	System.out.println(arr[r]);
  }
 }
