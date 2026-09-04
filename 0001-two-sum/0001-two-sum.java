class Solution {
    public int[] twoSum(int[] arr, int target) {

        // int[] ans = new int[2];

        // int n = nums.length;
        // for(int i  = 0 ;i <n ; i++){
        //     for(int j  = i+ 1; j < n ;j ++){
        //         if(nums[i] + nums[j] == target){
        //             ans[0] = i;
        //             ans[1] =j ;

        //         }
        //     }
        // }
        // return ans;


        // optimize o(n)

        int[] ans = {-1,-1};
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int rem = target - arr[i];
            if (map.containsKey(rem)) {
                int j = map.get(rem);
                ans[0] = j;
                ans[1] = i;
                break;
            }
            map.put(arr[i], i);
        }
        return  ans;
        
    }
}