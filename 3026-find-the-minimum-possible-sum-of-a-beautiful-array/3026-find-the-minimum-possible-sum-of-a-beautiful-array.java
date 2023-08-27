class Solution {
    public long minimumPossibleSum(int n, int target) {
        int count = 0; long sum = 0;
        HashSet<Integer> set = new HashSet<>();
        
        int num = 1;
        while (count < n) {
            int val = target - num;
            if (!set.contains(val)) {
                set.add(num);
                sum += num;
                count++;
            }
            num++;
        }
        
        return sum;
    }
}