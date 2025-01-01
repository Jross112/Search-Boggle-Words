package graphs;

/**
 * 
 * Sets up the boggle board, adds each vertex and their coordinates then
 * use the completeGraph method to add all the neighbors to each vertex
 * 
 * @author jfr11
 *
 */

public class Graph {
	
	private Vertex[][] theGraph;
	
	public Graph() {
		theGraph = new Vertex[4][4];
	}
	
	public void addVertex(Vertex v) {
		theGraph[v.getX()][v.getY()] = v;		
	}
	
	// adds all the neighbors for each vertex
	public void completeGraph() {
		for(int r = 0; r < theGraph.length; r++) {
			for(int c = 0; c < theGraph[r].length; c++) {
				Vertex curr = theGraph[r][c];
				if(r - 1 >= 0) {
					curr.addNeighbor(theGraph[r-1][c]);
					if(c - 1 >= 0) {
						curr.addNeighbor(theGraph[r-1][c-1]);
					}
					if(c + 1 < theGraph[r-1].length) {
						curr.addNeighbor(theGraph[r-1][c+1]);
					}
				}
				if(c - 1 >= 0) {
					curr.addNeighbor(theGraph[r][c-1]);
				}
				if(c + 1 < theGraph[r].length) {
					curr.addNeighbor(theGraph[r][c+1]);
				}
				if(r + 1 < theGraph.length) {
					curr.addNeighbor(theGraph[r+1][c]);
					if(c - 1 >= 0) {
						curr.addNeighbor(theGraph[r+1][c-1]);
					}
					if(c + 1 < theGraph[r].length) {
						curr.addNeighbor(theGraph[r+1][c+1]);
					}
				}
			}
		}
	}
	
	public Vertex[][] getGraph(){
		return theGraph;
	}
	
	@Override
	public String toString() {
		String res = "";
		for(int r = 0; r < theGraph.length; r ++) {
			for(int c = 0; c < theGraph[r].length; c ++) {
				res += theGraph[r][c].getLetter() + " ";
			}
			res += "\n";
		}
		return res;
	}
	
}
