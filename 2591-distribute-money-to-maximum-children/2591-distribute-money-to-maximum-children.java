class Solution {
    public int distMoney(int money, int children) {
        if(money < children){
			return -1;
		}
		
		money = money - children; // 20 - 3 = 17
		int maxChildren = Math.min(money / 7, children); // (17 / 7, 3) // 2
		money = money - (maxChildren * 7); // 17 - (2 * 7) = 17 - 14 = 3
		children = children - maxChildren; // 3 - 2 = 1
		
		if(children == 0 && money > 0){ // false
			maxChildren = maxChildren - 1;
		}
		
		if(children == 1 && money == 3){ // true
			maxChildren = maxChildren - 1; // 2 - 1 = 1
		}
		
		return maxChildren; // 1
    }
}