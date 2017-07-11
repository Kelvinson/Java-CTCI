package chap2_solu;

import java.util.Stack;

import chap2.Node;

public class Solu_sumReverseList {

	public static void main(String[] args) {
		Node n1 = new Node(7);
		Node n2 = new Node(1);
		Node n3 = new Node(6);
		Node n4 = new Node(5);
		Node n5 = new Node(9);
		Node n6 = new Node(2);
		n1.next = n2;
		n2.next = n3;
		n4.next = n5;
		n5.next = n6;

		Node result = addList(n1,n4,0);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}

	public static Node sumReverseList(Node a, Node b) {
		if (a == null|| b == null) { return null;}
		int sum_a = 0;
		int sum_b = 0;
		Stack<Integer> digit_a = new Stack<Integer>();
		Stack<Integer> digit_b = new Stack<Integer>();
		while (a != null) {
			digit_a.push(a.val);
			a = a.next;
		}

		while (b != null) {
			digit_b.push(b.val);
			b = b.next;
		}
		int temp , carry = 0;
		Node result = null;
		Node result_head  = null;
		int val_a, val_b;
		while (!digit_a.isEmpty() && !digit_b.isEmpty()) {
			val_a = digit_a.pop();
			val_b = digit_b.pop();
			temp =  (val_a + val_b + carry) % 10;
			carry = (val_a+ val_b) >= 10 ? 1 : 0;
			Node next = new Node(temp);
			if (result == null) {
				result = next;
				result_head = result;
			} else {
				result.next = next;
				result = result.next;
			}
		}
		
		while (!digit_a.isEmpty()) {
			val_a = digit_a.pop();
			carry = val_a+carry >= 10 ? 1 : 0;
			temp = (digit_a.pop() + carry) % 10;
			Node next = new Node(temp);
			result.next = next;
			result = result.next;
			if (digit_a.empty()) {
				Node last_digit = new Node(carry);
				result.next = last_digit;
			}
		}
		while (!digit_b.isEmpty()) {
			val_b = digit_b.pop();
			carry = val_b+carry >= 10 ? 1 : 0;
			temp = (digit_b.pop() + carry) % 10;
			Node next = new Node(temp);
			result.next = next;
			result = result.next;
			if (digit_a.empty()) {
				Node last_digit = new Node(carry);
				result.next = last_digit;
			}
		}
		
		return result_head;	
	}
	
	public static Node addList(Node l1, Node l2, int carry) {
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}
		
		Node result = null;
		int value = carry;
		if (l1 != null) {
			value += l1.val;
		}
		if (l2 != null) {
			value += l2.val;
		}
		result.val = value % 10;
		if (l1 != null || l2 != null) {
		Node more = addList(l1 == null ? null : l1.next, 
							l2 == null ? null : l2.next,
							value >= 10 ? 1 : 0);
		result.next = more;
		}
		return result;
	}
	
}
