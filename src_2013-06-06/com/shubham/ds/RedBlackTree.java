package com.shubham.ds;

public class RedBlackTree {
	
	void redBlackInsert(T, x) {
		bstInsert(T, x);
		color[x] = RED;
		while(T != root && color[p(x)] == RED) {
			if(p[x] == left(p[p[x]])) {
				y = right(p[p[x]]);
				if(color[y] == RED) {
					CASE_1; // follow from book
				} else if(x == right(p[x])) {
					CASE_2; // follow from book
				}
				CASE_3; // follow from book
			} else {
				// do everything as before by replacing 'left' and 'right'
			}
		}
		color[ROOT] = BLACK;
	}
}
