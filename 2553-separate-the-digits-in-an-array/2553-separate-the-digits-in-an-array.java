class Solution {
    public int[] separateDigits(int[] nums) {
        // First calculate total number of digits
		int size = 0; // 8
		
		for(int num: nums){
			size += String.valueOf(num).length(); // 6 + 2 = 8
		}
		
		int[] ans = new int[size]; // int[] ans = new int[8];
		int index = 0; // 8
		
		for(int num: nums){
			String str = String.valueOf(num); // 77
			for(int i = 0; i<str.length(); i++){
				ans[index] = str.charAt(i) - '0'; // 55 - 48 = 7
				index++; // 8
			}
		}
		return ans; // 1,3,2,5,8,3,7,7
    }
}