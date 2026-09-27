class Solution {
    public String binaryConvertion(int nums){
		String bits = "";
		
		while(nums > 0){
			int rem = nums % 2;
			bits = bits + rem;
			nums = nums / 2;
		}
		
		// Reverse the binary string
		String reverse = "";
		
		for(int i = bits.length() - 1; i >= 0; i--){
			reverse = reverse + bits.charAt(i);
		}
		
		return reverse;
	}
    public String convertDateToBinary(String date) {
        StringBuilder sb = new StringBuilder();
		
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(5, 7));
		int day = Integer.parseInt(date.substring(8, 10));
		
		sb.append(binaryConvertion(year));
		sb.append("-");
		sb.append(binaryConvertion(month));
		sb.append("-");
		sb.append(binaryConvertion(day));
		
		return new String(sb);
    }
}