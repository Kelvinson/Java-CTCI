package test;
import static org.junit.Assert.*;

import org.junit.Before;
//import chap1_solu.CheckStringRotation;
import org.junit.Test;
import org.junit.After;


public class testPart_Rotation {

	@Before 
	public void setUp() {
		System.out.println("test begins...");
	}
	@Test
	public void test() {
		
		String s1 = "waterbottle";
		String s2 = "lewaterbott";
		assertEquals(true,isPart_Rotation(s1.toCharArray(),s2.toCharArray(),9));	
//		String s3 = "aab";
//		String s4 = "baa";
//		assertEquals(true,isPart_Rotation(s3.toCharArray(),s4.toCharArray(),2));
//		fail("Not yet implemented");
	}
	
/*	public void test1() {
		
////		String s1 = "waterbottle";
////		String s2 = "lewaterbott";
////		assertEquals(true,isPart_Rotation(s1.toCharArray(),s2.toCharArray(),9));	
//		String s3 = "aab";
		String s4 = "baa";
		assertEquals(true,isPart_Rotation(s3.toCharArray(),s4.toCharArray(),2));
//		fail("Not yet implemented");
	｝*/
	
	
	/**
	 * <p> This function checkes whether the part of string s1 
	 * <p> which begins from  index are the part begains from 
	 * <p> index 0 of string s2. This is the main part of the 
	 * <p> the check function of isRotation.
	 * @param s1
	 * @param s2
	 * @param index
	 * @return
	 */
	public static boolean isPart_Rotation(char[] s1, char[] s2, int index) {
		for (int i = index,j = 0; i < s1.length; i++) {
			if (s1[i++] != s2[j++] ) { return false; }
			if (i == s1.length - 1) { return true;}
		}
		return true;
	}
	
	@After
    public void tearDown() {
		System.out.println("test finished:------");
	}

}
