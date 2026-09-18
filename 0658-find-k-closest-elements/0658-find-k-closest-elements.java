class Solution {
    public static class Pair implements Comparable<Pair> {
        int ele;
        int dis;

        Pair(int ele, int dis) {
            this.ele = ele;
            this.dis = dis;
        }

        public int compareTo(Pair p) {
            if (this.dis == p.dis) {
                return Integer.compare(p.ele, this.ele);
            }
            return Integer.compare(p.dis, this.dis);
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // List<Integer> ans = new ArrayList<>();
        // int n = arr.length;

        // // Base cas
        // if (x <= arr[0]) {
        //     for (int i = 0; i < k; i++) {
        //         ans.add(arr[i]);
        //     }
        //     return ans;
        // }

        // // Base case
        // if (x >= arr[n - 1]) {
        //     for (int i = n - k; i < n; i++) {
        //         ans.add(arr[i]);
        //     }
        //     return ans;
        // }

        
        // int lowerBound = n;
        // int low = 0, high = n - 1;

        // while (low <= high) {
        //     int mid = low + (high - low) / 2;

        //     if (arr[mid] >= x) {
        //         lowerBound = mid;
        //         high = mid - 1;
        //     } else {
        //         low = mid + 1;
        //     }
        // }

        // int left = lowerBound - 1;
        // int right = lowerBound;

        // while (k-- > 0) {
        //     if (left < 0) {
        //         right++;
        //     } else if (right >= n) {
        //         left--;
        //     } else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
        //         left--;
        //     } else {
        //         right++;
        //     }
        // }

        // for (int i = left + 1; i < right; i++) {
        //     ans.add(arr[i]);
        // }

        // return ans;

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {

            int ele = arr[i];
            int dis = Math.abs(x - ele);

            Pair p = new Pair(ele, dis);
            pq.add(p);

            if (pq.size() > k) {
                pq.remove();
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            ans.add(p.ele);
        }

        Collections.sort(ans);

        return ans;
    }
}