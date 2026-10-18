import java.util.*;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });

        for (String ele : nums) {
            pq.offer(ele);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}