class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n-k];

        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for(int ele :nums){
        //     pq.add(ele);
        //     if(pq.size() > k){
        //         pq.remove();
        //     }
        // }
        // return pq.peek();
        
    }
}