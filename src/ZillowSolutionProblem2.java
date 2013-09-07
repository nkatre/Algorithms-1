/**
 * PROBLEM 2:
 * 
 * Assumption:
 * 
 * We assume that we already have a class 'Node' to represent each node in the trinary tree.
 * The class contains the following fields: info, left, middle and right.
 * 
 * @author shubham
 *
 */

public class TrinaryTree {
	
	/**
	 * @param currentNode - starts with the root node of the trinary tree
	 * @param value - value to be deleted from the trinary tree
	 * @return - returns the node that was deleted
	 */
	public Node delete(Node currentNode, int value)
	{
		// If the current node is less than the value to be deleted, then search in the left child
		if (currentNode.info > value)
		{
			currentNode.left = Delete(currentNode.left, value);
		}
		
		// If the current node is greater than the value to be deleted, then search in the right child
		else if(currentNode.info < value)
		{
			currentNode.right = Delete(currentNode.right, value);
		}
		// otherwise...
		else
		{
			// If currentNode's middle is not null, then call this function recursuvely on the middle child
			if (currentNode.middle != null)
			{
				currentNode.middle = Delete(currentNode.middle, value);
			}
			// If the right child exists, find the smallest element from the right child, and delete it
			else if(currentNode.right != null)
			{
				int min = minimum(currentNode.right).value;
				currentNode.info = min;
				currentNode.right = Delete(currentNode.right, min);
			}
			// else, jstu update current node...
			else
			{
				currentNode = currentNode.left;
			}
		}
		return currentNode;
	}

	/**
	 * Inserts a node with key 'key' to the tree and returns 
	 * a reference to the node just added. 
	 * @param currentNode
	 * @param key
	 * @return
	 */
	public Node insert(Node root, int key) {
		
		Node currentNode = root;
		Node newNode = new Node(key);
		if(currentNode == null) {
			return newNode;
		} else if(key < currentNode.info) {
			currentNode.left = insert(currentNode.left, key);
		} else if (key == currentNode.info) {
			currentNode.middle = insert(currentNode.middle, key) ;
		} else {
			currentNode.right = insert(currentNode.right, key);
		}
	}
}
