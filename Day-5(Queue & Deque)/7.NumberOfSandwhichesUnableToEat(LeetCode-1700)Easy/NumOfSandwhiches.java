import java.util.Queue;
import java.util.LinkedList;

class NumOfSandwhiches {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        int top=0,count=0;
        for(int e:students){
            q.add(e);
        }
        while(!q.isEmpty()&&count!=q.size()){
            if(q.peek()==sandwiches[top]){
                count=0;
                top++;
                q.poll();
            }
            else{
                q.add(q.poll());
                count++;
            }
        }
        return q.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] students1 = {1,1,0,0};
        int[] sandwiches1 = {0,1,0,1};
        System.out.println("Students left (example 1): " + solution.countStudents(students1, sandwiches1));

        int[] students2 = {1,1,1,0,0,1};
        int[] sandwiches2 = {1,0,0,0,1,1};
        System.out.println("Students left (example 2): " + solution.countStudents(students2, sandwiches2));
    }
}
