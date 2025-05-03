class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        HashSet<Integer> s = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int[] countA = new int[7], countB = new int[7];
        for (int i = 0; i < A.length; ++i) {
            s.retainAll(new HashSet<>(Arrays.asList(A[i], B[i])));
            countA[A[i]]++;
            countB[B[i]]++;
        }
        for (int i : s)
            return A.length - Math.max(countA[i], countB[i]);
        return -1;
    }
}