```
public ListNode detectCycle(ListNode head) {
if (head == null || head.next == null) {
return null;   // no circle
}
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
fast = fast.next.next;
slow = slow.next;
if (fast == slow) {  // circle detected
while (head != fast) {
fast = fast.next;
head = head.next;
}
return head;
}
}
return null; // no circle
}
```