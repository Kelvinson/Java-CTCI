/*package chap3_solu;

public class Solu_threeStackDivision {

}

class FixedMultiStack {
	private int numberOfStacks = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;
	
	public FixedMultiStack(int stackSize) {
		stackCapacity = stackSize;
		values = new int[stackSize * numberOfStacks];
		sizes = new int[numberOfStacks];
	}
	
	 push value onto stack 
	public void push(int stackNum, int value) throws FullStackException {
		 check that we have space for the next element 
		if (isFull(stackNum)) {
			throw new FullStackException();
		}
		 Increment stack pointer and then update top value 
		sizes[stackNum]++;
		values[indexOfTop(stackNum) = value];
	}
	
	 Pop item from top stack 
	public int pop(int stackNum) {
		if (isEmpty(stackNum) {
			throw new EmptyStackException();
		}
		
		int topIndex = indexOfTop(stackNum);
		int value = values[topIndex];// Get top
		values[topIndex] = 0; // Clear
		sizes[stackNum]--// shrink
		return value;
	}
	
	 Return top element 
	public int peek(int stackNum) {
		if (isEmpty(stackNum) {
			throw new EmptyStackException();
		}
		return values[indexOfTop(stackNum)];	
	}
	
	 Return if stack is empty 
	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0 ;
	}
	*//** Return if stack is full *//*
	
	public boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}
	
	 Return index of the top of the stack 
	private int indexOfTop(int stackNum) {
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size -1;
	}
}


public class MultiStack {
	private class ClassInfo {
		 StackInfo is a simple class that holds a set of data about each stack. 
		public int start, size, capacity;
		public StackInfo(int start, int capacity) {
			this.start = start;
			this.capacity = capacity;
		}
		
		public boolean isWithinStackCapacity(int index) {
			 If outside of bounds of array, return false 
			if (index < 0 || index >= values.length) {
				return false;
			}
			 If index wraps around, adjust it 
			int contiguousIndex = index < start? index + values.length: index;
		}
		
		
	}
}*/