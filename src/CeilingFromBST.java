
public class CeilingFromBST {
	
	public static int recursive(TreeNode current, int key) throws Exception {
	    System.out.println("Current: " + current.info);
		if(current == null) {
		    //throw new Exception("Something terrible happened");
		    return -1;
		}
		
		if(current.info == key) {
			return current.info;
		}
		
		if (current.info < key) {
			return recursive(current.right, key);
		}

		System.out.println("here---------");
		int ceil =  recursive(current.left, key);
		System.out.println("ceil: " + ceil);
		
		return ceil >= key ? ceil : current.info;
		
		
	}

	public static void main(String[] args) throws Exception {
	    TreeNode root = new TreeNode(8);
	    TreeNode six = new TreeNode(6);
	    TreeNode twelve = new TreeNode(12);
	    TreeNode two = new TreeNode(2);
	    TreeNode four = new TreeNode(4);
	    TreeNode eleven = new TreeNode(11);
	    TreeNode fourteen = new TreeNode(14);
	    
	    root.left = six;
	    six.left = two;
	    six.right = four;
	    
	    root.right = twelve;
	    twelve.left = eleven;
	    twelve.right = fourteen;

	    int tn = CeilingFromBST.recursive(root, 1);
	    System.out.println("Ceiling is: " + tn);
	    
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
