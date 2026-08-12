class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int studentNeedOne = 0;
        int studentNeedZero = 0;
        for(int student : students){
            if(student == 0){
                studentNeedZero++;
            }
            else{
                studentNeedOne++;
            }
        }
        for(int sandwich : sandwiches){
            if(sandwich == 0){
                if(studentNeedZero == 0){
                    return studentNeedOne;
                }
                else{
                    studentNeedZero--;
                }
                
            }
            else if(sandwich == 1){
                if(studentNeedOne == 0){
                    return studentNeedZero;
                }
                else{
                    studentNeedOne--;
                }

            }


        }
        return 0;
        
    }
}