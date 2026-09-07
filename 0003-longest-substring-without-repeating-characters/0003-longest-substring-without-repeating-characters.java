class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int maxLength = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;

        while (j < n) {

            char ch = s.charAt(j);

            if (map.containsKey(ch) && map.get(ch) >= i) {

                // Move i to the position after previous occurrence
                i = map.get(ch) + 1;
            }

            // Store/update latest position of character
            map.put(ch, j);

            // Calculate current window length
            int length = j - i + 1;

            maxLength = Math.max(maxLength, length);

            j++;
        }

        return maxLength;
    }
}