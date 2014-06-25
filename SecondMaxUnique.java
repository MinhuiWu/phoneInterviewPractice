import java.util.HashMap;

public class SecondMaxUnique{
	/* find the second max unique number in the array
	 *	
	 * 1)iterate through the array and put it in the hashmap, use the hashmap as counter to count the apperance of the elements
	 * 2)go through the array, swap two largest elements from the start of the array to the end, 
	 * 3)check the hashmap to see whether it is a duplicate element, if so, ignore it, if not, update the two largest elements
	 */
	public static int secondMaxUnique(int[] arr){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		if (arr.length < 2)  { 
			throw new IllegalArgumentException("Invalid parameter, array is too short."); 
		}
		
		//step 1)
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}		
		
		//step 2)
		int secondMax = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			//step 3)
			if (map.get(arr[i]) == 1) {
				if (arr[i] > max) {
					secondMax = max;
					max = arr[i];					
				} else if (arr[i] > secondMax){
					secondMax = arr[i];
				}				
			}			
		}
		return secondMax;
	}
	
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 18, 12, 12, 4, 11};
        System.out.println(secondMaxUnique(arr));
    }
	
}
