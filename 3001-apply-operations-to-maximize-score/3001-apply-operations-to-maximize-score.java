class Solution {
    private int countDistinctPrimeFactors(int n) {
        int count = 0;
        if (n % 2 == 0) {
            count++;
            while (n % 2 == 0) {
                n /= 2;
            }
        }
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                count++;
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        if (n > 1) count++;
        return count;
    }

    private int modPow(int base, int exp, int mod) {
        long result = 1;
        long b = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * b) % mod;
            }
            b = (b * b) % mod;
            exp >>= 1;
        }
        return (int) result;
    }

    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        if (n == 0) return 1;

        PriorityQueue<int[]> maxValues = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] rightLarge = new int[n], leftLarge = new int[n], primeScores = new int[n];
        Arrays.fill(rightLarge, n);
        Arrays.fill(leftLarge, -1);
        Stack<Integer> stack1 = new Stack<>(), stack2 = new Stack<>();

        for (int i = 0; i < n; i++) {
            primeScores[i] = countDistinctPrimeFactors(nums.get(i));
            maxValues.offer(new int[]{nums.get(i), i});
        }

        for (int i = 0; i < n; i++) {
            while (!stack1.isEmpty() && primeScores[i] > primeScores[stack1.peek()]) {
                rightLarge[stack1.pop()] = i;
            }
            stack1.push(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!stack2.isEmpty() && primeScores[i] >= primeScores[stack2.peek()]) {
                leftLarge[stack2.pop()] = i;
            }
            stack2.push(i);
        }

        int score = 1, MODULE = 1000000007;

        while (!maxValues.isEmpty() && k > 0) {
            int[] top = maxValues.poll();
            int val = top[0], idx = top[1];

            long t = (long) (rightLarge[idx] - idx) * (idx - leftLarge[idx]);
            long steps = Math.min(t, k);

            int multiply = modPow(val, (int) steps, MODULE);
            score = (int) ((1L * score * multiply) % MODULE);

            k -= steps;
        }
        return score % MODULE;
    }
}