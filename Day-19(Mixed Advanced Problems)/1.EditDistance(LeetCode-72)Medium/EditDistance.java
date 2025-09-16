import java.util.Arrays;

class Solution {
    public int minDistance(String word1, String word2) {
        int[][] cache = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                cache[i][j] = -1;
            }
        }

        return dp(word1, word2, word1.length(), word2.length(), cache);
    }

    private int dp(String word1, String word2, int i, int j, int[][] cache) {
        if (i == 0) return j;
        if (j == 0) return i;
        if (cache[i][j] != -1) return cache[i][j];

        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            cache[i][j] = dp(word1, word2, i - 1, j - 1, cache);
        } else {
            cache[i][j] = 1 + Math.min(
                    dp(word1, word2, i - 1, j, cache),
                    Math.min(
                            dp(word1, word2, i, j - 1, cache),
                            dp(word1, word2, i - 1, j - 1, cache)
                    )
            );
        }

        return cache[i][j];
    }
}

public class EditDistance {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String word1 = "horse";
        String word2 = "ros";
        System.out.println("The minimum number of operations to convert \"" + word1 + "\" to \"" + word2 + "\" is: " + solution.minDistance(word1, word2));
        
        System.out.println();
        
        String word3 = "intention";
        String word4 = "execution";
        System.out.println("The minimum number of operations to convert \"" + word3 + "\" to \"" + word4 + "\" is: " + solution.minDistance(word3, word4));
    }
}
