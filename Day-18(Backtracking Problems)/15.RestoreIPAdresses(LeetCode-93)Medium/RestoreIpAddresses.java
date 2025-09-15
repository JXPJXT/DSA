import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        helper(s, ans, 0, new ArrayList<>());
        return ans;
    }

    public static void helper(String s, List<String> ans, int idx, List<String> temp) {
        if (temp.size() > 4) {
            return;
        }
        if (idx == s.length() && temp.size() == 4) {
            ans.add(String.join(".", temp));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (isValid(s.substring(idx, i + 1))) {
                temp.add(s.substring(idx, i + 1));
                helper(s, ans, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static boolean isValid(String s) {
        if (s.length() > 3 || (s.length() > 1 && s.charAt(0) == '0')) {
            return false;
        }
        if (Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }
}

public class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "25525511135";
        List<String> result1 = solution.restoreIpAddresses(s1);
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Valid IP addresses: " + result1);
        System.out.println();

        // Test case 2
        String s2 = "0000";
        List<String> result2 = solution.restoreIpAddresses(s2);
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Valid IP addresses: " + result2);
        System.out.println();

        // Test case 3
        String s3 = "101023";
        List<String> result3 = solution.restoreIpAddresses(s3);
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Valid IP addresses: " + result3);
    }
}
