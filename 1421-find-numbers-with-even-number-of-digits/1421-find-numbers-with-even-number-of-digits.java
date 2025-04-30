class Solution {
    public int findNumbers(int[] nums) {
        int counter = 0;
        
        for (int i : nums) {
            if (i < 10) {
                continue;
            }
            
            if (i >= 10 && i < 100) {
                ++counter;
            }
            
            if (i >= 1000 && i < 10000) {
                ++counter;        
            }
            
            if (i >= 100000 && i < 1000000) {
                ++counter;               
            }
        }
        
        return counter;
    }
}