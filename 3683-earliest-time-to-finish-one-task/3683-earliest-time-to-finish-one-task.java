class Solution {
    public int earliestTime(int[][] tasks) {
        int[] ans = new int[tasks.length];
		
        for(int i = 0; i<tasks.length; i++){ // row
		int sum = 0;
			for(int j = 0; j<tasks[i].length; j++){ // column
				sum += tasks[i][j];
			}
			ans[i] = sum;
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<ans.length; i++){
			if(min > ans[i]){
				min = ans[i];
			}
		}
		return min;
    }
}