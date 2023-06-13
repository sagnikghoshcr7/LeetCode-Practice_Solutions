class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        // If the list has only one node or 0 rotations then return head
        if (head == null || k == 0 || head.next == null) return head;

        ListNode curr = head;
        ListNode tail = head;
        int length = 0;

        // Find the length of the list
        while (curr != null) {
            length++;
            tail = curr;
            curr = curr.next;
        }

        // If the length of the list is equal to the rotations or it is multiple of rotations then return same list
        if (length == k || k%length == 0) return head;

        int rotations = k%length;

        ListNode prev = head; curr = head;

        // Traverse the list to find the right spot
        for (int i=1; i<=length-rotations; i++) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = null;
        tail.next = head;
        head = curr;
        return head;
    }
}