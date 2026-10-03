class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<Integer>();
		
		for(int i = left; i <= right; i++){
			int num = i;
			boolean flag = true;
			
			while(num != 0){
				int digit = num % 10;
				
				// Number cannot contain digit 0
				if(digit == 0){
					flag = false;
					break;
				}
				
				// Number must be divisible by every digit
				if(i % digit != 0){
					flag = false;
					break;
				}
				
				num /= 10;
			}
			
			if(flag){
				list.add(i);
			}
			
		}
		
		return list;
    }
}