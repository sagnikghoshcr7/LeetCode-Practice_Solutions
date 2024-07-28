class Solution {
    int stepsTime(int steps, int time, int change) {
        int res = 0;
        while (--steps > 0) {
            res += time;
            if ((res / change) % 2 == 1)
                res = (res / change + 1) * change;
        }
        return res + time;
    }    
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> al = new ArrayList<List<Integer>>();
        int[] minSteps = new int[n + 1];
        Arrays.fill(minSteps, 10001);
        for (int i = 0; i <= n; ++i)
            al.add(new ArrayList<Integer>());
        for (var e : edges) {
            al.get(e[0]).add(e[1]);
            al.get(e[1]).add(e[0]);
        }
        int step = -1;
        List<Integer> q = new ArrayList<>(List.of(1));
        while(!q.isEmpty() && ++step <= minSteps[n] + 1) {
            List<Integer> q1 = new ArrayList<>();
            for (int i : q) {
                if (step == minSteps[i] || step > minSteps[i] + 1)
                    continue;
                minSteps[i] = Math.min(minSteps[i], step);
                if (i == n && step > minSteps[n])
                    return stepsTime(step, time, change);
                for (int j : al.get(i))
                    q1.add(j);
            }
            q = q1;
        }
        return stepsTime(minSteps[n] + 2, time, change);
    }
}