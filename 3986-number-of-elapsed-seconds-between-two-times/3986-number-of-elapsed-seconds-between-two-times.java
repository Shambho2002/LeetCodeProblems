class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        String[] start = startTime.split(":"); // "01":"00":"00"
		String[] end = endTime.split(":"); // "01":"00":"25"
		
		int startSeconds = Integer.parseInt(start[0]) * 3600 // 01 * 3600 = 3600
							+ Integer.parseInt(start[1]) * 60 // 00 * 60 = 00
							+ Integer.parseInt(start[2]); // 00
							
		int endSeconds = Integer.parseInt(end[0]) * 3600 // 01 * 3600 = 3600
							+ Integer.parseInt(end[1]) * 60 // 00 * 60 = 00
							+ Integer.parseInt(end[2]); // 25
		
		return endSeconds - startSeconds; // 3600 - 3625 = 25
    }
}