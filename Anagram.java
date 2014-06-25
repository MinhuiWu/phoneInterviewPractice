public class Anagram{
	public static boolean anagram(String str){
		if (str.length() == 0) return true;
		
		int length = str.length();
			
		for (int i = 0; i < length / 2; i++){
			if (str.charAt(i) != (str.charAt(length - 1))){
				return false;			
			} 
			length--;
		}
		return true;
	}
	
	
	public static void main(String[] str){
		String str1 = "ababaab";
		String str2 = "eve";
		System.out.println(anagram(str1));
		System.out.println(anagram(str2));
	}
}
