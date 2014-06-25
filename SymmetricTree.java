public class SymmetricTree{
	/* decide whether a tree is symmetric
	 * recursion
	 */
	public boolean SymmetricTree(TreeNode root){
		if (root == null)  return true;
		return SymetricTree(root.left, root.right);
	}
	
	public boolean SymmetricTree(TreeNode left, TreeNode right){
		if (left == null || right == null)  return left == null && right == null;
		if (left.value != right.value)  return false;
		
		if (!SymmetricTree(left.left, right.right))  return false;
		if (!SymmetricTree(left.right, right.left))  return false;
		return true;
	}
		
}
