package structures;

public class linkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		linkedlist testLinkedList = new linkedlist();
		testLinkedList.add(1);
		testLinkedList.add(2);
		testLinkedList.add(3);
		testLinkedList.add(4);
		testLinkedList.remove(5);
		
		System.out.println("+++++++");
		Node currentNode = testLinkedList.head;
		if (currentNode.next != null) {
			while (currentNode.next != null) {
				System.out.println(currentNode.data);
				currentNode = currentNode.next;
			}
		}
		
		System.out.println(currentNode.data);
		System.out.println("+++++++");
	}
	
	public Node head;
	
	private static class Node {
		
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
		}
	
	}
	
	public void add(int data) {
		Node item = new Node(data);
		if (this.head == null) {
			this.head = item;
			return;
		}
		
		if (head.next == null) {
			head.next = item;
		} else {
			Node currentNode = head;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = item;
		}	
	}
	
	public void remove(int data) {
		if (head == null)
			return;
		
		Node currentNode = head;
		if (currentNode.data == data) {
			head = head.next;
		}

		while (currentNode.next != null) {

			if (currentNode.next.data == data) {
				if (currentNode.next.next != null) {
					currentNode.next = currentNode.next.next;	
				} else {
					currentNode.next = null;
					return;
				}
				
			}
			currentNode = currentNode.next;

		}
		
		
		if (currentNode.data == data) {
			System.out.println(currentNode.data);
			currentNode = null;
		}
		// [1,2,3,4]
	}

}
