class Solution {
    public static class Pair implements Comparable<Pair> {
        int ele;
        int freq;

        Pair(int ele, int freq) {
            this.ele = ele;
            this.freq = freq;
        }

        public int compareTo(Pair p) {
            return Integer.compare(this.freq, p.freq);
        }
    }
    public int[] topKFrequent(int[] arr, int k) {
         HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Maintain a min-heap of size k
        for (int ele : map.keySet()) {

            int freq = map.get(ele);

            Pair p = new Pair(ele, freq);
            pq.add(p);

            if (pq.size() > k) {
                pq.remove();
            }
        }

        // Store the k elements in the result
        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = pq.remove().ele;
        }

        return res;
        
    }
}