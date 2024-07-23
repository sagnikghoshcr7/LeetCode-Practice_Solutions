class Solution {
    public int[] frequencySort(int[] nums) {
         int min = 0, max = 0;
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] < min) min = nums[i];
            if(nums[i] > max) max = nums[i];
        }
        int[] count = new int[max - min + 1];
        int maxfreq = 0;
        for(int i = 0; i < nums.length; ++i) {
            int j = nums[i] - min;
            count[j]++;
            if(count[j] > maxfreq) maxfreq = count[j];
        }
        List<Integer>[] freq = new ArrayList[maxfreq + 1];
        for(int i = count.length - 1; i >= 0 ; --i) {
            if(count[i] == 0) continue;
            if(freq[count[i]] == null) {
                freq[count[i]] = new ArrayList<>();
            }
            freq[count[i]].add(i + min);
        }
        int k = 0;
        for(int i = 0; i <= maxfreq; ++i) {
            if(freq[i] == null) continue;
            for(int x : freq[i]) {
                for(int j = 0; j < i; ++j) {
                    nums[k++] = x;
                }
            }
        }
        return nums;
    }
}