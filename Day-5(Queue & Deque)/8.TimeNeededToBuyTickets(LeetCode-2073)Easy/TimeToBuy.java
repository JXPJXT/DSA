class TimeToBuy {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int time = 0;
        int targetTickets = tickets[k];
        
        for (int i = 0; i  n; i++) {
            if (i = k) {
                time += Math.min(tickets[i], targetTickets);
            } else {
                time += Math.min(tickets[i], targetTickets - 1);
            }
        }
        return time;
    }

    public static void main(String[] args) {
        TimeToBuy solution = new TimeToBuy();

        int[] tickets1 = {2, 3, 2};
        int k1 = 2;
        System.out.println(Time required for tickets1  + solution.timeRequiredToBuy(tickets1, k1));

        int[] tickets2 = {5, 1, 1, 1};
        int k2 = 0;
        System.out.println(Time required for tickets2  + solution.timeRequiredToBuy(tickets2, k2));
    }
}
