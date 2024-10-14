class Solution {
    
    public long maxKelements(int[] arr, int k) {
        // Priorty Queue in reverse order is going to
        // give the highest number awailable
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int n = arr.length;
        long answer = 0;

        // Add all the elements in priorty queue
        for(int i=0; i<n; i++){
            queue.add(arr[i]);
        }

        //Loop k number of times as mentioned in question
        for(int i=0; i<k; i++){

        //Now grab the element from queue by poll function
        // (it will give highest awailable always)
            int temp = queue.poll();
            answer += temp;

        // After adding highest element in our answer
        // Give that number back to queue by doing the-
        //-operation as told in question ceil(num[i]/3)
            double s = (double)temp/3;
            queue.add((int)Math.ceil(s));
        }
        return answer;
    }
}