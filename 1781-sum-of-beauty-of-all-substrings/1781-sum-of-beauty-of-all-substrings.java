class Solution {
    public int beautySum(String s) {
         int n = s.length();
        int sum = 0;

        for (int i = 0; i < n; i++) {

            int[] freq = new int[26];
            int maxFreq = 0;

            for (int j = i; j < n; j++) {

                char ch = s.charAt(j);

                // Update frequency
                freq[ch - 'a']++;

                // Update maximum frequency
                maxFreq = Math.max(
                    maxFreq, freq[ch - 'a']
                );

                // Find minimum frequency
                int minFreq = Integer.MAX_VALUE;

                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        minFreq = Math.min(
                            minFreq, freq[k]
                        );
                    }
                }

                // Add beauty
                sum += maxFreq - minFreq;
            }
        }

        return sum;
        
    }
}