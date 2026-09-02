import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i<words.length; i++){
			String word = words[i];
			boolean flag = false;
			for(int j = 0; j<word.length(); j++){
				if(word.charAt(j) == x){
					flag = true;
				}
			}
			
			if(flag){
				list.add(i);
			}
		}
		
		return list;
    }
}