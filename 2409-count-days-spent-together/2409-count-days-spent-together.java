class Solution {
    public int convertToDayOfYear(String date){
		int[] daysInMonth = {
			31, 28, 31, 30, 31, 30,
			31, 31, 30, 31, 30, 31
		};
		
		int month = Integer.parseInt(date.substring(0, 2));
		int day = Integer.parseInt(date.substring(3, 5));
		
		int dayOfYear = day;
		
		for(int i = 0; i < month - 1; i++){
			dayOfYear += daysInMonth[i];
		}
		
		return dayOfYear;
	}
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aliceArrival = convertToDayOfYear(arriveAlice);
		int aliceDeparture = convertToDayOfYear(leaveAlice);
		int bobArrival = convertToDayOfYear(arriveBob);
		int bobDeparture = convertToDayOfYear(leaveBob);
		
		int start = Math.max(aliceArrival, bobArrival);
		int end = Math.min(aliceDeparture, bobDeparture);
		
		if(start > end){
			return 0;
		}
		
		return end - start + 1;
    }
}