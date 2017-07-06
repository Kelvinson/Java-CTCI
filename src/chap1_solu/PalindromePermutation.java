package chap1_solu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {

	public static void main(String[] args) {
		String s = "taat";
		System.out.println(isPalindromePermutation_Mcdowell(s));
	}

	public static boolean isPalindromePermutation(String s) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Integer cnt = hm.get(c);
			if (cnt == null) {
				cnt = new Integer(0);
			}
			hm.put(c, ++cnt);
		}

		boolean hasOdd = false;
		for (Character c : hm.keySet()) {
			if (hm.get(c) % 2 == 1) {
				if (!hasOdd) {
					hasOdd = true;
				} else {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean isPalindromePermutation_Set(String s) {
		Set<Character> set = new HashSet<Character>();
		for (int i =0; i < s.length(); i++) {
			if (set.contains(s.charAt(i))) {
				set.remove(s.charAt(i));
			} else {
				set.add(s.charAt(i));
			}
		}
		return set.size() <= 1;
	}
	
	public static int bitVectorize(String s) {
		int bitChecker = 0;
		char[] s_arr = s.toCharArray();
		for ( char c : s_arr) {
			bitChecker = toggleBitChecker(bitChecker,getValue(c));
		}
		return bitChecker;
	}
	
	public static boolean noMoreThanOneZero(int i) {
		if (i ==0 || hasOneZero(i)) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean hasOneZero(int i) {
		int mask = i - 1;
		return ((mask & i) == 0); 
	}
	
	public static boolean isPalindromePermutation_Mcdowell(String s) {
		int bitChecker = bitVectorize(s);
		return noMoreThanOneZero(bitChecker);
	}
	
	public static int toggleBitChecker(int bitChecker,int index) {
		if (index < 0) { return bitChecker;}
		int mask = 1 << index;
		if ((mask & bitChecker) > 0) {
			bitChecker &= ~mask;
		}
		else {
			bitChecker |= mask;
		}
		return bitChecker;
	}
	
	public static int getValue(char c) {
		int value = c - 'a';
		return value;
	}

}
