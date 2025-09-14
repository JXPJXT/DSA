import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }
}

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: Basic test case
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Input: " + Arrays.toString(strs1));
        System.out.println("Output: " + solution.groupAnagrams(strs1));

        System.out.println();

        // Example 2: Empty array
        String[] strs2 = {};
        System.out.println("Input: " + Arrays.toString(strs2));
        System.out.println("Output: " + solution.groupAnagrams(strs2));
        
        System.out.println();

        // Example 3: Single-element array
        String[] strs3 = {"a"};
        System.out.println("Input: " + Arrays.toString(strs3));
        System.out.println("Output: " + solution.groupAnagrams(strs3));
    }
}
