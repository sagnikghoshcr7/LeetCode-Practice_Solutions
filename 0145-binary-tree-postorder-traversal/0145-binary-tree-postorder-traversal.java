class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, ArrayList<Integer> res) {
        if (root != null) {
            helper(root.left, res);
            helper(root.right, res);
            res.add(root.val);
        }
    }
}