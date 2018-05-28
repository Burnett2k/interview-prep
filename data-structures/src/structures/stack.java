package structures;

public class stack {
	

	//test it out here
	public static void main(String[] args) {
		System.out.println("hello");	
		stack myStack = new stack();
		myStack.test();
		
	}
	
	
	
	
	public void test() {
		System.out.println(this.isEmpty());
		top = new Node(1);
		this.push(2);
		this.push(3);
		System.out.println(this.isEmpty());
		
		System.out.println(top.data);
		
	}
	
	
	private static class Node {
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	private Node top;
	
	public Node pop() {
		//if top doesn't exist, return null
		if (top == null) 
			return null;
		
		//create item variable to store top's data
		Node item = new stack.Node(top.data);
		
		//remove top from the stack by setting it to top.next
		top = top.next;

		//return removed item
		return item;
	}
	
	public void push(int data) {
		
		//instantiate a new node to add to the stack
		Node t = new Node(data);
		
		//move the top of the stack to be the next item in the stack (FIFO)
		t.next = top;
		
		//set the newest item to the top o' the stack
		top = t;
		
		
	}
	
	public Node peek() {
		return top;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	

	
}
