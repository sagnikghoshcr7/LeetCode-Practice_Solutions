class Solution {
    public int maxDifference(String s, int k) {
        int n = s.length();
        // Initialize answer to a very small number.
        int ans = Integer.MIN_VALUE;

        // Step 1: Iterate through all possible pairs of distinct characters (a, b).
        for (char a = '0'; a <= '4'; ++a) {
            for (char b = '0'; b <= '4'; ++b) {
                if (a == b) {
                    continue;
                }

                // --- Start of logic for a single (a, b) pair ---

                // best[status] stores the minimum (prev_a - prev_b) for a prefix
                // with the parity state 'status'. Initialize with a large value.
                int[] best = new int[4];
                Arrays.fill(best, Integer.MAX_VALUE);

                // cnt_a, cnt_b: Prefix counts for the 'right' pointer (s[0...right]).
                int cnt_a = 0, cnt_b = 0;
                // prev_a, prev_b: Prefix counts for the 'left' pointer (s[0...left]).
                int prev_a = 0, prev_b = 0;
                // 'left' tracks the end of the prefix we are recording in the 'best' array.
                int left = -1;

                // The main loop iterating through the string with the 'right' pointer.
                for (int right = 0; right < n; ++right) {
                    // Update prefix counts for the current 'right' position.
                    cnt_a += (s.charAt(right) == a) ? 1 : 0;
                    cnt_b += (s.charAt(right) == b) ? 1 : 0;

                    // This loop updates the 'best' array. It advances the 'left' pointer
                    // and records the state of the prefix ending at 'left'.
                    // The conditions ensure that any substring starting at 'left + 1'
                    // will have a length of at least 'k'.
                    // Also, `cnt_b - prev_b >= 2` since b appears an even number of times in the substring,
                    // but zero occurrences must be excluded (and 1 must also be excluded since it's odd, obviously)
                    while (right - left >= k && cnt_b - prev_b >= 2) {
                        // Get the parity state for the prefix ending at 'left'.
                        int left_status = getStatus(prev_a, prev_b);

                        // Update the 'best' array with the minimum value of (prev_a - prev_b)
                        // for this specific state.
                        best[left_status] = Math.min(
                                best[left_status],
                                prev_a - prev_b
                        );

                        // Advance the left pointer and its corresponding prefix counts.
                        ++left;
                        prev_a += (s.charAt(left) == a) ? 1 : 0;
                        prev_b += (s.charAt(left) == b) ? 1 : 0;
                    }

                    // Now, calculate the potential answer for the current 'right' pointer.
                    // 1. Get the parity state for the prefix ending at 'right'.
                    int right_status = getStatus(cnt_a, cnt_b);

                    // 2. Determine the required state for the start-prefix.
                    // We need `left_status = right_status XOR 10` (binary).
                    int required_status = right_status ^ 0b10;

                    // 3. If we have seen a valid starting prefix with the required state...
                    if (best[required_status] != Integer.MAX_VALUE) {
                        // Calculate the difference: (cnt_a-cnt_b) - min(prev_a-prev_b).
                        // This maximizes the expression.
                        ans = Math.max(
                                ans,
                                cnt_a - cnt_b - best[required_status]
                        );
                    }
                }
            }
        }
        return ans;
    }

    /**
     * Helper function to calculate the 2-bit parity state.
     * Bit 1: parity of cnt_a. Bit 0: parity of cnt_b.
     */
    private int getStatus(int cnt_a, int cnt_b) {
        // (cnt_a & 1) is 1 if cnt_a is odd, 0 if even.
        // << 1 shifts it to the second bit position.
        // | (cnt_b & 1) puts the parity of cnt_b in the first bit position.
        return ((cnt_a & 1) << 1) | (cnt_b & 1);
    }
}