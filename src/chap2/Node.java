package chap2;

/**
 *  For building a single list
 * @author kelvinson
 *
 */
public class Node {
	
	public int val;
	public Node next = null;
	public Node(int n) {
		this.val = n;
	}
	
	void addToTail(int d) {
		Node node = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = node;
	}
	
	public static Node deleteNode(Node head, int d) {
		Node n = head;
		
		if (n.val == d) {
			return head.next;
		}
		
		// because this is single list node, so the node cannot remove 
		// itself from the single list. in order to remove it, the operation
		// has to be advanced to be the previous node, it can let its next 
		// pointer to be the target' next node but the target node itself 
		// cannot.
		
		while (n.next != null) {
			if (n.next.val == d) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}
	
}
