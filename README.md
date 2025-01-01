This projects takes a user input of a boggle board and a dictionary.txt and finds all the valid words on the board that are in the dictionary.
The input is turned into a graph with vertices, each vertex being a letter or "qu" as it is in the boggle game.

Then the class, WordPaths, is created and runs with the given graph and finds all the possible words using a recursive Depth-first-search

The class WordFunctions takes the given dictionary and creates a HashSet of the valid words and a HashSet of the possible words, these are used in
WordPath to find all the words.

Finally the Main method after taking in the board outputs all the valid words in alphabetical order and allows the user to search if a word is valid
