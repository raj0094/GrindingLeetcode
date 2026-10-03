class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int n = arr.length;
        int i =0;
        int j = 0;
        int sum = 0;
        int minlength =Integer.MAX_VALUE;
        while (j<n && sum<target) {
            sum+=arr[j++];      
        }
        j--;
        while (i<n &&j<n) {
            int length = j-i+1;
            if(sum>=target) minlength = Math.min(minlength, length);
            sum -= arr[i];
            i++;
            j++;
            while (j<n && sum < target) {
                sum+=arr[j++];      
            }
            j--;
            
        }
        if(minlength ==Integer.MAX_VALUE) return 0;
        return minlength;
        
    }
}