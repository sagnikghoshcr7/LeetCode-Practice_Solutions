public class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<int[]> storePairs = new ArrayList<int[]>();

        for (int i = 0; i < nums.length; i++) {
            int mappedValue = 0;
            int temp = nums[i];
            int place = 1;

            if (temp == 0) {
                storePairs.add(new int[] { mapping[0], i });
                continue;
            }
            while (temp != 0) {
                mappedValue = place * mapping[temp % 10] + mappedValue;
                place *= 10;
                temp /= 10;
            }
            storePairs.add(new int[] { mappedValue, i });
        }

        Collections.sort(storePairs, (a, b) -> a[0] - b[0]);

        int[] answer = new int[nums.length];
        for (int i = 0; i < storePairs.size(); i++) {
            answer[i] = nums[storePairs.get(i)[1]];
        }

        return answer;
    }
}