class Solution {
    public boolean judgeCircle(String moves) {
        int up = 0;
		int down = 0;
		int left = 0;
		int right = 0;
		
		for(char move: moves.toCharArray()){
			if(move == 'U'){
				up++;
			}
			else if(move == 'D'){
				down++;
			}
			else if(move == 'L'){
				left++;
			}
			else if(move == 'R'){
				right++;
			}
		}
		
		if(up == down && left == right){
			return true;
		}
		
		return false;
    }
}