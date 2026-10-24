class Solution {
    // Array storing the number of days in each month for a non-leap year
    private final int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        // Step 1: Convert all MM-DD string dates to day-of-year integers
        int startAlice = convertToDayOfYear(arriveAlice);
        int endAlice = convertToDayOfYear(leaveAlice);
        int startBob = convertToDayOfYear(arriveBob);
        int endBob = convertToDayOfYear(leaveBob);

        // Step 2: Determine the intersection/overlap window of their stays
        int commonStart = Math.max(startAlice, startBob);
        int commonEnd = Math.min(endAlice, endBob);

        // Step 3: Calculate total overlap days (if no overlap, return 0)
        return Math.max(0, commonEnd - commonStart + 1);
    }

    // Helper method to convert "MM-DD" to an absolute day number (1 - 365)
    private int convertToDayOfYear(String date) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int totalDays = 0;
        // Add up all the days of the fully completed previous months
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonth[i];
        }

        // Add the days of the current month
        return totalDays + day;
    }
}
