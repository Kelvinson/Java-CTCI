package chap1_solu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {

	public static void main(String[] args) {
		String s = "totcccoaa";
		System.out.println(isPalindromePermutation(s));
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

}
