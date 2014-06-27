public class LPS{
	/* Given a string S, find the longest palindromic substring in S.
	 * naive solution:	
	 * palindromic mirrors arounds its middle, there would be 2N-1 middles(for every letters and every space between the two elements)
	 * time complexity (N^2), to check every letter for every middle		
	 */	
	public String longestPalindromic(String str) {
		String lps = str.substring(0,1);
		
		for (int i = 0; i < str.length() - 1; i++) {
			//the middle is the elements of the string
			String tmp = expand(str, i, i + 1);
			lps = tmp.length() > lps.length() ? tmp : lps;   
			//the middel is the space between elements of the string
			String tmp = expand(str, i , i);
			lps = tmp.length() > lps.length() ? tmp : lps;
		}
		return lps;
	}
	
	
	public String expand(String str, int left, int right) {
		int lefttmp = left;
		int righttmp = right;
		while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
			left--;
			right++;
		}
		return str.substring(left + 1, right);
	}
}
