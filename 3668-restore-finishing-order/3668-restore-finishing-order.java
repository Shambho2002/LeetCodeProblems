class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i<order.length; i++){
			for(int j = 0; j<friends.length; j++){
				if(order[i] == friends[j]){
					list.add(order[i]);
				}
			}
		}
		
		int[] ans = new int[list.size()];
		for(int i = 0; i<list.size(); i++){
			ans[i] = list.get(i);
		}
		return ans;
    }
}