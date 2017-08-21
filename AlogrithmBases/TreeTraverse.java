import java.util.Stack;

public class TreeTraverse {
	
	//By recursion
	public void preOrderRec(TreeNode root){
		TreeNode tn = root;
		if(tn == null)
			return;
		System.out.println(tn.val);
		preOrderRec(tn.left);
		preOrderRec(tn.right);
	}

	public void inOrderRec(TreeNode root){
		TreeNode tn = root;
		if(tn == null)
			return;
		inOrderRec(tn.left);
		System.out.println(tn.val);
		inOrderRec(tn.right);
	}
	
	public void postOrderRec(TreeNode root){
		TreeNode tn = root;
		if(tn == null)
			return;
		postOrderRec(tn.left);
		postOrderRec(tn.right);
		System.out.println(tn.val);
	}
	
	//Without recursion=============================================
	public void preOrder(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while(p != null || !stack.isEmpty()){
			//find the left most node of p
			while(p != null){
				System.out.println(p.val);
				stack.push(p);
				p = p.left;
			}
			//pop the left most and set its right child to be the current node p
			if(!stack.isEmpty()){
				p = stack.pop();
				p = p.right;
			}
		}
	}
	
	public void inOrder(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while(p != null || !stack.isEmpty()){
			while(p != null){
				stack.push(p);
				p = p.left;
			}
			if(!stack.isEmpty()){
				p = stack.pop();
				System.out.println(p.val);
				p = p.right;
			}
		}
	}
	
	public void postOrder(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while(p != null || stack.isEmpty()){
			while(p != null){
				stack.push(p);
				p = p.left;
			}
			while(!stack.isEmpty()){
				p = stack.peek();
				if(p.isFirst == true){
					p.isFirst = false;
					p = p.right;
				}else{
					p = stack.pop();
					System.out.println(p.val);
					p = null;
				}
			}
		}
	}
	
	public void postOrder2(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		stack.push(p);
		while(!stack.isEmpty()){
			p = stack.peek();
			if(p.left == null && p.right == null){
				System.out.println(p.val);
				p.isFirst = false;
				stack.pop();
			}else if((p.left != null &&p.left.isFirst == false) || 
					(p.right != null && p.right.isFirst == false)){
				System.out.println(p.val);
				p.isFirst = false;
				stack.pop();
			}else{
				if(p.left != null)
					stack.push(p.left);
				if(p.right != null)
					stack.push(p.right);
			}
			
		}
	}
	
}
