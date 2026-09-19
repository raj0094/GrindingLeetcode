class Solution {
    public int[] twoSum(int[] arr, int k) {
        int i = 0;
        int j = arr.length - 1;
        int[] res  = new int[2];

        while (i < j) {
            int sum = arr[i] + arr[j];

            if (sum == k) {
                res[0]=i +1;
                res[1] = j +1;
                return res;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }

        return res;
        
    }
}