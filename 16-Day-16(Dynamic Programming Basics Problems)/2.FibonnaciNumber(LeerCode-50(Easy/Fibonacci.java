class Solution {
    Integer[] memo = new Integer[31];
    public int fib(int n) {

        if(memo[n] != null){
            return memo[n];
        }

        if(n==0 || n==1){
            return n;
        }

        memo[n] = fib(n-1) + fib(n-2);
        return memo[n];
    }
}

public class Fibonacci {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 10;
        System.out.println("The " + n1 + "th Fibonacci number is: " + solution.fib(n1));

        int n2 = 20;
        System.out.println("The " + n2 + "th Fibonacci number is: " + solution.fib(n2));
        
        int n3 = 30;
        System.out.println("The " + n3 + "th Fibonacci number is: " + solution.fib(n3));
    }
}
