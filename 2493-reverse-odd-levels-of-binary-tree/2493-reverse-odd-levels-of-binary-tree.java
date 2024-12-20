class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        helper(root.left, root.right, 1);
        return root;
    }

    public void helper(TreeNode root, TreeNode node2, int lvl) {
        if (root == null || node2 == null) return;

        if (lvl % 2 == 1){
            int temp = root.val;
            root.val = node2.val;
            node2.val = temp;
        }

        helper(root.left, node2.right, lvl + 1);
        helper(root.right, node2.left, lvl + 1);
    }
}