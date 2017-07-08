package chap2_solu;

import java.util.HashSet;

import chap2.LinkedList;
import chap2.Node;

public class SoluRemoveDup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// my own naive solution
	public static void removeDup(LinkedList ll) {
		if (ll.getSize() == 0 || ll.getSize() == 1) {
			return ;
		}
		
		Node p = ll.frontsentinial.next;
		Node q = ll.frontsentinial.next;
		while (q.next.next != null) {
			for (Node temp = p;temp != q; temp = temp.next) {
				if (q.next.val == temp.val) {
					q.next = q.next.next;
				}
			}
			q.next = q.next.next;
		}
	}
	
	//McDowell's using set method;
	public static void deleteDups(Node n) {
		HashSet<Integer> set = new HashSet<Integer>();
		Node previous = null;
		while (n != null) {
			if (set.contains(n.val)) {
				previous.next = n.next;
			} else {
				set.add(n.val);
				previous = n;
			}
			n = n.next;
		}
	}
	

}
