package graphs;

import java.util.HashSet;

/**
 * 
 * vertex class for each letter on the boggle board, has its coordinates
 * its letter and the surrounding vertexes
 * 
 * @author jfr11
 *
 */

public class Vertex {
	
	private int x, y;
	private String letter;
	private HashSet<Vertex> neighbors;
	
	public Vertex() {
		x = 0;
		y = 0;
		letter = "";
		neighbors = new HashSet<>();
	}
	
	public Vertex(int m, int n, String let) {
		x = m;
		y = n;
		letter = let;
		neighbors = new HashSet<>();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(! (obj instanceof Vertex)) {
			return false;
		}
		Vertex other = (Vertex)obj;
		if(x == other.x && y == other.y && letter.equals(other.letter)) {
			return true;
		}
		return false;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String getLetter() {
		return letter;
	}
	
	public HashSet<Vertex> getNeighbors(){
		return neighbors;
	}
	
	public void setX(int val) {
		x = val;
	}
	
	public void setY(int val) {
		y = val;
	}
	
	public void setLetter(String let) {
		letter = let;
	}
	
	public void addNeighbor(Vertex v) {
		neighbors.add(v);
	}
	
	@Override
	public String toString() {
		return "" + x + " " + y + " " + letter;
	}
}
