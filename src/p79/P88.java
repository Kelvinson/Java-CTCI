package p79;

import java.util.ArrayList;

public class P88 {
	
	
	ArrayList<String> merge(String[] words, String[] more){
	ArrayList<String> sentence  = new ArrayList<String>();
	for (String w: words) sentence.add(w);
	for (String w: more) sentence.add(w);
	return sentence;
	}
	
	// Using stringBuilder to concatenate strings
	String joinWords(String[] words) {
		String sentence = "";
		for (String w : words) {
			sentence = sentence + w;
		}
		return sentence;
	}
	
	String joinWordsBuilder(String[] words) {
		StringBuilder sentence = new StringBuilder();
		for (String word : words) {
			sentence.append(word);
		}
		return sentence.toString();
	}
	
	
}
