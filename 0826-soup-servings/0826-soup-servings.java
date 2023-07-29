class Solution {
    private Map<Pair, Double> mp = new HashMap<>();

    private double recur(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0 && b > 0) return 1;
        if (a > 0 && b <= 0) return 0;
        if (mp.containsKey(new Pair(a, b))) return mp.get(new Pair(a, b));

        double op1 = recur(a - 100, b);
        double op2 = recur(a - 75, b - 25);
        double op3 = recur(a - 50, b - 50);
        double op4 = recur(a - 25, b - 75);

        double result = 0.25 * (op1 + op2 + op3 + op4);
        mp.put(new Pair(a, b), result);
        return result;
    }

    public double soupServings(int n) {
        if (n >= 4800) return 1;
        double ans = recur(n, n);
        return ans;
    }
}