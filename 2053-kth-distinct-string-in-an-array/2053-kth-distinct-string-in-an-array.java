class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> frequency = new HashMap<>();
		
		// Step 1: Count each String
		for(String str: arr){
			frequency.put(str, frequency.getOrDefault(str, 0) + 1);
		}
		
		// Step 2: Find the Kth distinct string
		int count = 0;
		
		for(String str: arr){
			if(frequency.get(str) == 1){
				count++;
				
				if(count == k){
					return str;
				}
			}
		}
		
		return "";
    }
}