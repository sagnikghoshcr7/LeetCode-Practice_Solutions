class Solution {
    private static int leftmax;
    private static int rightmax;
    private static int[] all_lvl;
    
    private void dfsLeft(TreeNode root, int level){
        if (root==null){
            return;
        }
        all_lvl[root.val] = leftmax;
        leftmax = Math.max(level,leftmax);
        dfsLeft(root.left, level+1);
        dfsLeft(root.right, level+1);
    }
    private void dfsRight(TreeNode root, int level){
        if (root==null){
            return;
        }
        all_lvl[root.val] = Math.max(all_lvl[root.val], rightmax);
        rightmax= Math.max(level,rightmax);
        dfsRight(root.right, level+1);
        dfsRight(root.left, level+1);
    }
    
    public int[] treeQueries(TreeNode root, int[] queries) {
        leftmax=0;
        rightmax=0;
        int n = 100001;
        all_lvl = new int[n];
        dfsLeft(root,0);
        dfsRight(root,0);
        int m = queries.length;
        int [] ans = new int[m];
        for(int i = 0; i < m;i++){
            ans[i]=all_lvl[queries[i]];
        }
        return ans;
    }
}