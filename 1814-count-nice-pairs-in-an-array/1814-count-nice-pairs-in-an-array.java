class Solution {
    public static int rev(int n){
        int r =0;
        while (n!=0) {
            r=r*10 + n%10;
            n/=10;
        }
        return r;
    
    }
    public int countNicePairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i =0 ;i<nums.length;i++){
            int ele = nums[i] - rev(nums[i]);
            if(map.containsKey(ele)){
                int freq = map.get(ele);
                map.put(ele,freq+1); 
                count+=freq; 
                count %= 1000000007;           
            }
            else{
                map.put(ele,1);
            }
        

        }
        return count;
        
    }
}