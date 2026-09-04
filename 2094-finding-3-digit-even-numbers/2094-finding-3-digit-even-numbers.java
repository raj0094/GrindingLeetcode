class Solution {
    public int[] findEvenNumbers(int[] arr) {
            HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int freq = map.get(arr[i]);
                map.put(arr[i], freq + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 100; i <= 999; i+=2) {

            int x = i;

            int c = x % 10;
            x /= 10;

            int b = x % 10;
            x /= 10;

            int a = x;

            if (map.containsKey(a)) {
                int aFreq = map.get(a);
                map.put(a, aFreq - 1);

                if (aFreq == 1)
                    map.remove(a);

                if (map.containsKey(b)) {
                    int bFreq = map.get(b);
                    map.put(b, bFreq - 1);

                    if (bFreq == 1)
                        map.remove(b);

                    if (map.containsKey(c)) {
                        int cFreq = map.get(c);
                        map.put(c, cFreq - 1);

                        if (cFreq == 1)
                            map.remove(c);

                        ans.add(i);

                        map.put(c, cFreq);
                    }

                    map.put(b, bFreq);
                }

                map.put(a, aFreq);
            }
        }

        int[] ans2 = new int[ans.size()];

        for (int index = 0; index < ans2.length; index++) {
            ans2[index] = ans.get(index);
        }

        return ans2;
        
    }
}