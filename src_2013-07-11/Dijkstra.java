import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
	
	private int[][]G;
	private int[][] w;
	private int[] d;
	private List<Integer> shortestPath;
	
	public Dijkstra(int vertexCount) {
		G = new int[vertexCount][vertexCount];
		w = new int[vertexCount][vertexCount];
		d = new int[vertexCount];
		shortestPath = new ArrayList<Integer>();
	}
	
	void singleSourceShortestPath(int[][] G, int[][] w, int s) {
		for(int u=0; u<G.length; u++) {
			d[u] = (int) Double.POSITIVE_INFINITY;
		}
		d[s] = 0;
		
		// insert all vertices in priority queue
		PriorityQueue queue = new PriorityQueue();
		for(int u=0; u<G.length; u++) {
			queue.insert(u,d[u]); // syntax: insert(node, key)
		}
		
		while(!isEmpty(queue)) {
			int u = queue.extractMin();
			shortestPath.add(u);
			for(int v : adj(u)) {
				relax(u, v, w);
				queue.decreaseKey(v, d[v]);
			}
		}
	}
	
	void relax(int u, int v, int[][] w) {
		if(d[v] > d[u] + w[u][v]) {
			d[v] = d[u] + w[u][v];
		}
	}
	
	private List<Integer> adj(int u) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i< G.length; i++) {
			if(G[u][i] == 1) {
				list.add(i);
			}
		}
		return list;
	}
}
