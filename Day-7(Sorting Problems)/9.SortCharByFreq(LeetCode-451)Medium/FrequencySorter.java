import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencySorter {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String s1 = "tree";
        System.out.println("Original string: " + s1);
        System.out.println("Sorted string: " + solution.frequencySort(s1));

        String s2 = "cccaaa";
        System.out.println("\nOriginal string: " + s2);
        System.out.println("Sorted string: " + solution.frequencySort(s2));

        String s3 = "Aabb";
        System.out.println("\nOriginal string: " + s3);
        System.out.println("Sorted string: " + solution.frequencySort(s3));
    }
}

class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(hm.entrySet());
        list.sort((e1,e2)->e2.getValue().compareTo(e1.getValue()));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            for(int i=0; i<entry.getValue(); i++){
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
