class Solution {
    public int findComplement(int num) {
        int l = Integer.toBinaryString(num).length();
        int full = 1;
        for (int i = 0; i < l - 1; i++) {
            full <<= 1;
            full += 1;
		}
        return num ^ full;
    }
}