/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {

       
       Stack<ListNode> reverse = new Stack<>();

ListNode temp = head;

while (temp != null) {
    reverse.push(temp);
    temp = temp.next;
}

temp = head;

while (temp != null && !reverse.isEmpty()) {
    if (reverse.pop().val != temp.val) {
        return false;
    }
    temp = temp.next;
}

return true;
        
        
    }
}