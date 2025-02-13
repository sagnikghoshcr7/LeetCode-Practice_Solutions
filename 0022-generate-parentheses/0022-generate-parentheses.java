class Solution {
    public StringBuilder sb = new StringBuilder();
    public List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(0, 0, n);
        return res;
    }

    public void generate(int open, int close, int n) {
        if (open == close && open == n) {
            res.add(sb.toString());
            return;
        }

        if (close < open) {
            sb.append(')');
            generate(open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (open < n) {
            sb.append('(');
            generate(open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}