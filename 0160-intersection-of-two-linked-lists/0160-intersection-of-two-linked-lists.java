public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode dummyA = headA, dummyB = headB;

        while (dummyA != dummyB) {
            dummyA = dummyA == null ? headB : dummyA.next;
            dummyB = dummyB == null ? headA : dummyB.next;
        }
        return dummyA;
    }
}