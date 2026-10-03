class Solution {
    public int maxSatisfied(int[] customer, int[] grumpy, int minute) {
         int n = customer.length;
        int i=0;
        int j = minute-1;
        int a = i;
        int b = j;
        int maxSatisfied = 0;
        int unSatisfied = 0;

        for(int x =i;x<=j;x++){
            if(grumpy[x] == 1){
                unSatisfied += customer[x];
            }
           
        }
        while (j<n) {
            if(maxSatisfied < unSatisfied){
                maxSatisfied = unSatisfied;
                a = i;b = j;
            }

            i++;j++;
            if(j<n && grumpy[j] ==1) unSatisfied += customer[j];
            if(grumpy[i-1]==1) unSatisfied -= customer[i-1];
            
            
        }
        for(int x = a ;x<=b; x++){
            grumpy[x] = 0;

        }

        int stisfy  = 0;
        for(int x =0;x<n;x++){
            if(grumpy[x] == 0) stisfy += customer[x];
        }
        return  stisfy;
    }
}