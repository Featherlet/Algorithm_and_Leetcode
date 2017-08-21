import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution104 {
	/*//DFS method
	public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = 0, right = 0;
        if(root.left != null) 
        	left = maxDepth(root.left);
        if(root.right != null)
        	right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }*/
	
	//BFS method
	public int maxDepth(TreeNode root){
		if(root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int count = 0;
		while(!queue.isEmpty()){
			int size = queue.size();
			while(size > 0){
				TreeNode tn = queue.poll();
				if(tn.left != null) queue.add(tn.left);
				if(tn.right != null) queue.add(tn.right);
				size--;
			}
			count++;
		}
		return count;
	}
	
}
