package p79;

import java.util.ArrayList;

public class Find_Cubic_Pairs {
	private static int n = 1000;
	public static void main(String[] args) {
		ArrayList<int []> arr = new ArrayList<int []>();		
		arr = Find_Cubic_Pais();
		for (int [] i : arr) {
			System.out.println(i);
		}

	}
	public static ArrayList<int []> Find_Cubic_Pais() {
		ArrayList<int []> result = new ArrayList<int []>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; i < n; j++) {
				for (int k = 0; k < n; k++) {
					int l = (int) Math.pow(i*i*i + j*j*j - k*k*k,1/3);
					if (i*i*i + j*j*j == k*k*k + l*l*l) {
						 int[] a= {i,j,k,l};
						 result.add(a);
					}
					
				}
			}
		}
		return result;
	}

}
