class Solution {
    public int countPalindromicSubsequence(String s) {

          HashMap<Character,Integer> firstMap = new  HashMap<>();
        HashMap<Character,Integer> Lastmap = new  HashMap<>();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!firstMap.containsKey(ch)) {
                firstMap.put(ch,i);
            }
            Lastmap.put(ch,i);
        
        }
        int count =0 ;
        
        for(char ch : firstMap.keySet()){
            int firstIdx = firstMap.get(ch);
            int lastIdx = Lastmap.get(ch);
            Set<Character> set = new HashSet<>();
            for(int i = firstIdx + 1; i<=lastIdx-1;i++){
                set.add(s.charAt(i));

            }
            count += set.size();
        }
        return count;

        
    }
}