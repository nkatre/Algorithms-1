import java.util.ArrayList;
import java.util.List;


enum Color {
	BLACK,
	WHITE,
	GRAY;
}

public class BFS {

	private Color[] color; // WHITE or BLACK
	private int[] d;
	private int[] pi;
	private int[][] G;
	private QueueUsingList queue;

	public BFS(int nodeCountInGraph) {
		color = new Color[nodeCountInGraph];
		d = new int[nodeCountInGraph];
		pi = new int[nodeCountInGraph];
		G = new int[nodeCountInGraph][nodeCountInGraph]; // initialize the graph
		queue = new QueueUsingList();
	}

	void search(int[][] G, int s) throws Exception {
		for(int u=0; u<G.length; u++) {
			color[u] = Color.WHITE;
			d[u] = Integer.MAX_VALUE;
			pi[u] = Integer.MIN_VALUE;			
		}
		color[s] = Color.GRAY;
		d[s] = 0;
		pi[s] = s;

		queue.enqueue(s);
		while(!queue.isEmpty()) {
			int u = queue.dequeue();
			for(int v : adj(u)) {
				if(color[v] == Color.WHITE) {
					queue.enqueue(v);
					color[v] = Color.GRAY;
					d[v] = d[u] + 1;
					pi[v] = u;
				}
			}
			color[u] = Color.BLACK;
		}
	}

	private List<Integer> adj(int u) {
		List<Integer> adjResult = new ArrayList<Integer> ();
		for(int i=0; i<G.length; i++) {
			if(G[u][i] == 1) {
				adjResult.add(i);
			}
		}
		return adjResult;
	}
	
	public int getNthMaxNumber(Node root, int n) {
		if(root == null) {
			// throw exception
		}
		if()
	}

}




