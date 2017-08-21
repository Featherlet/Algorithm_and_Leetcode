import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(root == null)
        	return list;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
        	ArrayList<Integer> level = new ArrayList<Integer>();
        	int count = queue.size();
        	for(int i = 0; i < count; i++){
        		TreeNode tn = queue.poll();
        		level.add(tn.val);
        		if(tn.left != null)
        			queue.add(tn.left);
        		if(tn.right != null)
        			queue.add(tn.right);
        	}
        	list.add(level);
        }
        return list;
    }
}
