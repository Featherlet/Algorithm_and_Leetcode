import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution101 {
	//By recursion
	public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
        	return true;
        else if(root.left == null || root.right == null)
        	return false;
        else
        	return checkChildren(root.left, root.right);
    }
	
	public boolean checkChildren(TreeNode lnode, TreeNode rnode){
		if(lnode == null || rnode == null)
			return lnode == rnode;
		if(lnode.val != rnode.val)
			return false;
		return checkChildren(lnode.left, rnode.right) && checkChildren(lnode.right, rnode.left);
	}
	
	
	//Without recursion
	public boolean isSymmetric2(TreeNode root){
		if(root == null || (root.left == null && root.right == null))
        	return true;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root.left != null){
			if(root.right == null)
				return false;
			stack.push(root.left);
			stack.push(root.right);
		}else if(root.right != null)
			return false;
		
		while(!stack.isEmpty()){
		    if(stack.size() % 2 != 0)
		        return false;
		    TreeNode lnode = stack.pop();
		    TreeNode rnode = stack.pop();
		    if(lnode.val != rnode.val)
		        return false;
		        
		    if(lnode.left != null){
		        if(rnode.right == null)
		            return false;
		        stack.push(lnode.left);
		        stack.push(rnode.right);
		    }else if(rnode.right != null)
		        return false;
		        
		    if(lnode.right != null){
		        if(rnode.left == null)
		            return false;
		        stack.push(lnode.right);
		        stack.push(rnode.left);
		    }else if(rnode.left != null)
		        return false;
		}
		return true;
	}
}
