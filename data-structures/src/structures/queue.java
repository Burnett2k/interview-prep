package structures;

public class queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		queue testQueue = new queue();
		System.out.println(testQueue.isEmpty());
		testQueue.add(1);
		testQueue.add(2);
		testQueue.add(3);
		testQueue.add(4);
		testQueue.add(5);
		testQueue.add(6);
		testQueue.add(7);
		System.out.println(testQueue.first.data);
		System.out.println(testQueue.last.data);
		testQueue.remove();
		System.out.println(testQueue.first.data);
	}
	
	private static class Node {
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	private Node first;
	private Node last;
	
	public void add(int data) {
		//add item to tail
		Node item = new Node(data);
		
		if (last != null) {
			last.next = item;
		}
		last = item;
		if (first == null) {
			first = last;
		}
	}
	
	public Node remove() {
		Node item = null;
		if (first != null) {
			item = first;
			first = first.next;
		}
		if (first == null) {
			last = null;
		}
		return item;
	}
	
	public Node peek() {
		
		Node item = null;
		if (first != null) {
			return first;
		}
		
		return item;
	}
	
	public boolean isEmpty() {
		return first == null;
	}

}
