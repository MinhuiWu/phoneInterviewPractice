import java.util.ArrayList;
import java.util.LinkedList;

public class LevelTraversal{
	//first do level order traversal (BFS seems very clear)
	//recusion method	
	public ArrayList<ArrayList<Integer>> levelTraversBFS(TreeNode root){
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		levelTraversBFShelper(root, 0, ans);
		return ans;
	}
	
	
	public ArrayList<ArrayList<Integer>> levelTraversBFShelper(TreeNode root, int height, ArrayList<ArrayList<Integer>> ans){
		if (root == null)  return null;
		ArrayList<Integer> list = null;
		if (height >= ans.size()) {
			list = new ArrayList<Integer>();
			ans.add(list);			
		} else {
			list = ans.get(height);
			list.add(root.val);
			levelTraversBFShelper(root.left, height + 1, ans);
			levelTraversBFShelper(root.right, height + 1, ans);
		}		
	}
	
	
	
	//iterative BFS method
public ArrayList<LinkedList<TreeNode>> levelOrder(TreeNode root) {
	ArrayList<LinkedList<TreeNode>>  result = new ArrayList<LinkedList<TreeNode>();
	if (root == null)  return result;
	
	//visit the root
	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	queue.add(root);
		
	while (! queue.isEmpty()) {
		Queue<TreeNode> nextQueue = new LinkedList<TreeNode>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		while( !queue.isEmpty()){
			TreeNode node = queue.poll();
			list.add(node);
			if (node.left != null) {
				nextQueue.add(node.left)
			}	
			if (node.right != null) {
				nextQueue.add(node.right);
			}
		result.add(list);
		queue.addAll(nextQueue);
		nextQueue = new LinkedList<TreeNode>();
		}
	return result;
	}	
}
		
		
	//recursive method
	public ArrayList<ArrayList<Integer>> levelTraversDFS(TreeNode root){
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		
		int height = getHeight(root);
		for (int i = 0; i < height; i++){
			ArrayList<Integer> list = new ArrayList<Integer>();
			ans.add(list);
		}		
		levelOrderDFS(root, 0, ans);
		return ans;
	}
	
	
	public ArrayList<ArrayList<Integer>> levelOrderDFS(TreeNode root, int depth, ArrayList<ArrayList<Integer>> ans){
		if (root == null)  return ans;
		ArrayList<Integer> level = ans.get(ans.size() - depth - 1);
		level.add(root.value);
		levelOrderDFS(root.left, depth + 1, ans);
		levelOrderDFS(root.right, depth + 1, ans);
	}
	
	
	
	public int getHeight(TreeNode root){
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}	
			
}
