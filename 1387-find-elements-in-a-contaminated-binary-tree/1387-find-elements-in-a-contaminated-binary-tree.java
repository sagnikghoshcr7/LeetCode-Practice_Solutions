class FindElements {
    private Set<Integer> seen = new HashSet<>();
    
    public FindElements(TreeNode root) {
        if (root != null) {
            root.val = 0;
            seen.add(root.val);
            bfs(root);
        }
    }
    
    public boolean find(int target) {
        return seen.contains(target);
    }
    
    private void bfs(TreeNode node) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.left != null) {
                cur.left.val = 2 * cur.val + 1;
                q.offer(cur.left);
                seen.add(cur.left.val);
            }
            if (cur.right != null) {
                cur.right.val = 2 * cur.val + 2;
                q.offer(cur.right);
                seen.add(cur.right.val);
            }
        }
    }
}