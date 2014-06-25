import java.util.Stack;

public class ZigZagTraversal{
	/* Printing a Binary Tree in Zig Zag Level-Order
	 * level traverse the tree, then use stack to store every level elements and then pop()	
	 */
	public ArrayList<ArrayList<Integer>> zigzag(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
						
		if (root == null)  return res;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		ArrayList<Integer> level = new ArrayList<Integer>();
		boolean flag = false;// use this flag to consider the whether the even level or odd level of the tree
				
		while (!stack.isEmpty()) {
			//level.add(root.value);
			TreeNode current = stack.pop();
			level.add(current.value);
			currentLevel--;
			
			//push every level node in the stack
			if (flag) {
				if (current.right != null) stack.push(current.right);
				if (current.left != null)  stack.push(current.left);
			} else {
				if (current.left != null)  stack.push(current.left);
				if (current.right != null) stack.push(current.right);
			}
			
			flag = !flag;
			level.add(stack.pop());
			res.add(level);
		}
		return res;		
	}	
}
