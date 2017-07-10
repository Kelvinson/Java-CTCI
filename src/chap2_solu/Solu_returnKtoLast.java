package chap2_solu;

import chap2.Node;

public class Solu_returnKtoLast {

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(1);
		Node n4 = new Node(1);
		Node n5 = new Node(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		Node n6 = returnKtoLast1(n1,3);
		
		while (n6 != null) {
			System.out.println(n6.val);
			n6 = n6.next;
		}

	}
	
	public static Node returnKtoLast (Node head, int k) {
	
		while (k-- > 0) {
			if (head.next == null) {
			    System.out.println("sorry, the list is out of index");
				break;
			} else {
				head = head.next;
			}
		}
		return head;
	}
	
	// this is the solution the book CTCI gives, but I don't know how
	public static Node returnKtoLast1(Node head, int k) {
		Node p1 = head;
		Node p2 = head;
		for (int i = 0; i < k; i++) {
			if (p1 == null) return null;
			p1 = p1.next;
		}
		
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p2;
	}

}
