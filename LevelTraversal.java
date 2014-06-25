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
	public ArrayList<ArrayList<Integer>> levelOrderBFS(TreeNode root){
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if (root == null)  return ans;
		
		Queue queue = new LinkedList<TreeNode>();
		queue.add(root);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(root.value);
		int currentLevel = 1;
		int nextLevel = 0;
		
		while (!queue.isEmpty()) {			
			TreeNode node = queue.remove();
			list.add(node.value);
			currentLevel--;
			
			for (TreeNode node : queue){
				if (node.left != null) {
					list.add(node.left.value);
					queue.add(node.left);
					nextLevel++;
				} 
				if (node.right != null)	{
					list.add(node.right.value);
					queue.add(node.right);
					nextLevel++;
				} 
			}
			
			if (currentLevel == 0) {
				currentLevel = nextLevel;
				nextLevel = 0;
				ans.add(list);			
			}				
		}
		return ans;		
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
