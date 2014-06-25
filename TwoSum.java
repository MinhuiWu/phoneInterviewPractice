import java.util.HashMap;

public class TwoSum{
	public static int[] twoSum(int[] array, int target){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] res = new int[2];
		if(array == null || array.length < 2) return res;
		
		for (int i = 0; i < array.length; i++){
			if (map.containsKey(array[i])){
				res[0] = map.get(array[i]) + 1;
				res[1] = i + 1;
			} else {
				map.put(target - array[i], i);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
	        int[] arr = {6, 4, 19, 15};
	        int target = 10;

	        int[] result = twoSum(arr, target);
	        for (int i = 0; i < result.length; i++) {
	            System.out.println(result[i]);
	        }
	    }
	
	
	
}
