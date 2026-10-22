class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
		
		for(int i = 0; i < details.length; i++){
			char[] chArr = details[i].toCharArray();
			
			char digit1 = chArr[11];
			char digit2 = chArr[12];
			
			String digits = "" + digit1 + digit2;
			
			int age = Integer.parseInt(digits);
			
			if(age > 60){
				count++;
			}
			
		}
		
		return count;
    }
}