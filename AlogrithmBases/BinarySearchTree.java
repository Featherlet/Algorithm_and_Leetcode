
public class BinarySearchTree {
	private TreeNode root;
	
	public BinarySearchTree(){
		root = null;
	}
	
	public TreeNode find(int val){
		TreeNode tn = root;
		if(root == null)
			return null;		
		while(tn != null){
			if(tn.val == val)
				return tn;
			else if(tn.val > val)
				tn = tn.left;
			else
				tn = tn.right;
		}
		return null;
	}
	
	public boolean insertion(int val){
		if(root == null){
			root = new TreeNode(val);
			return true;
		}
		TreeNode current = root;
		TreeNode parent = null;
		while(true){
			parent = current;
			if(current.val > val){
				current = current.left;
				if(current == null){
					parent.left = new TreeNode(val);
					return true;
				}
			}else{
				current = current.right;
				if(current == null){
					parent.right = new TreeNode(val);
					return true;
				}
			}
		}
	}
	
	public TreeNode findMin(TreeNode tn){
		if(tn.left == null)
			return tn;
		else
			return findMin(tn.left);
	}
	
	public TreeNode findMax(TreeNode tn){
		if(tn.right == null)
			return tn;
		else
			return findMin(tn.right);
	}
	
	public boolean deletion(int val){
		TreeNode current = root;
		TreeNode parent = root;
		boolean isLeftChild = false;
		while(current != null && current.val != val){
			parent = current;
			if(current.val > val){
				current = current.left;
				isLeftChild = true;
			}else{
				current = current.right;
				isLeftChild = false;
			}
		}
		if(current == null)
			return false;
		
		//first condition
		if(current.left == null && current.right == null){
			if(current == root)
				root = null;
			if(isLeftChild)
				parent.left = null;
			else
				parent.right = null;
		}
		//second condition
		else if(current.left == null){
			if(isLeftChild)
				parent.left = current.right;
			else
				parent.right  = current.right;
		}else if(current.right == null){
			if(isLeftChild)
				parent.left = current.left;
			else
				parent.right  = current.left;
		}
		//third condition with two child
		else{
			TreeNode rmin = findMin(current.right);
			if(isLeftChild)
				parent.left = rmin;
			else
				parent.right = rmin;
			rmin.left = current.left;
		}
		return true;
	}
}
