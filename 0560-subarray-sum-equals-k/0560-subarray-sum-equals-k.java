class Solution {
    public int subarraySum(int[] arr, int k) {
        int count = 0;
        // for(int i =0;i<arr.length;i++){
        //     int sum =0;
        //     for(int j = i;j<arr.length;j++){
        //         sum+=arr[j];
        //         if(sum==k){
        //             count++;
        //         }
                
        //     }    
        // }
        // return count;

         for(int i = 1;i< arr.length;i++){
            arr[i] = arr[i]+arr[i-1];
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        
        for(int  ele : arr){
           
            if(ele==k){
                count++;
            }
            int remaining = ele - k;
            if(map.containsKey(remaining)){
                count += map.get(remaining);
            }
            
            if(map.containsKey(ele)){          
                int freq = map.get(ele);
                map.put(ele, freq+1);
            }
            else{
                map.put(ele,1);
            }
        }
        return count;
    }
}