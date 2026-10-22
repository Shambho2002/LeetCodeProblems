class Solution {
    public boolean isSame(char ch1, char ch2){
		ch1 = Character.toLowerCase(ch1);
		ch2 = Character.toLowerCase(ch2);
		
		return ch1 == ch2;
	}
    public int countKeyChanges(String s) {
        int count = 0;
		
		for(int i = 0; i < s.length() - 1; i++){
			if(isSame(s.charAt(i), s.charAt(i+1))){
				continue;
			}
			else{
				count++;
			}
		}
		
		return count;
    }
}