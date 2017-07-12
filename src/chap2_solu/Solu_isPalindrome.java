package chap2_solu;

import java.util.Stack;

import chap2.Node;

public class Solu_isPalindrome {

	public static void main(String[] args) {
		Node n1 = new Node(3);
		Node n2 = new Node(2);
		Node n3 = new Node(1);
		Node n4 = new Node(1);
		Node n5 = new Node(2);
		Node n6 = new Node(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		/** test the cloneAndReverse method **/
		/*Node n7 = cloneAndReverse(n1);
		while (n7 != null) {
			System.out.println(n7.val);
			n7 = n7.next;
		}*/
//		n6.next = n1;
		
//		while (n1 != null) {
//			System.out.println(n1.val);
//			n1 = n1.next;
//		}
		
		System.out.println(isPalindrome_v2(n1));
	}
	
	/* This is my own solution using stack
	 * but it has to store the whole list 
	 * when the length of the link is not known 
	 * so it is not the optimal solution in 
	 * the case where space complexity is restricted. 
	 */
	public static boolean isPalindrome(Node list) {
		Stack<Integer> reverse = new Stack<Integer>();
		Node pointer  = list;
		while (pointer != null) {
			reverse.push(pointer.val);
			pointer = pointer.next;
		}
		
		int len = reverse.size();
		int temp;		
		for (int i = 0; i < len/2 + 1; i++) {
			temp = reverse.pop(); 
			if (list.val != temp) {
				return false;
			}
			list = list.next;
		}
		return true;
	}
	
	public static boolean isPalindrome_v1(Node list) {
		Node cp = reverseAndClone(list);;
		return isEqual(list, cp);
	}
	
	/**
	 *  This function reverse the list and output it to another node list
	 * @param list
	 * @return its reverse node list
	 */
	public static Node reverseAndClone(Node list) {
		Node head = null;
		while (list != null) {
			Node n = new Node(list.val);
			n.next = head;
			head = n;
			list = list.next;
		}
		return head;
	}
	
	/**
	 *  This function returns whether if a node list is the same as another node list
	 *  it's based on the fact it returns true if m1 is the same length as m2 first
	 *  and then every element of m1 is the same  as the element at the same position
	 *  at m2. because the length cannot be known in list, so it just traverse only if
	 *  m1 and m2 current node are both not null and when it stops check whether m1 and 
	 *  m2 are both null. 
	 * @param m1
	 * @param m2
	 * @return
	 */
	public static boolean isEqual(Node m1, Node m2) {
		while (m1 != null && m2 != null) {
			if (m1.val != m2.val) {
				return false;
			}
			m1 = m1.next;
			m2 = m2.next;
		}
		return m1 == null && m2 == null;
	}
	
	/**
	 * This solution does not to store the whole link of nodes
	 * only the first half is needed to be stored so it is friendly 
	 * for space complexity. It use fast runner and slow runner to 
	 * find the middle point of the list of node.
	 * @param list
	 * @return
	 */
	
	// Note: When I implemented this method I made two mistakes:
	// 1. find the beginning point of the latter half of the link
	//    no matter whether fast runner has next node(equals whether
	//    odd or even number of elements the node list have)
	//    That is to say the right point is the next node of the 
	// 	  slow runner when fast runner stops
	// 2. the condition of the fast runner stops, warning! it is not 
	// 	  simply while (fast.next.next != null) because if fast.next 
	// 	  is null then access of fast.next.next will throw the nullException
	// 	  <em>So the right way is to use the short circuit therome like:
	//    while (fast.next != null && fast.next.next != null) <em>
	// 	  the loop stops when fast.next is null.
	
	public static boolean isPalindrome_v2(Node list) {
		
		Node fast = list;
		Node slow  = list;
		
		Stack<Integer> halfReverse = new Stack<Integer>();
		if (list.next  == null) {
			return false;
		} else if (list.next.next == null) {
			return list.val == list.next.val;
		}
		
		while (fast.next != null && fast.next.next != null) {
			slow  = list.next;
			fast = fast.next.next;
		}
		
		slow  = slow.next;   // this is the beginning element to store in the stack as the second half the link list.
		while (slow != null) {
			halfReverse.push(slow.val);
			slow = slow.next;
		}
	
		while (!halfReverse.isEmpty()) {
			if (list.val != halfReverse.pop()) {
				return false;
			}
			list = list.next;
		}
		
		return true;
	}

}
