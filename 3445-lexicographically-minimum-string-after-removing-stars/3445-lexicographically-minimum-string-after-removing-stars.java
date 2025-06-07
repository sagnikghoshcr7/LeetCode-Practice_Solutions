class Solution {
    public String clearStars(String s) {
        char[] arr = s.toCharArray();
        List<Integer>[] pos = new ArrayList[26];
        for (int i = 0; i < 26; i++) pos[i] = new ArrayList<>();
        PriorityQueue<Character> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '*') {
                char small = pq.peek();
                List<Integer> lst = pos[small - 'a'];
                int j = lst.remove(lst.size() - 1);
                arr[j] = '*';
                if (lst.isEmpty()) pq.poll();
            } else {
                int ci = c - 'a';
                if (pos[ci].isEmpty()) pq.add(c);
                pos[ci].add(i);
            }
        }
        StringBuilder res = new StringBuilder();
        for (char c : arr) if (c != '*') res.append(c);
        return res.toString();
    }
}