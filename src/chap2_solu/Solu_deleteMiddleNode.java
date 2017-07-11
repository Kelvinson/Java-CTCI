package chap2_solu;

import chap2.Node;

public class Solu_deleteMiddleNode {

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		 deleteMiddleNode1(n3);
		
		while (n6 != null) {
			System.out.println(n6.val);
			n6 = n6.next;
		}
	}
	
	public static boolean deleteMiddleNode(Node middleNode) {
		// The solution considers this: since only the middle point node is given, 
		// it's not possible to traverse back so the way is to shift the node left 
		// once, that's to say let the val of this node be the val of next element
		// and so on forth. Of course the prequisit is that the val is public specifier
		// Note: this is very stupid solution, just copy the val of next node to 
		// this node and delete next node will be OK
		
		Node current = middleNode;
		if (current == null || current.next == null) {
			return false;
		}
		while (current.next.next != null) {
			current.val = current.next.val;
			current = current.next;
		}
		current.val = current.next.val;
		current.next = null;
		return true;
	}
	public static boolean deleteMiddleNode1(Node middleNode) {
	Node current = middleNode;
	if (current == null || current.next == null) {
		return false;
	}
	
	current.val = current.next.val;
	current.next = current.next.next;
	return true;
}

}
