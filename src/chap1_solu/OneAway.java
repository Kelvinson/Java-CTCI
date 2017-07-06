package chap1_solu;
public class OneAway {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "pales";
		String s2 = "pale";
		System.out.println(isOneEditAway(s1, s2));
	}

	public static boolean isOneEditAway(String s1, String s2) {
		int a = s1.length();
		int b = s2.length();
		if (a == b) {
			return isOneCharacterReplace(s1, s2);
		} else if (a + 1 == b) {
			return isOneDiffer(s2, s1);
		} else if (a - 1 == b) {
			return isOneDiffer(s1, s2);
		} else {
			return false;
		}

	}

	public static boolean isOneDiffer_V2(String longer, String shorter) {
		int i = 0;
		int j = 0;
		for (; i < longer.length() && j < shorter.length();) {
			if (longer.charAt(i++) != shorter.charAt(j++)) {
				if (i != j) {
					return false;
				} else {
					i++;
				}
			} else {
				i++;
				j++;
			}
		}
		return true;
	}

	public static boolean isOneDiffer(String longer, String shorter) {
		char[] arr_longer = longer.toCharArray();
		char[] arr_shorter = shorter.toCharArray();
		int len = arr_shorter.length;
		boolean moreThanOne = false;
		for (int i = 0, j = 0; i < len;) {
			if (arr_shorter[i++] != arr_longer[j++]) {
				if (moreThanOne == true) {
					return false;
				} else {
					moreThanOne = true;
					j++;
				}
			} else {
				i++;
				j++;
			}
		}
		return true;
	}

	public static boolean isOneCharacterReplace(String s1, String s2) {
		char[] s1_arr = s1.toCharArray();
		char[] s2_arr = s2.toCharArray();
		int len = s1_arr.length;
		boolean moreThanOne = false;
		for (int i = 0, j = 0; i < len;) {
			if (s1_arr[i++] != s2_arr[j++]) {
				if (moreThanOne == true) {
					return false;
				} else {
					moreThanOne = true;
				}
			}
		}
		return true;
	}
}
