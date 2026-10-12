class Solution {
    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
		
		String[] str = s.split(" ");
		for(int i = 0; i < k; i++){
			sb.append(str[i]);
			if(i < k - 1){
				sb.append(" ");
			}
		}
		
		return new String(sb);
    }
}