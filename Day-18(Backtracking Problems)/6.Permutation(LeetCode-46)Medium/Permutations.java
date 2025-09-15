import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null||nums.length==0){
            return result;
        }
        backtrack(nums,new ArrayList<>(),result);
        return result;
    }
    private void backtrack(int []nums, List<Integer> currentPermutation, List<List<Integer>> result){
        if(currentPermutation.size()==nums.length){
            result.add(new ArrayList<>(currentPermutation));
            return;
        }
        for(int num:nums){
            if(!currentPermutation.contains(num)){
                currentPermutation.add(num);;
                backtrack(nums,currentPermutation,result);
                currentPermutation.remove(currentPermutation.size()-1);
                }
        }
    }
}

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = solution.permute(nums);
        System.out.println("Permutations for {1, 2, 3}:");
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
