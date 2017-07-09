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
		Node n6 = returnKtoLast(n1,6);
		
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

}
