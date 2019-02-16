
 class Node 
{ 
	int data; 
	Node left, right;
	public Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

public class BinaryTreeToDoublyLinkedList 
{ 
	Node root; Node prev = null;  Node head = null; Node tail = null;
	void inorder(Node root) 
	{ 
		if (root == null) 
		return; 
	inorder(root.left);;
	if(prev!=null){
	prev.right = root;
	}
	doOp(root);
	tail = root;
	inorder(root.right);
	} 
	
	void printFromHead() 
	{ 
	    Node temp = head;
	   while(temp!=null) {
	       System.out.println(temp.data);
	       temp = temp.right;
	   }
	} 
	
	void printFromTail() 
	{ 
	    Node temp = tail;
	   while(temp!=null) {
	       System.out.println(temp.data);
	       temp = temp.left;
	   }
	}
	
	void doOp(Node root) {
	    if(prev == null) {
	        head = root;
	    }
	    root.left = prev;
	    prev = root;
	}

	public static void main(String args[]) 
	{ 

		/* creating a binary tree and entering 
		the nodes */
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
    /* Inorder travesal and conversion by doOp() */
		tree.inorder(tree.root); 
		System.out.println("Printing linked list from Head");
		tree.printFromHead();
		System.out.println("\nPrinting linked list from Tail");
		tree.printFromTail();
	} 
} 
