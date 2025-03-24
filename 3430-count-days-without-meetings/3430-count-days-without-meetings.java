class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int meetingDaysCount = 0;
        int currentStart = -1, currentEnd = -1;

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            if (start > currentEnd) {
                if (currentEnd != -1) {
                    meetingDaysCount += (currentEnd - currentStart + 1);
                }
                currentStart = start;
                currentEnd = end;
            } else {
                currentEnd = Math.max(currentEnd, end);
            }
        }

        if (currentEnd != -1) {
            meetingDaysCount += (currentEnd - currentStart + 1);
        }

        return days - meetingDaysCount;
    }
}