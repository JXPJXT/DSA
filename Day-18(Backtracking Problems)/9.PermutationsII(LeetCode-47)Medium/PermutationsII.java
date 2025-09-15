import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permutations(nums, used, list);
        return res;
    }
    public void permutations(int[] nums, boolean[] used, List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            permutations(nums, used, list);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}

public class PermutationsII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = solution.permuteUnique(nums);
        System.out.println("Unique permutations for {1, 1, 2}:");
        System.out.println(result);
    }
}
