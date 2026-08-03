import java.util.Arrays;
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // 3 - 1 = 2
        int j = n - 1; // 3 - 1 = 2
        int k = m + n - 1; // 3 + 3 - 1 = 6 - 1 = 5

        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }
            else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // if nums2 still has elements left
        while(j >= 0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }

    }
}