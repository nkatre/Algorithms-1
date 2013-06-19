package com.shubham.search;

import java.util.List;
import java.util.Map;

import com.shubham.ds.QueueUsingLinkedList;

enum Color {
	WHITE,
	GRAY,
	BLACK
}

public class BFS {
	
	private int[][] G;
	private Color[] color;
	private int[] distance;
	
	public BFS(int vertexCount) {
		G = new int[vertexCount][vertexCount];
		color = new Color[vertexCount];
		distance = new int[vertexCount];
	}
	
	/*
	 * Graph, G, is represented as adjacency matrix
	 * s is the start node from which BFS has to start
	 */
	void search(int[][] G, int s) {
		QueueUsingLinkedList queue;
		for(int i=0; i<G.length; i++) {
			distance[i] = 0;
			color[i] = Color.WHITE;
			queue = new QueueUsingLinkedList();
		}
		
		color[s] = Color.GRAY;
		queue.enqueue(s);
		
		while(!queue.isEmpty()) {
			int u = queue.dequeue();
			for(int v : adj(u)) {
				if(color[v] == Color.WHITE) {
					color[v] = Color.GRAY;
					distance[v] = distance[u] + 1;
					queue.enqueue(v);
				}
			}
			color[u] = Color.BLACK;
		}
		
		
	}
}





