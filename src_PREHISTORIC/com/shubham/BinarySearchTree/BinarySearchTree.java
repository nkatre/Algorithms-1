package com.shubham.BinarySearchTree;

class Node {
	int info;
	Node left;
	Node right;
	
	public Node(Node left, int info, Node right) {
		this.left = left;
		this.info = info;
		this.right = right;
	}
}

public class BinarySearchTree {
	Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public void insert(Node root, int key) {
		if(root == null) {
			this.root = new Node(null, key, null);
		} else {
			if(root.info > key) {
				if(root.left == null) {
					root.left = new Node(null, key, null);
				} else {
					insert(root.left, key);
				}
			} else {
				if(root.right == null) {
					root.right = new Node(null, key, null);
				} else {
					insert(root.right, key);
				}
			}
		}
	}
	
	public void inorderTraversal(Node root) {
		if(root != null) {
			inorderTraversal(root.left);
			System.out.println(root.info);
			inorderTraversal(root.right);
		}
	}
	
	/**
	 * Find height of a tree
	 * @param root
	 * @return
	 */
	public int maxHeight(Node root) {
		if(root == null) {
			return 0;
		}
		int leftHeight = maxHeight(root.left);
		int rightHeight = maxHeight(root.right);
		return leftHeight > rightHeight? leftHeight + 1 : rightHeight + 1;
	}
	
	/**
	 * Create a mirror image of a Binary tree - WITHOUT creating a new tree
	 */
	public void mirror1(Node root) {
		if(root == null) {
			return;
		}
		
		Node tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		
		mirror1(root.left);
		mirror1(root.right);
	}
	
	/**
	 * Create a mirror image of a Binary tree - WITH creating a new tree
	 * http://stackoverflow.com/questions/4366251/mirror-image-of-a-binary-tree
	 */
	public Node mirror2(Node root) {
		if(root == null) {
			return null;
		}
		
		Node newNode = new Node(mirror2(root.right), root.info, mirror2(root.left));
		return newNode;
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(bst.root, 1);
		bst.insert(bst.root, 5);
		bst.insert(bst.root, -3);
		bst.insert(bst.root, 4);
		bst.insert(bst.root, 8);
		bst.inorderTraversal(bst.root);
	}
	
	/**
	 * Delete the Binary tree
	 */
	public static void deleteTree(Node root) {
		if(root == null) {
			return;
		}
		
		deleteTree(root.left);
		deleteTree(root.right);
		
		root = null;
	}
	
	/**
	 * Check if a binary tree is a BST: isBst()
	 */
	public static boolean isBst(Node root, int min, int max) {
		if(root == null) {
			return true;
		}
		
		if(root.info < min && root.info > max) {
			return false;
		}
		
		return isBst(root.left, min, root.info) && isBst(root.left, root.info, max); 
	}
	
	// Lowest Common Ancestor
	int LCA(Node root, int n1, int n2)
	{
	  /* If we have reached a leaf node or if one of the nodes (n1 or n2)
	     is the root, then LCA does not exist.
	  */
	  if(root==NULL || root->info==n1 || root->info==n2)
	    return -1;
	  
	  /* If one of the child node is n1 or n2 then the current node
	     is the LCA.
	  */
	  if(root->left!=NULL && (root->left->info==n1 || root->left->info==n2))
	    return root->info;
	  if(root->right!=NULL && (root->right->info==n1 || root->right->info==n2))
	    return root->info;
	    
	  /* If current node is less than n1 and n2 => current=current->right
	     If current node is greater than n1 and n2 => current=current->left
	     If current node lies between n1 and n2 current node is the LCA.
	  */
	  if(root->info<n1 && root->info<n2)
	    return LCA(root->right,n1,n2);
	  else if(root->info>n1 && root->info>n2)
	    return LCA(root->left,n1,n2);
	  else
	    return root->info;
	}

}



