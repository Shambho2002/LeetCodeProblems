class Solution {
    public int countOnes(int num){
		int count = 0;
		
		while(num > 0){
			int remainder = num % 2;
			if(remainder == 1){
				count++;
			}
			num = num / 2;
		}
		
		return count;
	}
    public int[] sortByBits(int[] arr) {
        for(int i = 0; i<arr.length; i++){
			for(int j = i+1; j<arr.length; j++){
				int bitsOfI = countOnes(arr[i]);
				int bitsOfJ = countOnes(arr[j]);
				
				if(bitsOfI > bitsOfJ){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				else if(bitsOfI == bitsOfJ){
					if(arr[i] > arr[j]){
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
		}
		return arr;
    }
}