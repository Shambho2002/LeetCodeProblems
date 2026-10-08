class Solution {
    public int distributeCandies(int n, int limit) {
        int count = 0;
		
		for(int child1 = 0; child1 <= limit; child1++){
			
			for(int child2 = 0; child2 <= limit; child2++){
				
				int child3 = n - child1 - child2;
				
				if(child3 >= 0 && child3 <= limit){
					
					count++;
				}
			}
		}
		return count;
    }
}