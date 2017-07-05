package chap1_solu;
import java.util.Arrays.*;
public class Check_Permutations {

	public static void main(String[] args) {
		String  s = "ca";
		String t = "ac";
	   System.out.println(isPermutation1(s,t));

	}
	
	public static boolean isPermutations(String s, String t) {
		if (s.length() != t.length()) return false;
		System.out.println(sort(s)+"   "+sort(t));
		return sort(s).equals(sort(t));
	}
	
	public static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
	
	public static boolean isPermutation1(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int [] arr = new int[128];
		char [] s_array = s.toCharArray();
		for (char c : s_array) {
			arr[c]++;
		}
		
		char [] t_array = t.toCharArray();
		for (char c : t_array) {
			arr[c]--;
			if (arr[c] < 0) {
				return false;
			}
		}
		return true;
	}
}
