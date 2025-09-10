import java.util.HashMap;
import java.util.PriorityQueue;
import java.lang.StringBuilder;

class SortCharByFreq {
    public String frequencySort(String s) {
        HashMap<Character, Integer> cnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> (cnt.get(b) - cnt.get(a)));
        heap.addAll(cnt.keySet());
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            char c = heap.poll();
            for (int i = 0; i < cnt.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SortCharByFreq solution = new SortCharByFreq();
        String s1 = "tree";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + solution.frequencySort(s1));

        String s2 = "ccaa";
        System.out.println("\nInput: " + s2);
        System.out.println("Output: " + solution.frequencySort(s2));
    }
}
