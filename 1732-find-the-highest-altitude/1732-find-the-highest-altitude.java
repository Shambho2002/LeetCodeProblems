class Solution {
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0; // -6
		int highestAltitude = 0; // 1
		
		for(int i = 0; i<gain.length; i++){ // i = 4
			currentAltitude = currentAltitude + gain[i]; // 1 + (-7) = -6
			
			if(currentAltitude > highestAltitude){ // -6 > 1 == false
				highestAltitude = currentAltitude; // highestAltitude = 1
			}
		}
		
		return highestAltitude; // 1
    }
}