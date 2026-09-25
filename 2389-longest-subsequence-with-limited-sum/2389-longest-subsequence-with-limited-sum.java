class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i =1 ;i<n;i++){
            nums[i] = nums[i]+nums[i-1];
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int low = 0;
            int high = n - 1;
            int length = 0;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] > queries[i]) {
                    high = mid - 1;
                } else {
                    length = mid + 1;
                    low = mid + 1;
                }
            }
            result[i] = length;
        }
        return result;
        
    }
}