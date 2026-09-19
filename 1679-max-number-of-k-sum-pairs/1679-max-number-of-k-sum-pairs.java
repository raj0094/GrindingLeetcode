class Solution {
    public int maxOperations(int[] arr, int k) {
         Arrays.sort(arr);
        int n  = arr.length;
        int i = 0;
        int j = n-1;
        int count  =0;
        while (i < j ) {
            int sum = arr[i] + arr[j];
            if(sum == k){
                i++;
                j--;

                count ++;
            }
            if(sum < k){
                i++;
            }
            if(sum >k){
                j--;
            }
            
        }
        return count;
        
    }
}