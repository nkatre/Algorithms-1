enum color {
	RED,
	BLACK;
}

class Node {
	int info;
	color color;
	Node parent;
	Node left;
	Node right;
}

public class RedBlackTree {
	
	public void rbInsert(Node root, int key) {
		Node x = bstInsert(root, key);
		while(x.parent.color == color.RED && x != null) {
			if(x.parent = x.parent.parent.left) {
				Node y = x.parent.parent.right;
				if(y.color == color.RED) {
					y.color = color.BLACK;
					x.parent.color = color.BLACK;
					x.parent.parent.color = RED;
					x = x.parent.parent;
				} else if(x = x.parent.right) {
					x = x.parent;
					leftRotate(root, x)
				}
				rightRotate(root, x.parent.parent);
			}
		}
		root.color = color.BLACK;
	}
}
