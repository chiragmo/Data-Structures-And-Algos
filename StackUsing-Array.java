 package algos;

 public class Main {
	public static void main(String[] args) {
		int sizeOfStack = 2; // specify the stack size
		MyStack obj = new MyStack(sizeOfStack);
        obj.push(10); // add new item into the stack
        obj.push(20);
        obj.isEmpty(); // boolean return value
        obj.pop(); // remove item from the stack
        obj.printStack(); // prints the entire stack
        obj.head();  // gives the current head/top
	}
}

class MyStack {
	private int top;
	private int arr[];
	private int sizeOfStack;
	MyStack(int sizeOfStack) {
		this.top = -1;
		this.sizeOfStack = sizeOfStack;
		arr = new int[sizeOfStack];
		
	}

	void push(int n) {
		if(top == (sizeOfStack-1)) {
			System.out.println("stack full; Overflow Operation");
			return;
		}
		arr[++top] = n;
	} 

	void pop() {
		if(top < 0) {
			System.out.println("stack empty; Underflow Operation");
			return;
		}
     arr[top--] = Integer.MIN_VALUE;
	}

	boolean isEmpty() {
		if(top<0) {
			return true;
		}
		return false;
	}

	int head() {
		return top+1;
	}

	void printStack() {
		for(int i =0; i<= top; i++) {
			System.out.println(arr[i]);
		}
	}
}
