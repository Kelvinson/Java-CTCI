package chap2_solu;

import chap2.Node;

public class Solu_loopDetection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Node findBegining(Node head) {
		Node slow  = head;
		Node fast = head;
		
		/* Find meeting point, This will be LOOP_SIZE - k steps into the loop */
		while (fast != null && fast.next != null) {
			slow  = slow.next;
			fast = fast.next.next;
			if (slow == fast) { // Collision
				break;
			}
		}
		/*Error check - no meeting point, and therefore no loop */
		if (fast == null || fast.next == null) {
			return null;
		}
		
		/* Move slow to Head, keep fast at meeting point, each are K steps from
		 * The loop start. If they move at the same pace, they must meet at the
		 * loop start point.
		 */
		
		slow  = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		/* Both now point to the start of the loop */
		return fast;
	}
	
}
