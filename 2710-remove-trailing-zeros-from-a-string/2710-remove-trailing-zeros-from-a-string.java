class Solution {
    public String removeTrailingZeros(String num) {
        int zeros = 0;
		for(int i = num.length() - 1; i>=0; i--){
			if(num.charAt(i) == '0'){
				zeros++;
			}
			else{
				break;
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i<num.length() - zeros; i++){
			sb.append(num.charAt(i));
		}
		
		return new String(sb);
    }
}