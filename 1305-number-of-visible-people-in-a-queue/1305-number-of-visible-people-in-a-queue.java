class Solution {
    public int[] canSeePersonsCount(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

for (int i=0; i<n; i++) {
        while (!st.isEmpty() && a[i] > a[st.peek()]) {
            res[st.pop()]++;
        }

        if (!st.isEmpty()) {
            res[st.peek()]++;
        }
        st.push(i);}
        return res;
    }
}