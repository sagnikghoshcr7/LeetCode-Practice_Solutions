```
class Solution {
public boolean isPalindrome(ListNode head) {
ListNode temp = head;
Stack<Integer> s = new Stack<>();
while (temp != null) {
s.push(temp.val);
temp = temp.next;
}
while(head != null) {
if (head.val != s.pop()) {
return false;
}
head = head.next;
}
return true;
}
}
```