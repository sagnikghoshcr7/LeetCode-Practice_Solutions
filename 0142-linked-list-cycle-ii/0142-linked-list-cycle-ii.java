public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; fast = fast.next.next;
            if (slow == fast) {
                ListNode dummy = head;
                while (dummy != slow) {
                    dummy = dummy.next; slow = slow.next;
                }
                return dummy;
            }
        }
        return null;
    }
}