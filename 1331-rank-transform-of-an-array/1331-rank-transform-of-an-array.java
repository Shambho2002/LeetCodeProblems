class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();
		Arrays.sort(sorted);
		
		HashMap<Integer, Integer> rankMap = new HashMap<Integer, Integer>();
		int rank = 1;
		
		for(int num: sorted){
			if(!rankMap.containsKey(num)){
				rankMap.put(num, rank);
				rank++;
			}
		}
		
		int[] ans = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++){
			ans[i] = rankMap.get(arr[i]);
		}
		
		return ans;
    }
}