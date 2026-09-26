class Solution {
    public List<String> topKFrequent(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (map.get(a) != map.get(b)) {
                return map.get(b) - map.get(a);
            }
            return a.compareTo(b);
        });

        ArrayList<String> ans = new ArrayList<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (map.containsKey(arr[i])) {
                int freq = map.get(arr[i]);
                map.put(arr[i], freq + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (String ele : map.keySet()) {
            pq.add(ele);
        }

        while (k > 0) {
            ans.add(pq.remove());
            k--;
        }

        return ans;
    }
}