class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0;
        int max = 0;

        for (int j = 0; j < n; j++) {

            // Add current fruit
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);

            // More than 2 types
            while (map.size() > 2) {

                map.put(fruits[i], map.get(fruits[i]) - 1);

                if (map.get(fruits[i]) == 0) {
                    map.remove(fruits[i]);
                }

                i++;
            }

            // Current valid window
            max = Math.max(max, j - i + 1);
        }

        return max;
    }
}