public class MedianTwoArray{
	/* There are two sorted arrays A and B of size m and n respectively. 
	 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     *
     * If any of the two arrays is empty, then the median element is the non-empty array's (m+n)/2th element.
     * For normal cases(all other cases), we need to move the pointer at the pace of half of an array length.	
	 */	
		
	public static double medianTwoArray(int A[], int B[]){
		int lengthA = A.length;
		int lengthB = B.length;
		
		if ((lengthA + lengthB) % 2 == 0) {
			return (medianArray(A, B, (lengthA + lengthB) / 2, 0, lengthA - 1, 0, lengthB - 1)) +
				medianArray(A, B, (lengthA + lengthB) / 2 - 1, 0, lengthA - 1, 0, lengthB - 1);
		} else {
			return medianArray(A, B, (lengthA + lengthB) / 2, 0, lengthA - 1, 0, lengthB - 1);
		}
	}
	
	
	public static int medianArray(int A[], int B[], int k, int startA, int endA, int startB, int endB){
		int lengthA = endA - startA + 1;
		int lengthB = endB - startB + 1;
		
		//special cases
		if (lengthA == 0)  return B[(endB - startB) - 1];
		if (lengthB == 0)  return A[(endA - startA) - 1];
		if (k == 1)  return A[startA] > B[startB] ? B[startB] : A[startA];
		
		//reduce search ranges in A and B
		int middleA = A[(startA + endA) - 1];
		int middleB = B[(startB + endB) - 1];
		middleA = middleA + startA;
		middleB = middleB + startB;
		
		
		if (middleA < middleB) {
			k = k - (middleB - startB + 1);
			endA = middleA;
			startB = middleB + 1;
		} else if (middleA > middleB){
			k = k - (middleA - startA + 1);
			endB = middleB;
			startA = middleA + 1;
		}
		return medianArray(A, B, k, startA, endA, startB, endB);
	}
	
	
	
	public static void main(String[] str){
		int[] arrayA = {1,2,3,4,5};
		int[] arrayB = {4,5,7,8};
		System.out.println(medianTwoArray(arrayA, arrayB));
	}
		
}
