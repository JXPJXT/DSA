import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            String hashStr = hashString(str);
            if(!map.containsKey(hashStr)) {
                map.put(hashStr, new ArrayList<>());
            }
            map.get(hashStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String hashString(String str) {
        int n = str.length();
        char[] hash = new char[26];
        for(int i = 0; i < n; i++) {
            hash[str.charAt(i)-'a']++;
        }
        return String.valueOf(hash);
    }
}

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Input: " + Arrays.toString(strs1));
        System.out.println("Output: " + solution.groupAnagrams(strs1));
        System.out.println("---");

        String[] strs2 = {""};
        System.out.println("Input: " + Arrays.toString(strs2));
        System.out.println("Output: " + solution.groupAnagrams(strs2));
        System.out.println("---");

        String[] strs3 = {"a"};
        System.out.println("Input: " + Arrays.toString(strs3));
        System.out.println("Output: " + solution.groupAnagrams(strs3));
        System.out.println("---");
    }
}
