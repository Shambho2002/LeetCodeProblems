class Solution {
    public int minimumPushes(String word) {
        int answer = 0;
		int pushes = 1;
		int count = 0;
		
		for(int i = 0; i<word.length(); i++){
			answer = answer + pushes;
			count++;
			if(count == 8){
				pushes++;
				count = 0;
			}
		}
		
		return answer;
    }
}