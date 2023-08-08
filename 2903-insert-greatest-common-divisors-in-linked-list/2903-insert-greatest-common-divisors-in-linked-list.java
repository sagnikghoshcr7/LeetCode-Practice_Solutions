class Solution {
    private int gcd(int a, int b) {return b == 0 ? a : gcd(b, a%b);}
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head.next == null) return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null) {
            ListNode temp  = new ListNode(gcd(p1.val, p2.val));
            p1.next = temp;
            temp.next = p2;
            p1 = p1.next.next;
            p2 = p2.next;
        }
        return head;
    }
}