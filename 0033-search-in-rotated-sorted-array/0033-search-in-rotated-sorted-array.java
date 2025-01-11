class Solution {
    public int search(int[] a, int target) {
        int pivot = findPivot(a);

        // Search in the first part (0 to pivot - 1)
        int ans = bs(a, 0, pivot - 1, target);
        if (ans != -1) return ans;

        // Search in the second part (pivot to end)
        return bs(a, pivot, a.length - 1, target);
    }

    public int findPivot(int[] a) {
        int lo = 0, hi = a.length - 1;

        while (hi - lo > 1) {
            int mid = lo + (hi - lo) / 2;

            // Pivot is in the right part if mid is greater than the last element
            if (a[mid] > a[hi]) lo = mid;
            else hi = mid; // Pivot is in the left part
        }

        // The pivot is the smaller of the two remaining elements
        return a[lo] > a[hi] ? hi : lo;
    }

    public int bs(int[] a, int s, int e, int target) {
        int lo = s - 1, hi = e + 1; // Extend bounds to use `hi - lo > 1`

        while (hi - lo > 1) {
            int mid = lo + (hi - lo) / 2;

            if (a[mid] < target) lo = mid; // Move right
            else hi = mid; // Move left
        }

        // After the loop, check if the target is found
        return (hi >= 0 && hi < a.length && a[hi] == target) ? hi : -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {3, 4, 5, 6, 1, 2};
        int target = 2;

        System.out.println(sol.search(nums, target)); // Output: 5
    }
}
