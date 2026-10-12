class Solution {
    public int countPoints(String rings) {
        boolean[] red = new boolean[10];
		boolean[] green = new boolean[10];
		boolean[] blue = new boolean[10];
		
		for(int i = 0; i < rings.length(); i+=2){
			char color = rings.charAt(i);
			int rod = rings.charAt(i + 1) - '0';
			
			if(color == 'R'){
				red[rod] = true;
			}
			else if(color == 'G'){
				green[rod] = true;
			}
			else if(color == 'B'){
				blue[rod] = true;
			}
		}
		
		int count = 0;
		
		for(int rod = 0; rod < 10; rod++){
			if(red[rod] && green[rod] && blue[rod]){
				count++;
			}
		}
		
		return count;
    }
}