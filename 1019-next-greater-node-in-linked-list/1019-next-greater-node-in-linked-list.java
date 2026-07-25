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
    public int[] nextLargerNodes(ListNode head) {

    
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode curr = head;

        while (curr != null) {
            arr.add(curr.val);
            curr = curr.next;
        }

        int n = arr.size();
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

    
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= arr.get(i)) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = st.peek();
            }

            st.push(arr.get(i));
        }

        return ans;
    }
}