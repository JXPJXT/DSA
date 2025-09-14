import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> charMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (charMap.containsKey(sc)) {
                if (charMap.get(sc) != tc) {
                    return false;
                }
            } else if (charMap.containsValue(tc)) {
                return false;
            }

            charMap.put(sc, tc);
        }

        return true;       
    }
}

public class IsoMorphicStr {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: True
        String s1 = "egg";
        String t1 = "add";
        System.out.println("Is \"" + s1 + "\" isomorphic to \"" + t1 + "\"? " + solution.isIsomorphic(s1, t1));

        // Example 2: False
        String s2 = "foo";
        String t2 = "bar";
        System.out.println("Is \"" + s2 + "\" isomorphic to \"" + t2 + "\"? " + solution.isIsomorphic(s2, t2));

        // Example 3: True
        String s3 = "paper";
        String t3 = "title";
        System.out.println("Is \"" + s3 + "\" isomorphic to \"" + t3 + "\"? " + solution.isIsomorphic(s3, t3));

        // Example 4: False
        String s4 = "badc";
        String t4 = "baba";
        System.out.println("Is \"" + s4 + "\" isomorphic to \"" + t4 + "\"? " + solution.isIsomorphic(s4, t4));
    }
}
