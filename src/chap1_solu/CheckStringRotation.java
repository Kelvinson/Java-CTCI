package chap1_solu;

public class CheckStringRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "cab";
		String s2 = "abc";
		String s3 = "waterbottle";
		String s4 = "lewaterbott";

		System.out.println(isRotation(s3,s4));
	}
	
	/** 
	 *  <p> This function tests whether s1 and s2 are rotation strings.</p>
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length()) {	return false;}
		char[] arr_s1 = s1.toCharArray();
		char [] arr_s2 = s2.toCharArray();
		
		
		for (int i = 0; i < arr_s1.length; i++) {
			if (arr_s1[i] == arr_s2[0]) {
				if (isPart_Rotation(arr_s1,arr_s2,i) && 
					isPart_Rotation(arr_s2,arr_s1,arr_s1.length - i)) {
					return true;
				} 
				
				if (i == arr_s1.length - 1) {
					return false;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * <p> This function checkes whether the part of string s1 
	 * <p> which begins from  index are the part begains from 
	 * <p> index 0 of string s2. This is the main part of the 
	 * <p> the check function of isRotation.
	 * <b> I made fucking mistake here, I should not let index 
	 * <b> increment at the outer loop for in the iner loop 
	 * <b> it has already incremented itself, so if next time use
	 * <b> self increment in the inner loop but to be consistant 
	 * <b> with another pointer in the inner loop fuck delete it. 
	 * <b> so it is wrong writing this shit code 
	 * <b> for (int i = index,j = 0; i < s1.length; i++)
	 * @param s1
	 * @param s2
	 * @param index
	 * @return
	 */
	public static boolean isPart_Rotation(char[] s1, char[] s2, int index) {
		for (int i = index,j = 0; i < s1.length; ) {
			if (s1[i++] != s2[j++] ) { return false; }
			if (i == s1.length - 1) { return true;}
		}
		return true;
	}
	
	public static boolean isRotationEx(String str1, String str2) {  
        if (str1 == null || str2 == null || str1.length() != str2.length()) return false;  
        for (int offset = 0; offset < str1.length(); offset++) {  
            int i = 0;  
            for (i = 0; i < str2.length(); i++) {  
                if (str2.charAt(i) != str1.charAt((i + offset) % str2.length())) {  
                    break;  
                }  
            }  
            if (i == str2.length()) {  
                return true;  
            }  
        }  
        return false;  
    }  
	
	

}
