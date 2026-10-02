class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = k - 1;
        long sum = 0;
        long maxsum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int a = i; a <= j; a++) {
            sum += nums[a];
            map.put(nums[a], map.getOrDefault(nums[a], 0) + 1);
        }

        if (map.size() == k) {
            maxsum = sum;
        }

        i++;
        j++;

        while (j < n) {
            sum = sum - nums[i - 1] + nums[j];

            map.put(nums[i - 1], map.get(nums[i - 1]) - 1);

            if (map.get(nums[i - 1]) == 0) {
                map.remove(nums[i - 1]);
            }

            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            if (map.size() == k) {
                maxsum = Math.max(maxsum, sum);
            }

            i++;
            j++;
        }

        return maxsum;
    }
}