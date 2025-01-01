package graphs;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 
 * main function that sets up the algorithm and gets inputs for the letters on the board and
 * any commands
 * 
 * @author jfr11
 *
 */

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		WordPaths paths = new WordPaths();
		Graph theBoard = new Graph();
		Scanner sc = new Scanner(System.in);
		// nested loop to input all the letters
		for(int r = 0; r < theBoard.getGraph().length; r++) {
			for(int c = 0; c < theBoard.getGraph()[r].length; c++) {
				System.out.println("Enter letter at " + r + " " + c);
				String letter = sc.nextLine();
				while(true){
					letter = letter.toLowerCase();
					if((letter.matches("[a-zA-Z]") && (! letter.equals("q")))
							|| letter.equals("qu")) {
						break;
					}
					System.out.println("Try Again");
					letter = sc.nextLine();
				}
				Vertex curr = new Vertex(r, c, letter);
				theBoard.addVertex(curr);
			}
		}
		theBoard.completeGraph();
		// prints graph to ensure it is correct
		System.out.print(theBoard.toString());
		// searches words from each vertex
		for(int r = 0; r < theBoard.getGraph().length; r++) {
			for(int c = 0; c < theBoard.getGraph()[r].length; c++) {
				paths.searchWords(theBoard.getGraph()[r][c]);
			}
		}
		HashSet<String> words = paths.getWords();
		// TreeMap to have alphabetically ordered words with their associated points
		TreeMap<String, Integer> ordered = new TreeMap<>();
		int score;
		for(String s : words) {
			if(s.length() == 3 || s.length() == 4) {
				score = 1;
			} else if(s.length() == 5) {
				score = 2;
			} else if(s.length() == 6) {
				score = 3;
			} else if(s.length() == 7) {
				score = 5;
			} else {
				score = 8;
			}
			ordered.put(s, score);
		}
		System.out.println(ordered.size() + " words");
		System.out.println(ordered);
		System.out.println("search word");
		System.out.println("type !end to stop program");
		while(true) {
			String word = sc.nextLine();
			word = word.toLowerCase();
			if(word.equals("!end")) {
				System.out.println("ending program");
				break;
			} else if(words.contains(word)) {
				System.out.println("Yes that is a word worth " + ordered.get(word) + " point(s)");
			} else if(paths.getFuncs().isWord(word)) {
				System.out.println("nope, not possible to get");
			} else {
				System.out.println("nope, not a word");
			}
		}
		sc.close();
	}
}
