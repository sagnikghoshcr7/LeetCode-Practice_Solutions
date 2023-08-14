// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
//         for(int i=0; i<nums.length; i++) {
//             if (pq.size() < k) pq.add(nums[i]);
//             else {
//                 if (nums[i] > pq.peek()) {
//                     pq.poll(); // or pq.remove();
//                     pq.add(nums[i]);
//                 }
//             }
//         }
//         return pq.peek();
//     }
// }

// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)->b-a);

//         for(int i=0; i<nums.length; i++) pq.add(nums[i]);
        
//         while (k-->1) pq.poll();

//         return pq.peek();
//     }
// }

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i: nums){
            pq.add(i); // Internally min Heapify works while inserting values
            
            if(pq.size() > k) // Top of element will always have the largest item.
                pq.poll(); // So after k times removal , we get the kth largest item on top
        }
        return pq.peek();
    }
}