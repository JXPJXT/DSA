class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: first unique character is 'l' at index 0
        String s1 = "leetcode";
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("First unique character index: " + solution.firstUniqChar(s1));
        System.out.println("---");

        // Example 2: first unique character is 'v' at index 2
        String s2 = "loveleetcode";
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("First unique character index: " + solution.firstUniqChar(s2));
        System.out.println("---");

        // Example 3: no unique characters
        String s3 = "aabb";
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("First unique character index: " + solution.firstUniqChar(s3));
        System.out.println("---");
    }
}
