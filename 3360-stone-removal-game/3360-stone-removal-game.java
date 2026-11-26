class Solution {
    public boolean canAliceWin(int n) {
        int remainingStones = n;
		int stonesToRemove = 10;
		boolean aliceTurn = true;
		
		while(remainingStones >= stonesToRemove){
			remainingStones = remainingStones - stonesToRemove;
			stonesToRemove = stonesToRemove - 1;
			aliceTurn = !aliceTurn;
		}
		
		return aliceTurn == false ? true : false;
    }
}