package chap2_solu;

import chap2.Node;

public class Solu_isPalindromeRecursive {

	public static void main(String[] args) {
//		Node n1 = new Node(3);
//		Node n2 = new Node(2);
//		Node n3 = new Node(1);
//		Node n4 = new Node(1);
//		Node n5 = new Node(2);
//		Node n6 = new Node(1);
//		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5; 
//		n5.next = n6;
//		
//		System.out.println(isPalindrome(n1));

	}
	static boolean isPalindrome(Node head) {
		int length = lengthOfList(head);
		Result p = isPalindromeRecurse(head,length);
		return p.result;
	}
	
	static Result isPalindromeRecurse(Node head, int length) {
		if (head  == null || length <= 0) { // Even number of nodes
			return new Result(head,true);
		} else if (length == 1) { // Odd number of nodes
			return new Result(head.next, true);
		}
		
		/** Recurse on sublist */
		Result res = isPalindromeRecurse(head.next, length - 2);
		
		/** If child calls are not a palindrome, pass back up a failure */
		if (!res.result || res.node == null) {
			return res;
		}
		
		/* Check if matches corresponding node on other side*/
		res.result = (head.val == res.node.val);
		
		/*Return corresponding node */
		res.node = res.node.next;
		
		return res;
	}
	
	
	static int lengthOfList(Node n) {
		int size = 0;
		while (n != null) {
			size++;
			n = n.next;
		}
		return size;
	}
	
}

class Result {
	public Node node;
	public boolean result;
	public Result(Node head, boolean b) {
		node = head;
		result = b;
	}
}

