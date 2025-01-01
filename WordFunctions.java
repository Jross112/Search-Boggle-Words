package graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 
 * Has 2 important functions, isWord and possiblePath, and a constructor that makes
 * scans a text file of a dictionary and makes two HashSets to enable the two functions
 * 
 * isWord searches a HashSet of all the words in the dictionary
 * 
 * possiblePath searches a HashSet full of parts of words.
 * 
 * @author jfr11
 *
 */

public class WordFunctions {
	
	private HashSet<String> words;
	private HashSet<String> paths;
	
	public WordFunctions() throws FileNotFoundException {
		words = new HashSet<>();  // HashSet for full words
		paths = new HashSet<>();  // HashSet for parts of words
		File dictionary = new File("Dictionary.txt");  // the chosen dictionary of choice
		Scanner sc = new Scanner(dictionary);
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			for(int i = 1; i < s.length(); i++ ) {  // loop puts all parts of the word in paths
				paths.add(s.substring(0, i));
			}
			words.add(s);
		}
		sc.close();
	}
	
	public boolean isWord(String s) {
		return words.contains(s);
	}
	
	public boolean possiblePath(String s) {
		return paths.contains(s);
	}
	
}
