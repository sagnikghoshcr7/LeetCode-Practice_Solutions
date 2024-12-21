class Solution {
    ArrayList<String> list;
    StringBuilder sb;
    public String getHappyString(int n, int k) {
        list = new ArrayList<>();
        sb = new StringBuilder();

        helper(n, ' ');
        // Collections.sort(list);
        if (list.size() < k) return "";
        else return list.get(k-1);
    }

    public void helper(int n, char left) {
        if (sb.length() == n) {
            list.add(sb.toString());
            return;
        }
        else {
            for (char ch='a'; ch<='c'; ch++) {
                if (ch != left) {
                    sb.append(ch);
                    helper(n, ch);
                    sb.delete(sb.length() -1, sb.length());
                }
            }
        }
    }
}