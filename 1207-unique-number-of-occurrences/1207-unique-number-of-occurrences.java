class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i =0 ;i < arr.length; i++){
            if(map.containsKey(arr[i])){
                int freq = map.get(arr[i]);
                map.put(arr[i],freq+1);
            }
            else{
                map.put(arr[i],1);
            }
        }

        for(Integer key:map.keySet()){
            int val = map.get(key);
            set.add(val);
        }

        if(map.size()!=set.size()) return false;
        else return true;
        
    }
}