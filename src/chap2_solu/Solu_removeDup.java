package chap2_solu;

import java.util.HashSet;

import chap2.LinkedList;
import chap2.Node;

public class Solu_removeDup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(1);
		Node n2 = new Node(1);
		Node n3 = new Node(1);
		Node n4 = new Node(1);
		Node n5 = new Node(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		Node n6 = n1;
		deleteDups1(n6);
		
		while (n6 != null) {
			System.out.println(n6.val);
			n6 = n6.next;
		}
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
		if (n == null || n.next == null) {
			return;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		Node current = null;
		while (n != null) {
			if (set.contains(n.val)) {
				current.next = current.next.next;
			} else {
				set.add(n.val);
				current = n;
			}
			n = n.next;
		}
	}
	
	// this version does't use buffer, use two pointers to remove the dup
	// one is the current pointed node, another is a runner pointing to 
	// the subsequent nodes to iterate all nodes behind this node 
	
	public static void deleteDups1(Node head){
		if (head == null || head.next == null) {
			return;
		}
			Node current = head;
			while (current != null) {
			Node  runner = current;
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
