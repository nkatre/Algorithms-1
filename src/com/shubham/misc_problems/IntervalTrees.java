package com.shubham.misc_problems;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

class Node {
	Point point;
	int maxValueOfEndPoint; // maximum value of any interval end point under the current node
	Node left;
	Node right;
}

public class IntervalTrees {
	private List<Point> intersectingPoints;
	
	public IntervalTrees() {
		intersectingPoints = new ArrayList<Point>();
	}
	
	/**
	 * Find all intervals intersecting with the given interval
	 * 
	 * Quoting from CLRS:
	 * ------------------
	 * Use a simple ordered tree, for example a binary search tree or self-balancing binary search tree, where the tree is
	 * ordered by the 'low' values of the intervals, and an extra annotation is added to every node recording the maximum high value of both its subtrees.
	 * It is simple to maintain this attribute in only O(h) steps during each addition or removal of a node, where h is the height of the node added or
	 * removed in the tree, by updating all ancestors of the node from the bottom up. Additionally, the tree rotations used
	 * during insertion and deletion may require updating the high value of the affected nodes.
	 * 
	 * Now, it is known that two intervals A and B overlap only when both A.low ≤ B.high and A.high ≥ B.low. When searching the trees for nodes overlapping with a given interval, you can immediately skip:
	 * 1. All nodes to the right of nodes whose low value is past the end of the given interval.
	 * 2. All nodes that have their maximum 'high' value below the start of the given interval.
	 * 
	 * Wiki: http://en.wikipedia.org/wiki/Interval_tree
	 * 
	 */
	void getIntersectingIntervals(Node root, Point candidatePoint) {
		if(root == null) {
			return;
		}
		
		if(root.maxValueOfEndPoint < candidatePoint.getX()) {
			return; //getIntersectingIntervals(root.right, candidatePoint);
		}
		if(root.point.getX() > candidatePoint.getY()) {
			return;
		}
		
		if(root.left != null) {
			getIntersectingIntervals(root.left, candidatePoint);
		}
		if(root.right != null) {
			getIntersectingIntervals(root.right, candidatePoint);
		}
		
		// check this node
		if(root.contains(candidatePoint)) { // contains defines the intersection criteria
			intersectingPoints.add(new Point(root.point));
		}
		
		
	}
}
