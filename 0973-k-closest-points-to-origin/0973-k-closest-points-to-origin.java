class Solution {
      public  static  class Triplet implements Comparable <Triplet>{
        int dis;
        int x;
        int y;

        Triplet(int dis ,int x, int y){
            this.dis = dis;
            this.x = x;
            this.y = y;
            
        }
        public int compareTo(Triplet t) {
            return Integer.compare(t.dis, this.dis);
        }

    }
    public int[][] kClosest(int[][] nums, int k) {
         PriorityQueue<Triplet> pq = new PriorityQueue<>();
        for(int i =0 ;i < nums.length;i++){
            int x = nums[i][0];
            int y = nums[i][1];
            int dis = x*x + y*y;
            Triplet t = new Triplet(dis, x, y);
            pq.add(t);
            if(pq.size() > k){
                pq.remove();
            }

        }
        int [][] ans = new int[k][2];
        for(int i =0 ; i< k ;i++){
            Triplet tri  = pq.remove();
            ans[i][0] = tri.x;
            ans[i][1] = tri.y;


        }
        return  ans;
        
    }
}