package chap1_solu;

import java.util.HashMap;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="aabcccccaae";
		System.out.println(stringCompression_continual(s));
	}
	
	public static String stringCompression_V1(String s) {
		HashMap<Character, Integer> hm = new HashMap<Character,Integer>();
		for (char c : s.toCharArray()  ) {
			if (hm.get(c) != null) {
				int val  = hm.get(c);
				hm.put(c,val+1);
			} else {
				hm.put(c,1);
			}
		}
		String concatenation= new String();
		for (Character c : hm.keySet()) {
			concatenation += c;
			concatenation += hm.get(c);
		}
		System.out.println(concatenation);
	  return concatenation.length() > s.length()? s: concatenation;	
	}
	
	public static String stringCompression_continual(String s) {
		String str = new String();
		char currentChar = s.charAt(0);
		int count = 1;
		
		for (int i = 1; i < s.length(); i++) {
			char previousChar = currentChar;
			currentChar = s.charAt(i);
			if (currentChar != previousChar) {
				/*str += previousChar;
				str += count;*/
				str += "" + previousChar + count;
				count = 1;
			} else {
				count ++;
			}
			if (i == s.length()-1) {
				str += "" + previousChar + count;
			}
		}
		return str;
	}
	

}
