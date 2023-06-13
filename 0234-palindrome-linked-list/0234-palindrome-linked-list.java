class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> st = new Stack<Integer>();
        ListNode dummy = head;
        while (dummy != null) {
            st.push(dummy.val);
            dummy = dummy.next;
        }
        dummy = head;
        while (dummy != null) {
            if (dummy.val != st.pop()) return false;
            dummy = dummy.next;
        }
        return true;        
    }
}