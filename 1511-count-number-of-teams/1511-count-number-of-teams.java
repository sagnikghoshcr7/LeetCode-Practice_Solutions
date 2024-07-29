class Solution {
    public int numTeams(int[] rating) {
        int totalTeams = 0;
        int soldierCount = rating.length;

        for (int currentSoldier = 0; currentSoldier < soldierCount; currentSoldier++) {
            totalTeams += countTeams(rating, currentSoldier, soldierCount);
        }

        return totalTeams;
    }

    private int countTeams(int[] rating, int currentSoldier, int soldierCount) {
        int[] leftCounts = countSmallerAndLarger(rating, 0, currentSoldier, rating[currentSoldier]);
        int[] rightCounts = countSmallerAndLarger(rating, currentSoldier + 1, soldierCount, rating[currentSoldier]);

        int ascendingTeams = leftCounts[0] * rightCounts[1];
        int descendingTeams = leftCounts[1] * rightCounts[0];

        return ascendingTeams + descendingTeams;
    }

    private int[] countSmallerAndLarger(int[] rating, int start, int end, int reference) {
        int smaller = 0, larger = 0;

        for (int i = start; i < end; i++) {
            if (rating[i] < reference) smaller++;
            else if (rating[i] > reference) larger++;
        }

        return new int[]{smaller, larger};
    }
}