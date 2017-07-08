package chap2;

public class Node_deleteNode {
	public static void main(String [] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		Node n6 = n1;
		Node n7 = deleteNode(n6,3);
		
		while (n7.next != null) {
			System.out.println(n7.val);
			n7 = n7.next;
		}
		System.out.println(n7.val);
	}
	
	
	
	
	
	
	
	
	
	
	public static Node deleteNode(Node head, int d) {
		Node n = head;
		if (n.val == d) {
			return head.next;
		}
	
		while (n.next != null) {
			if (n.next.val == d ){
				n.next = n.next.next;
			}
			n = n.next;
		}
		return head;
	}
}
