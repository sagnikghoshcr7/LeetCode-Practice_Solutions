class Solution {
    List<List<String>> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s, 0, new ArrayList<>());
        return list;
    }

    private void dfs(String s, int start, List<String> temp) {
        if (start >= s.length()) list.add(new ArrayList<>(temp));

        for (int i=start; i<s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                temp.add(s.substring(start, i+1));
                dfs(s, i+1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}