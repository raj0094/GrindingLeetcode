class Solution {
    public int beautySum(String s) {
         int sum = 0;

        for (int i = 0; i < s.length(); i++) {

            // Create a new map for every starting index
            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = i; j < s.length(); j++) {

                char ch = s.charAt(j);

                // Update frequency
                if (map.containsKey(ch)) {
                    int freq = map.get(ch);
                    map.put(ch, freq + 1);
                } else {
                    map.put(ch, 1);
                }

                int maxval = Integer.MIN_VALUE;
                int minval = Integer.MAX_VALUE;

                // Find max and min frequency
                for (char ele : map.keySet()) {

                    maxval = Math.max(maxval, map.get(ele));
                    minval = Math.min(minval, map.get(ele));

                }

                int res = maxval - minval;

                sum += res;
            }
        }

        return sum;

        
    }
}