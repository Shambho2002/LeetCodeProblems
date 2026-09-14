class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length + 1]; // Create arr with one extra space because encoded has n - 1 elements.
		
		arr[0] = first; // Put first at arr[0].
		for(int i = 0; i<encoded.length; i++){
			arr[i+1] = arr[i] ^ encoded[i]; // Use the previous arr value and XOR it with encoded[i].
			// Store the result at the next position.
		}
		
		return arr;
    }
}