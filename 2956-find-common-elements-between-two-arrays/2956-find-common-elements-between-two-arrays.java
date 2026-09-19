class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<Integer>();
		
		// for each elements in nums1
		for(int i = 0; i<nums1.length; i++){
			set1.add(nums1[i]); // 2,3
		}
		
		// for each elements in nums2
		for(int i = 0; i<nums2.length; i++){
			set2.add(nums2[i]); // 1,2
		}
		
		int answer1 = 0; // 2
		int answer2 = 0; // 1
		
		for(int i = 0; i<nums1.length; i++){
			if(set2.contains(nums1[i])){
				answer1++;
			}
		}
		
		for(int i = 0; i<nums2.length; i++){
			if(set1.contains(nums2[i])){
				answer2++;
			}
		}
		
		return new int[]{answer1, answer2};
    }
}