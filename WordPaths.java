package graphs;

import java.util.HashSet;
import java.io.FileNotFoundException;

/**
 * 
 * class for the search algorithm, contains a HashSet of words that has all of the
 * possible words in the given boggle board, and a WordFuncs to use in the algorithm
 * 
 * @author jfr11
 *
 */

public class WordPaths {

	private HashSet<String> words;
	private WordFunctions funcs;
	
	public WordPaths() throws FileNotFoundException {
		words = new HashSet<String>();
		funcs = new WordFunctions();
	}
	
	// searchWords algorithm that uses recursion
	public void searchWords(Vertex start) {
		String word = "";
		HashSet<Vertex> prev = new HashSet<>();
		searchWordsHelper(start, word, prev);
	}
	
	// helper function for the recursive algorithm, main optimization is ignoring paths with no
	// possible words
	private void searchWordsHelper(Vertex curr, String word, HashSet<Vertex> prev) {
		word += curr.getLetter(); // adds the current letter to the current word
		prev.add(curr);           // adds to the prev HashSet to prevent revisiting
		if(word.length() > 2 && funcs.isWord(word) && ! words.contains(word)) {
			words.add(word);
		}
		if(funcs.possiblePath(word)) { // skips paths if there are no possible words
			for(Vertex v : curr.getNeighbors()) {
				if(! prev.contains(v)) {
					searchWordsHelper(v, word, prev);
				}
			}
		}
		prev.remove(curr);
		word = word.substring(0, word.length()-1);
	}
	
	public HashSet<String> getWords(){
		return words;
	}
	
	public WordFunctions getFuncs() {
		return funcs;
	}
}
