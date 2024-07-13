class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] h, String directions) {
        int n = positions.length;
        List<Integer> ind = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ind.add(i);
        }
        ind.sort((a, b) -> Integer.compare(positions[a], positions[b]));

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i : ind) {
            if (directions.charAt(i) == 'R') {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && h[i] > 0) {
                if (h[stack.peek()] < h[i]) {
                    h[stack.pop()] = 0;
                    h[i] -= 1;
                } else if (h[stack.peek()] > h[i]) {
                    h[stack.peek()] -= 1;
                    h[i] = 0;
                } else {
                    h[stack.pop()] = 0;
                    h[i] = 0;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int v : h) {
            if (v > 0) {
                res.add(v);
            }
        }
        return res;
    }
}