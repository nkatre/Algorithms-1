import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Edge implements Comparable<Edge> {
	int u;
	int v;
	int w;

	@Override
	public int compareTo(Edge edge) {
		return this.w - edge.w;
	}
}

public class Kruskal {

	Set<Edge> result;
	Map<Integer, Set<Integer>> vertexToSet;
	
	Set<Edge> getMst(List<Integer> vertices, List<Edge> edges) {
		result = new HashSet<Edge>();
		vertexToSet = new HashMap<Integer, Set<Integer>>();
		
		// Make set consisting of each vertex
		for(int vertex : vertices) {
			Set<Integer> s = new HashSet<Integer>();
			s.add(vertex);
			vertexToSet.put(vertex, s);
		}
		
		// sort edges in increasing order by weight
		Collections.sort(edges);
		
		for(Edge edge : edges) {
			Integer startVertex = edge.u;
			Integer endVertex = edge.v;
			
			if(findSet(startVertex) != findSet(endVertex)) {
				result.add(edge);
				Set<Integer> mergedSet = findSet(startVertex);
				mergedSet.addAll(findSet(endVertex));
				vertexToSet.put(startVertex, mergedSet);
				vertexToSet.put(endVertex, mergedSet);
			}
			
		}
		return result;
	}
	
	Set<Integer> findSet(int v) {
		return vertexToSet.get(v);
	}
}
