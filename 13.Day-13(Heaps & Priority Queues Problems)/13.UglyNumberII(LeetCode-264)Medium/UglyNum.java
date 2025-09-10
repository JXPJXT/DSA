import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Collections;

class UglyNum {
    public int nthUglyNumber(int n) {
        HashSet<Long> seen = new HashSet<>();
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        
        long[] primes = {2L, 3L, 5L}; 
        minHeap.add(1L);
        seen.add(1L);
        long currentUgly = 1;

        for (int i = 0; i < n; i++) {
            currentUgly = minHeap.poll();
            for (long prime : primes) {
                long next = currentUgly * prime;
                if (!seen.contains(next)) {
                    seen.add(next);
                    minHeap.add(next);
                }
            }
        }

        return (int) currentUgly;
    }

    public static void main(String[] args) {
        UglyNum solution = new UglyNum();
        int n1 = 10;
        System.out.println("The " + n1 + "th ugly number is: " + solution.nthUglyNumber(n1));
        
        int n2 = 1;
        System.out.println("The " + n2 + "st ugly number is: " + solution.nthUglyNumber(n2));
    }
}
