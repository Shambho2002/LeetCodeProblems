import java.util.Arrays;
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] string = s.toCharArray();
		char[] target = t.toCharArray();
		
		if(string.length != target.length){
			return false;
		}
		else{
			Arrays.sort(string);
			Arrays.sort(target);
			
			for(int i = 0; i<string.length; i++){
				if(string[i] != target[i]){
					return false;
				}
			}
		}
		
		return true;
    }
}