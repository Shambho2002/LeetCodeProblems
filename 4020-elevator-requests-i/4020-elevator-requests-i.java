class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int currentFloor = 0;
		int totalTime = 0;
		
		for(int x: requests){
			totalTime += Math.abs(currentFloor - x);
			currentFloor = x;
		}
		
		return totalTime;
    }
}