class RecentCounter {
    private static final int[] records = new int[10000];
    private int start;
    private int end;
    public RecentCounter() {
        start=0;
        end=0;
    }
    
    public int ping(int t) {
        while(start<end&&(t-records[start]>3000)){
            start++;
        }
        records[end++]=t;
        return end-start;
    }
    
    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
        System.out.println("ping(1): " + obj.ping(1));
        System.out.println("ping(100): " + obj.ping(100));
        System.out.println("ping(3001): " + obj.ping(3001));
        System.out.println("ping(3002): " + obj.ping(3002));
    }
}
