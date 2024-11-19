class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = helper(root.left);
        int right = helper(root.right);

        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int helper (TreeNode root) {
        if (root == null) return 0;
        return Math.max(helper(root.left), helper(root.right)) + 1;
    }
}