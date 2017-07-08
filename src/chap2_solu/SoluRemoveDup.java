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
	
	// McDowell's using set and two pointers to iterate the whole list.
	// node n will iterate all the nodes while previous will remove the 
	// dups and become the result list. this version use buffer
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
	
	// this version does't use buffer
	
	public static void deleteDup1(Node head){
		Node current = head;
		while (current != null) {
			Node runner = current;
			while (runner.next != null) {
				if (runner.next.val == current.val) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
	

}
