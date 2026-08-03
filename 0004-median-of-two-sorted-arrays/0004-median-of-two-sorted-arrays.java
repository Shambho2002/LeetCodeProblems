class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
		int n = nums2.length;
		
		int[] temp = new int[m+n];
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < m && j<n){
			if(nums1[i] < nums2[j]){
				temp[k] = nums1[i];
				i++;
			}
			else{
				temp[k] = nums2[j];
				j++;
			}
			k++;
		}
		
		while(i < m){
			temp[k] = nums1[i];
			i++;
			k++;
		}
		
		while(j < n){
			temp[k] = nums2[j];
			j++;
			k++;
		}
		
		int length = temp.length;
		
		if(length % 2 != 0){
			return temp[length/2];
		}
		
		return (temp[length/2] + temp[(length/2) - 1]) / 2.0;
    }
}