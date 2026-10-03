
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minlength = Integer.MAX_VALUE;
        int n = nums.length;
        int sum = 0;
        int i = 0;

        for (int j = 0; j < n; j++) {
            sum += nums[j];

            while (sum >= target) {
                int length = j - i + 1;
                minlength = Math.min(minlength, length);

                sum -= nums[i];
                i++;
            }
        }

        return minlength == Integer.MAX_VALUE ? 0 : minlength;
    }
}