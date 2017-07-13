package chap3_solu;

import java.util.Stack;

public class Solu_stackWithMin {

	public static void main(String[] args) {
		StackWithMin2 stackMin = null;
		stackMin.push(3);
		stackMin.push(5);
		System.out.println(stackMin.min());

	}
	
	public class StackWithMin2 extends Stack<Integer> {
		Stack<Integer> s2;
		public StackWithMin2() {
			s2 = new Stack<Integer>();
		}
		
		public void push(int value) {
			if (value <= min()) {
				s2.push(value);
			}
			super.push(value);
		}
		
		public Integer pop() {
			int value = super.pop();
			if (value == min()) {
				s2.pop();
			}
			return value;
		}
		
		public int min() {
			if (s2.isEmpty()) {
				return Integer.MAX_VALUE;
			} else {
				return s2.peek();
			}
		}
	}

}
