class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
		
		for(int i = 0; i < code.length; i++){
			if(k == 0){
				ans[i] = 0;
			}
			else if(k > 0){
				int sum = 0;
				for(int j = 1; j <= k; j++){
					int index = (i+j)%code.length;
					sum += code[index];
				}
				ans[i] = sum;
			}
			else{
				int sum = 0;
				for(int j = 1; j <= -k; j++){
					int index = (i-j+code.length)%code.length;
					sum += code[index];
				}
				ans[i] = sum;
			}
		}
		
		return ans;
    }
}