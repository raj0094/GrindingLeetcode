class Solution {
    public String[] findRelativeRanks(int[] score) {
         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        String[] result  = new String[score.length];
       
        for(int ele :score){
            pq.add(ele);
        }
        
        HashMap<Integer, String> map = new HashMap<>();

        int rank = 1;

        while (!pq.isEmpty()) {
            int ele = pq.poll();

            if (rank == 1) {
                map.put(ele, "Gold Medal");
            } else if (rank == 2) {
                map.put(ele, "Silver Medal");
            } else if (rank == 3) {
                map.put(ele, "Bronze Medal");
            } else {
                map.put(ele, String.valueOf(rank));
            }

            rank++;
        }
        for (int i = 0; i < score.length; i++) {
            result[i] = map.get(score[i]);
        }

        return result;

        
    }
}