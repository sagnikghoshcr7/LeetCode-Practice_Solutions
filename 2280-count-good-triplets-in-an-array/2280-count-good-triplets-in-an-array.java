class SegmentTree {
    int[] tree;
    int n;
    SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 0, 0, n - 1);
    }
    void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(arr, 2 * node + 1, start, mid);
            build(arr, 2 * node + 2, mid + 1, end);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }
    void update(int idx, int val) {
        update(idx, val, 0, 0, n - 1);
    }
    void update(int idx, int val, int node, int start, int end) {
        if (start == end) {
            tree[node] = val;
        } else {
            int mid = (start + end) / 2;
            if (idx <= mid)
                update(idx, val, 2 * node + 1, start, mid);
            else
                update(idx, val, 2 * node + 2, mid + 1, end);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }
    int query(int l, int r) {
        if (l > r) return 0;
        return query(l, r, 0, 0, n - 1);
    }
    int query(int l, int r, int node, int start, int end) {
        if (l > end || r < start)
            return 0;
        if (l <= start && end <= r)
            return tree[node];
        int mid = (start + end) / 2;
        int leftSum = query(l, r, 2 * node + 1, start, mid);
        int rightSum = query(l, r, 2 * node + 2, mid + 1, end);
        return leftSum + rightSum;
    }
}

class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        java.util.HashMap<Integer, Integer> mpp = new java.util.HashMap<>();
        int temp = 1;
        for (int x : nums1) mpp.put(x, temp++);
        for (int i = 0; i < nums2.length; i++) nums2[i] = mpp.get(nums2[i]);
        int n = nums1.length;
        int[] leftArr = new int[n];
        int[] rightArr = new int[n];
        for (int i = 0; i < n; i++) rightArr[i] = 1;
        SegmentTree leftTree = new SegmentTree(leftArr);
        SegmentTree rightTree = new SegmentTree(rightArr);
        leftTree.update(nums2[0] - 1, 1);
        rightTree.update(nums2[0] - 1, 0);
        long total = 0;
        for (int i = 1; i < n - 1; i++) {
            int idx = nums2[i];
            rightTree.update(idx - 1, 0);
            int left = idx - 2 >= 0 ? leftTree.query(0, idx - 2) : 0;
            int right = rightTree.query(idx, n - 1);
            total += (long) left * right;
            leftTree.update(idx - 1, 1);
        }
        return total;
    }
}