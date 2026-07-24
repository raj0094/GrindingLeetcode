class Solution {
    public int largestRectangleArea(int[] arr) {
       
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int [] nse = new int[n];
        int [] npe = new int[n];

        
        // calculating nse : rigth to left;
        st.push(n-1);
        nse[n-1] = n;
        for (int i = n-2; i >=0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();               
            }
            if(st.isEmpty()){
                nse[i] = n;
            }
            else{
                nse[i] = st.peek();
            }

            st.push(i);
            
        }

        // empty stack

        while (!st.isEmpty()) {   
            st.pop();          
        }

        // calculating next previous ele
        st.push(0);
        npe[0] = -1;
        for(int i =1 ; i <=n-1 ;i++){
            while (!st.isEmpty() && arr[st.peek()] >= arr[i] ) {
                st.pop();               
            };
            if(st.isEmpty()){
                npe[i] = -1;
            }
            else{
                npe[i] = st.peek();
            }

            st.push(i);
        }

        // maximun area of rectangle 
        int mx = -1;
        for (int i = 0; i < n; i++) {
            int area = arr[i] *(nse[i]-npe[i]-1);
            mx = Math.max(mx, area);
            
        }

        return mx;


        
    }
}