import java.util.Arrays;
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
		Arrays.sort(s);
		
		int child = 0; // 1
		int cookie = 0; // 2
		int content = 0; // 1
		
		while(child < g.length && cookie < s.length){
			
			if(s[cookie] >= g[child]){ // s[2] >= g[1] == 3 >= 1 == true
				content++; // 1
				child++; // 1
				cookie++; // 1
			}
			else{
				cookie++; // 2
			}
			
		}
		
		return content; // 1
    }
}