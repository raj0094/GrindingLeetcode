class Solution {
    public long[] findPrefixScore(int[] arr) {
        long [] res = new long [arr.length];
        int maxval = Integer.MIN_VALUE;
        for(int i = 0;i <arr.length;i++){
            maxval = Math.max(arr[i],maxval);
            res[i] = (long)arr[i] + maxval;
        }
        
        for(int i =1 ;i<res.length;i++){
            res[i] = res[i]+res[i-1];
        }

        return res;
        
    }
}