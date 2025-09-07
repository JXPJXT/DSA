public class ArrangeCoin {
    public int arrangeCoins(int n) {
        int s = 1;
        int e = n;
        while(s<=e){
            int mid = s + (e-s)/2;
            long sum = (long)mid*(mid+1)/2;
            if(sum == n) return mid;
            else if(sum > n) e = mid-1;
            else s = mid+1;
        }
        return s-1;
    }

    public static void main(String[] args) {
        ArrangeCoin solution = new ArrangeCoin();
        int n1 = 5;
        System.out.println("For n = " + n1 + ", the number of full rows is: " + solution.arrangeCoins(n1));
        
        int n2 = 8;
        System.out.println("For n = " + n2 + ", the number of full rows is: " + solution.arrangeCoins(n2));
    }
}