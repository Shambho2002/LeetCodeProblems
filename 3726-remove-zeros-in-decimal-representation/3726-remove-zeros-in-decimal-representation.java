class Solution {
    public long removeZeros(long n) {
        String num = Long.toString(n);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<num.length(); i++){
			if(num.charAt(i) != '0'){
				sb.append(num.charAt(i));
			}
		}
		
		return Long.parseLong(sb.toString());
    }
}