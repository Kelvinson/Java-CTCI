package chap1_solu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.RowFilter.Entry;

public class URLify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "   hdd  kdh ";
		URLify(s);
		
	}
	
	public static void URLify(String s) {
		String URLified;
		if (s == "") return ;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		boolean is_First = true;
		char[] s_arr = s.toCharArray();
		int i = 0;
		while (i < s_arr.length) {
			while (is_First == true && s_arr[i] == ' ' ) i++;
			int first = i;
			is_First = false;
			while(is_First == false && s_arr[i] != ' ') i++;
			int last = i;
			hm.put(first, last);
			is_First = true;
		}
		
/*		Set<Map.Entry<Integer,Integer>> entrySet = hm.entrySet();
		Iterator<java.util.Map.Entry<Integer, Integer>> it = entrySet.iterator();
		
		while (it.hasNext()) {
			Entry<Integer, Integer> en = it.next();
			int first = (int)en.getKey();
			int second  = (int)en.getKey
		}*/
		
		for (Integer key : hm.keySet()) {
			System.out.println(key + " " + hm.get(key));
		}	
	}
}
