class Solution {

    public String rev(String str) {
        String reverse = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }

        return reverse;
    }

    public int maximumNumberOfStringPairs(String[] words) {
        HashSet<String> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            String reverse = rev(words[i]);

            if (set.contains(reverse)) {
                count++;
            } else {
                set.add(words[i]);
            }
        }

        return count;
    }
}