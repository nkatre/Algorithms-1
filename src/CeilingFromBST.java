
public class CeilingFromBST {
	
	public static TreeNode recursive(TreeNode current, int key) throws Exception {
		
		if(current == null) {
			throw new Exception("Something terrible happened");
		}
		
		if(current.info == key) {
			return current;
		} else if (current.info < key) {
			return recursive(current.right, key);
		} else {
			TreeNode candidate =  recursive(current.left, key);
			return candidate.info > current.info ? candidate : current;
		}
		
	}

	public static void main(String[] args) {
		
	}

}

class TreeNode {
	
	public TreeNode(int info) {
		this.left = null;
		this.info = info;
		this.right = null;
	}
	
	public TreeNode(int info, TreeNode left, TreeNode right) {
		this.info = info;
		this.left = left;
		this.right = right;
	}
	
	int info;
	TreeNode left;
	TreeNode right;
}
