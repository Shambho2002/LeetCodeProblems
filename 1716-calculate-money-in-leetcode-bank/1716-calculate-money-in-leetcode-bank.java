class Solution {
    public int totalMoney(int n) {
        int sum = 0;
		int monday = 1;
		int daily = 1;
		
		for(int day = 1; day <= n; day++){
			sum += daily;
			daily += 1;
			
			if(day % 7 == 0){
				monday += 1;
				daily = monday;
			}
		}
		
		return sum;
    }
}