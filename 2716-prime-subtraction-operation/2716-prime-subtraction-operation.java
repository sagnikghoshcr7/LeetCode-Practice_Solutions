class Solution {
    private boolean isPrime(int n){
        int fCt = 0;
        for(int i=1; i*i<=n; i++){
            if(n%i == 0) {
                if(i*i == n) fCt++;
                else fCt += 2;
            }
        }
        return fCt==2;
    }
    List<Integer> primes = new ArrayList<>();
    private void generatePrimes(){
        primes.add(2);
        for(int i=3; i<1000; i+=2){
            if(isPrime(i)) primes.add(i);
        }
    }
    private int floorPrime(int x){
        if(primes.get(0) > x) return 0;

        int ans = primes.get(0);
        for(int i=1; i<primes.size(); i++){
            if(primes.get(i)>x) return ans;
            ans = primes.get(i);
        }
        return ans;
    }
    public boolean primeSubOperation(int[] nums) {
        generatePrimes();
        int n = nums.length;
        int prev = 0;
        for(int i=0; i<n; i++) {
            int diff = nums[i] - prev - 1;
            int floor = floorPrime(diff);
            nums[i] -= floor;
            prev = nums[i];
        }
        for(int i=1; i<n; i++){
            if(nums[i] <= nums[i-1]) return false;
        }
        return true;
    }
}