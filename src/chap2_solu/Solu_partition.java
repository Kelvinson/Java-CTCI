package chap2_solu;

import chap2.Node;

public class Solu_partition {

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(4);
		Node n3 = new Node(3);
		Node n4 = new Node(0);
		Node n5 = new Node(2);
		Node n6 = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		 n6 = partition(n1,3);
		
		while (n6 != null) {
			System.out.println(n6.val);
			n6 = n6.next;
		}
	}
	
	public static Node partition(Node head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		Node begin = null;
		Node after = null;
		Node first = null;
		while (head != null) {
			Node next  = head.next;
			if (head.val < x ) {
				begin.next = head;
				begin = begin.next;
				first  = head;
			}else {
				
			}
			
			head = next;
		}
		return first;
		
	}
}
