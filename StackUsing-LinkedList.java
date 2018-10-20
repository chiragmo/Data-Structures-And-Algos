 package algos;

 public class Main {
	public static void main(String[] args) {
		MyStack obj = new MyStack();
        obj.push(10); // add new item into the stack
        obj.push(20);
        System.out.println(obj.head()); // returns the current head Int return
        System.out.println(obj.isEmpty());  // stack is empty or not Boolean return
        obj.printStack(); // prints the entire MyStack
        obj.pop();
         obj.pop();
        obj.printStack(); 
	}
}

class Node {
	int num;
	Node next;
}

class MyStack {
	Node head;

	void push(int n) {
		if(head == null) {
			head = new Node();
			head.num = n;
			head.next = null;
			return;
		}
		Node node = new Node();
		node.num = n;
		node.next = head;
		head = node;
	}

	void pop() {
		Node node = head;
		if(head == null) {
			System.out.println("Underflow condition");
			return;
		}
		head = node.next;
		node = null;
	}

	boolean isEmpty() {
		if(head == null){
			return true;
		}
		return false;
	}

	int head() {
		if(head == null) {
			return 0;
		}
		return head.num;
	}

	void printStack() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.num);
			temp = temp.next;
		}
	}


} 
