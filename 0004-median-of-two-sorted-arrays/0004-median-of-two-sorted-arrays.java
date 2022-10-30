class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int i = nums1.length;
        int j = nums2.length;
        
        int[] arr = new int[i+j];
        
        // Merge two lists into one array
        System.arraycopy(nums1, 0, arr, 0, i);
        System.arraycopy(nums2, 0, arr, i, j);
        
        // Sort the merged array
        Arrays.sort(arr);
        
        int n = arr.length;
        
        if (n%2 == 0) {
            // If length of array is even
            int mid = n/2;
            int a = arr[mid];
            int b = arr[mid - 1];
            float testa = a;
			float testb = b;
            float ans = (testa+testb)/2;
            return ans;
        } else {
            // If length of array is odd
            int mid = Math.round(n/2);
            return arr[mid];
        }        
    }
}