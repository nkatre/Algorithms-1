import java.awt.Color;

public class DFS {
	
	private int[][] G;
	private int[] pi;
	private Color[] color;
	
	public DFS(int nodeCount) {
		G = new int[nodeCount][nodeCount];
		pi = new int[nodeCount];
		color = new Color[nodeCount];
	}
	
	void search() {
		for(int u=0; u<G.length; u++ ) {
			pi[u] = -99999;
			color[u] = Color.WHITE;
		}
		for(int u=0; u<G.length; u++ ) {
			if(color[u] != Color.BLACK) {
				dfsVisit(G, u);
			}
		}
	}
	
	void dfsVisit(int[][] G, int u) {
		for(int v=0; v<G.length; v++) {
			if(color[v] != Color.BLACK) {
				dfsVisit(G, v);
			}
		}
		color[u] = Color.BLACK;
	}
	
}
