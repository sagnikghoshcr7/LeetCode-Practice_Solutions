class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> seen = new HashSet<>();
        for (String sup : supplies) {
            seen.add(sup);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < recipes.length; ++i) {
            q.offer(i);
        }
        List<String> ans = new ArrayList<>();
        int prevSize = seen.size() - 1;
        while (seen.size() > prevSize) {
            prevSize = seen.size();
            mid:
            for (int sz = q.size(); sz > 0; --sz) {
                int i = q.poll();
                for (String ing : ingredients.get(i)) {
                    if (!seen.contains(ing)) {
                        q.offer(i);
                        continue mid;
                    }
                }
                seen.add(recipes[i]);
                ans.add(recipes[i]);
            }
        }
        return ans;
    }
}