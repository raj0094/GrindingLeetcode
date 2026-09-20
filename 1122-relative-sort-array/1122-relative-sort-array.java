class Solution {
    public int[] relativeSortArray(int[] arr, int[] nums) {
        int[] res = new int[arr.length];

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int ele : arr) {
            if (map.containsKey(ele)) {
                int freq = map.get(ele);
                map.put(ele, freq + 1);
            } else {
                map.put(ele, 1);
            }
        }

        int idx = 0;

        // Add elements according to nums order
        for (int ele : nums) {

            int freq = map.get(ele);

            for (int i = 0; i < freq; i++) {
                res[idx] = ele;
                idx++;
            }

            map.remove(ele); 
        }

        // Collect remaining elements
        ArrayList<Integer> remaining = new ArrayList<>();

        for (int ele : map.keySet()) {
            int freq = map.get(ele);

            for (int i = 0; i < freq; i++) {
                remaining.add(ele);
            }
        }

        // Sort remaining elements
        Collections.sort(remaining);

        // Add remaining elements to result
        for (int ele : remaining) {
            res[idx] = ele;
            idx++;
        }

        return res;
        
        
    }
}