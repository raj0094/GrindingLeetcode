class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int i = 0;
        int zeros = 0;
        int maxlen = 0;

        for (int j = 0; j < n; j++) {
            if (nums[j] == 0) {
                zeros++;
            }

            while (zeros > 1) {
                if (nums[i] == 0) {
                    zeros--;
                }
                i++;
            }

            maxlen = Math.max(maxlen, j - i);
        }

        return maxlen;
    }
}