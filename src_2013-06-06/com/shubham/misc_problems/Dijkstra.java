package com.shubham.misc_problems;

import java.util.Queue;

/**
 * Single source shortest path
 * @author shubham
 *
 */
public class Dijkstra {
	
	/**
	 * NOTE: Dijkstra's assumes there are no negative weight cycles
	 * 
	 * @param G: Graph represented as a distance matrix
	 * @param d: d[u] represents the distance of node 'u' from source 's'
	 * @param s: source node from which the shortest path is to be calculated
	 */
	public void singleSourceShortestPath(int G[][], double d[], int s) {
		int n = G.length;
		for(int i = 0; i<n; i++) {
			d[i] = Double.POSITIVE_INFINITY;
		}
		
		Queue<E> priorityQueue = new priorityQueue();
		priorityQueue.addAll(d);
	}
	
}
