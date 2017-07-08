package chap2;

public class LinkedList {
	public Node frontsentinial = null;
	private int size;
	public int getSize() {
		return size;
	}
	public  void append (Node n) {
		if (frontsentinial == null) {
			frontsentinial.next = n;
			size ++;
		} else {
			Node current = frontsentinial.next;
			while (current.next != null) {
				current = current.next;
			}
			current.next = n;
			size ++;
		}

	}
	
	public void removeAtBack() {
		if (frontsentinial.next == null) {
			return;
		}
		
		Node current = frontsentinial.next;
		if (current.next == null) {
			frontsentinial.next = null;
		} else {
			while (current.next.next != null) {
				current = current.next;
			}
			current.next = null;
		}
		size --;
	}
	
	public int getElement(int index) {
		if (frontsentinial.next == null) {
			System.out.println("the list is empty, cannot get element from it");
			return -Integer.MIN_VALUE;
		}
		Node current = frontsentinial.next;
		while (index-- > 0) {
			if (current.next == null) {
				System.out.println("the list is empty, cannot get element from it");
				return -Integer.MIN_VALUE;
			}
			current = current.next;
		}
		return current.val;
	}
}
