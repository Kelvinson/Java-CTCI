package chap2_solu;

import chap2.Node;

public class Solu_findInterSection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Node findIntersection(Node l1, Node l2) {
		int len1 = getNodeLength(l1);
		int len2 = getNodeLength(l2);
		
		Node shorter = len1 > len2 ? l2 : l1;
		Node longer = len1 > len2 ? l1 :l2;
		
		/* get the difference of longer list and shorter list */
		int diff =getNodeLength(longer) - getNodeLength(shorter);
		
		
		/* Go to the kth node of longer list */
		while (diff-- > 0) {
			longer = longer.next;
		}
		
		/* Move both shorter linked list and longer linked list until 
		 * they get to the intersection node
		 * */
		
		while (shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}
	
		/* If either of the two list comes to the tail, that' to say 
		 * no intersection exsits */
		
		if (shorter == null || longer == null) {
			return null;
		} else {
			return longer;
		}
	}
	
	int getNodeLength(Node list) {
		int len = 0;
		while (list != null) {
			len ++;
			list = list.next;
		}
		return len;
	}

}
