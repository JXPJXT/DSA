import java.util.Arrays;

public class HeightChecker {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] heights = {1, 1, 4, 2, 1, 3};
        
        System.out.println("Original heights array: " + Arrays.toString(heights));

        int mismatchedCount = solution.heightChecker(heights);
        
        System.out.println("The number of students not in the correct position is: " + mismatchedCount);
    }
}

class Solution {
    public int heightChecker(int[] heights) {
        int[] hA=new int[heights.length];
        for(int i=0;i<heights.length;i++){
            hA[i]=heights[i];
        }
        Arrays.sort(hA);
        int c=0;
        for(int i=0;i<heights.length;i++){
            if(hA[i]!=heights[i]){
                c++;
            }
        }
        return c;
    }
}
