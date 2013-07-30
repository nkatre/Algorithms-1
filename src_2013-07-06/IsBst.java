/**
 * Check if a BT is a BST
 * @author shubham
 * 
 */
public class IsBst {
	public boolean isBST(Node root, int low, int high) {
		if(root == null) {
			return true;
		}
		
		if(root.getInfo() < low || root.getInfo() > high) {
			return false;
		}
		
		return isBst(root.getLeft(), low, root.getInfo) && isBst(root.getRight(), root.getInfo(), high);
	}
	
}
