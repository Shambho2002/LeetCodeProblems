class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
		int totalCost = 0;
		
		int tank = 0;
		int start = 0;
		
		for(int i = 0; i<gas.length; i++){
			totalGas = totalGas + gas[i];
			totalCost = totalCost + cost[i];
			
			tank = tank + gas[i] - cost[i];
			
			if(tank < 0){
				start = i + 1;
				tank = 0;
			}
		}
		
		if(totalGas < totalCost){
			return -1;
		}
		
		return start;
    }
}