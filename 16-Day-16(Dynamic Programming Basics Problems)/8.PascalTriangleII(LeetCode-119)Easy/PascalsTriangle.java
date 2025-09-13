import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);

        for (int i = 0; i < rowIndex; i++) {
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int j = 1; j < row.size(); j++) {
                newRow.add(row.get(j - 1) + row.get(j));
            }
            newRow.add(1);
            row = newRow;
        }

        return row;        
    }
}

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int rowIndex1 = 3;
        System.out.println("Row " + rowIndex1 + " of Pascal's Triangle: " + solution.getRow(rowIndex1));
        System.out.println("---");

        // Test case 2
        int rowIndex2 = 0;
        System.out.println("Row " + rowIndex2 + " of Pascal's Triangle: " + solution.getRow(rowIndex2));
        System.out.println("---");

        // Test case 3
        int rowIndex3 = 5;
        System.out.println("Row " + rowIndex3 + " of Pascal's Triangle: " + solution.getRow(rowIndex3));
        System.out.println("---");
    }
}
