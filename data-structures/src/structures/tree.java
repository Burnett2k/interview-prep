package structures;

public class tree {

	public static void main(String[] args) {
		Node root = new Node(50);
		root.insert(20);
		root.insert(30);
		root.insert(40);
		root.insert(60);
		root.insert(70);
		root.insert(80);
		
		System.out.println("+++++++");
		root.inOrderTraversal();
		System.out.println("+++++++");
		root.preOrderTraversal();
		System.out.println("+++++++");
		root.postOrderTraversal();
		
	}
	
	public static class Node {
		public int data;
		public Node left;
		public Node right;
		
		public Node (int data) {
			this.data = data;
		}
		
		public void insert(int value) {

			if (value <= data) {
				System.out.println("blah");
				if (left == null) {
					left = new Node(value);
				} else {
					left.insert(value);
				}
			} else {
				System.out.println("blah2");
				if (right == null) {
					right = new Node(value);
				} else {
					right.insert(value);
				}
			}
		}
		
		public void inOrderTraversal() {
			if (left != null) {
				//System.out.println(left.data);
				left.inOrderTraversal();
			}
			System.out.println(data);
			if (right != null) {
				//System.out.println(right.data);
				right.inOrderTraversal();
			}
			
			
		}

		
		public void preOrderTraversal() {
			System.out.println(data);
			if (left != null) {
				left.preOrderTraversal();
			}
			if (right != null) {
				right.preOrderTraversal();
			}
		}
		
		public void postOrderTraversal() {
			if (left != null) {
				left.postOrderTraversal();
			}
			if (right != null) {
				right.postOrderTraversal();
			}
			System.out.println(data);
			
		}
	}
	
}
