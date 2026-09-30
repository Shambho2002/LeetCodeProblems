class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] answer = new int[seq.length()];
		
		int depth = 0;
		
		for(int i = 0; i<seq.length(); i++){
			if(seq.charAt(i) == '('){
				depth++;
				if(depth % 2 == 0){
					answer[i] = 0;
				}
				else{
					answer[i] = 1;
				}
			}
			else if(seq.charAt(i) == ')'){
				if(depth % 2 == 0){
					answer[i] = 0;
				}
				else{
					answer[i] = 1;
				}
				depth--;
			}
		}
		
		return answer;
    }
}