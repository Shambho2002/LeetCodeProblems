class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > num * 9){
			return "";
		}
		
		StringBuilder result = new StringBuilder();
		int remainingSum = sum;
		
		for(int i = 0; i < num; i++){
			if(remainingSum >= 9){
				result.append('9');
				remainingSum -= 9;
			}
			else{
				result.append(remainingSum);
				remainingSum = 0;
			}
		}
		
		return result.toString();
    }
}