class Solution {
    public  static  class Pair  implements Comparable <Pair>{
    char ch;
    int val;

    Pair(char ch,int val){
        this.ch = ch;
        this.val = val;

        
    }
    public  int compareTo(Pair p){
            return this.val - p.val; //compare based on roll no;
    }
   }
    public String frequencySort(String s) {
         PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
    HashMap<Character,Integer> map = new HashMap<>();
   
    for(int i  = 0 ;i < s.length();i++){
        char ch = s.charAt(i);
        if(map.containsKey(ch)){
            int freq = map.get(ch);
            map.put(ch,freq+1);
        }else{
            map.put(ch,1);

        }

    }
    for(char ele : map.keySet()){
        int val = map.get(ele);
        Pair p = new Pair(ele, val);
        pq.add(p);
    }
    String ans = new String();
    while (!pq.isEmpty()) {
        Pair p = pq.remove();
        ans += String.valueOf(p.ch).repeat(p.val);
    }
    return ans;
        
    }
}