/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return       -1 if num is higher than the picked number
 * 1 if num is lower than the picked number
 * otherwise return 0
 * int guess(int num);
 */

// This is a dummy implementation of the GuessGame class for local testing.
class GuessGame {
    private int pickedNumber = 6; // Example picked number

    public int guess(int num) {
        if (num > pickedNumber) {
            return -1;
        } else if (num < pickedNumber) {
            return 1;
        } else {
            return 0;
        }
    }
}

class GuessNumHiOrLo extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int find = guess(mid);
            if (find == 0) {
                return mid;
            } else if (find > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        GuessNumHiOrLo game = new GuessNumHiOrLo();
        int n = 10;
        int result = game.guessNumber(n);
        System.out.println("The number is: " + result);
    }
}