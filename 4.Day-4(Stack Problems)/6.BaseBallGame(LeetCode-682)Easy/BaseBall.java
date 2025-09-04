class BaseBall{
    public static int calPoints(String[] operations) {
        int[] records = new int[operations.length];
        int pointer = 0;
        
        for (String s : operations) {
            if (s.equals("+")) {
                records[pointer] = records[pointer - 1] + records[pointer - 2];
                pointer++;
            } else if (s.equals("D")) {
                records[pointer] = records[pointer - 1] * 2;
                pointer++;
            } else if (s.equals("C")) {
                pointer--;
                records[pointer] = 0;
            } else {
                records[pointer++] = Integer.parseInt(s);
            }
        }

        int sum = 0;
        for (int i = 0; i < pointer; i++) {
            sum += records[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        String[] operations = {"5", "2", "C", "D", "+"};
        int result = Solution.calPoints(operations);
        System.out.println(result);
    }
}
