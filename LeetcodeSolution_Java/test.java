import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class test {
	
	public static void main(String[] args) {
		/*Solution48 sol = new Solution48();
		int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		//int[][] a = {{1, 2}, {3, 4}};
		sol.rotate(a);
		int n = a.length;
		for(int i = 0; i < n; i++){
			for(int j = 0; j <n ; j++)
				System.out.print(a[i][j] + " ");
			System.out.print("\n");
		}*/
		
//		int[] nums = {1,3,-1,-3,5,3,6,7};
//		Solution239 sol = new Solution239();
//		int[] res = sol.maxSlidingWindow(nums, 3);
//		for(int i = 0; i < res.length; i++){
//			System.out.println(res[i]);
//		}
		
		int[] coins = {-2,1,-3,4,-1,2,1,-5,4};
		Solution89 sol = new Solution89();
		List<Integer> res = sol.grayCode1(1);
		
		//System.out.println(res);
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}
		
		//LinkList prob
		/*Solution138 sol = new Solution138();
		RandomListNode head = new RandomListNode(1);
		RandomListNode n1 = new RandomListNode(2);
		RandomListNode n2 = new RandomListNode(3);
		RandomListNode n3 = new RandomListNode(4);
		RandomListNode n4 = new RandomListNode(5);
		RandomListNode n5 = new RandomListNode(6);
		head.next = n1;
		head.random = n1;
		n1.next = null;
		n1.random = n1;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		n5.next = null;
		
		RandomListNode nhead = sol.copyRandomList(head);
		RandomListNode p = nhead;
		while(p != null){
			System.out.print(p.label);
			p = p.next;
		}*/
		//System.out.print(res);
		
		/*Solution438 sol = new Solution438();
		String s = "abab";
		String p = "ab";
		List<Integer> res = sol.findAnagrams(s, p);
		System.out.print(res);*/
	}
	
	public static TreeNode findTreeNode(TreeNode root, int val){
		if(root == null)
			return null;
		else if(root.val == val)
			return root;
		else
			if(findTreeNode(root.left, val) != null)
				return findTreeNode(root.left, val);
			else if(findTreeNode(root.right, val) != null)
				return findTreeNode(root.right, val);
			else return null;
	}
	
	public static TreeNode BuildTree(int[] nodes){
		int index = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(nodes[0]);
		queue.add(root);
		index++;
		while(index < nodes.length && !queue.isEmpty()){
			TreeNode tn = queue.poll();
			if(nodes[index] != 999){
				TreeNode left = new TreeNode(nodes[index]);
				tn.left = left;
				queue.add(left);
			}else
				tn.left = null;
			index++;
			if(nodes[index] != 999){
				TreeNode right = new TreeNode(nodes[index]);
				tn.right = right;
				queue.add(right);
			}else
				tn.right = null;
			index++;
		}
		return root;
	}
	
}

