package chap1_solu;

public class IsUnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ascdhb";
		System.out.println(isUniqueChars_2(s));
	}
	
	/**
	 * Note ASCII contains 128 charsets whereas UNICODE contains 2^21 charsets
	 * @param str
	 * @return whether the str contains unique charsets
	 */
	static boolean isUniqueChars(String str) {
		// according to the bucket theorem or the pigeon theorem, when the 
		// string contains more chars than the char set does. there must be
		// duplicate characters
		if (str.length() > 128 ) return false;
		
		// else we set up a boolean array representing the charactes in the ASCII 
		// charset has already appeared once in the string .
		boolean [] charset = new boolean[128];
		
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (charset[val]) return false;
			charset[val] = true;
		}
		return false;
	}
	
	static boolean isUniqueChars_2(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			
			if ((1<<val & checker) > 0) { return false;}
			else { checker |= 1<<val;}
		}
		return true;
	}
}
