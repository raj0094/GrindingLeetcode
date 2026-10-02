class Solution {
    public int numOfSubarrays(int[] arr, int k, int thre) {
        int i = 0;
        int j = k-1;
        int count  = 0;
        int sum =0 ;
        int n = arr.length;
        for (int a = i; a <= j; a++) {
            sum += arr[a];
        }

        if (sum / k >= thre) {
            count++;
        }

        i++;
        j++;

        while (j < n) {
            sum = sum - arr[i - 1] + arr[j];

            if (sum / k >= thre) {
                count++;
            }

            i++;
            j++;
        }
        return count;
    }
}