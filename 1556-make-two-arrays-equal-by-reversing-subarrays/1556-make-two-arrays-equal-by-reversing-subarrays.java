class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int n = target.length;
        int[] first = new int[1001];
        int[] second = new int[1001];
        for (int i=0; i<n; i++) {
            first[target[i]]++;
            second[arr[i]]++;
        }
        for (int i=0; i<1001; i++)
            if (first[i] != second[i]) {return false;}
        return true;
    }
}