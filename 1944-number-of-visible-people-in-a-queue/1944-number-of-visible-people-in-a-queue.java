class Solution {
    public int[] canSeePersonsCount(int[] arr) {
        int[] res = new int[arr.length];

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {

            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                res[st.peek()]++;
                st.pop();
                
            }
            if(!st.isEmpty()){
                res[st.peek()]++;
            }

            st.push(i);
            
        }
        return res;
 
        
    }
}