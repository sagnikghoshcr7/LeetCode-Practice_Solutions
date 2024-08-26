class Solution {
    public List<Integer> postorder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        return helper(root, list);
    }
    
    public List<Integer> helper(Node root, ArrayList<Integer> list) {
        if (root == null) return list;
        
        for (Node child : root.children) {
            helper(child, list);
        }
        
        list.add(root.val);
        return list;
    }
}