
public class Solution100 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        //if p or q are null
		if(p == null && q == null)
        	return true;
        else if(p == null && q != null)
        	return false;
        else if(p != null && q == null)
        	return false;
        
		//if p and q are valid node
        if(p.val == q.val){
        	boolean left = isSameTree(p.left, q.left);
        	boolean right = isSameTree(p.right, q.right);
        	if(left == true && right == true)
        		return true;
        	else
        		return false;
        }
        else
        	return false;
        
    }
}
