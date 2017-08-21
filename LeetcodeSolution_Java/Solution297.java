import java.util.LinkedList;
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
public class Solution297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
        	return "null";
        String str = "";
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        str = str + Integer.toString(root.val) + ",";
        while(!queue.isEmpty()){
        	TreeNode tn = queue.poll();
        	if(tn.left != null){
        		str = str + Integer.toString(tn.left.val) + ",";
        		queue.add(tn.left);
        	}else
        		str = str + "null,";
        	if(tn.right != null){
        		str = str + Integer.toString(tn.right.val) + ",";
        		queue.add(tn.right);
        	}else
        		str = str + "null,";
        }
        str = str.substring(0, str.length() - 1);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if(data == null || data.length() == 0 || data.equals("null"))
    		return null;
        String[] str = data.split(",");
        int index = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(Integer.parseInt(str[0]));
		queue.add(root);
		index++;
		while(index < str.length && !queue.isEmpty()){
			TreeNode tn = queue.poll();
			if(!str[index].equals("null")){
				TreeNode left = new TreeNode(Integer.parseInt(str[index]));
				tn.left = left;
				queue.add(left);
			}else
				tn.left = null;
			index++;
			if(!str[index].equals("null")){
				TreeNode right = new TreeNode(Integer.parseInt(str[index]));
				tn.right = right;
				queue.add(right);
			}else
				tn.right = null;
			index++;
		}
		return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));