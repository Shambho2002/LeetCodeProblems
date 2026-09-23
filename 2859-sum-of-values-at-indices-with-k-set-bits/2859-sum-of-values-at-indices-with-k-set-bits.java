class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for(int i = 0; i<nums.size(); i++){
			int number = i;
			int count = 0;
			while(number > 0){
				if(number % 2 == 1){
					count++;
				}
				number /= 2;
			}
			if(count == k){
				sum += nums.get(i);
			}
		}
		return sum;
    }
}