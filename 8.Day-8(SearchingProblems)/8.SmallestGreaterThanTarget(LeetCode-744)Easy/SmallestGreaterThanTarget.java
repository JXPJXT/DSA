class SmallestGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return letters[start % n];
    }

    public static void main(String[] args) {
        SmallestGreaterThanTarget solution = new SmallestGreaterThanTarget();
        char[] letters1 = {'c', 'f', 'j'};
        char target1 = 'a';
        System.out.println("The smallest letter greater than '" + target1 + "' is: " + solution.nextGreatestLetter(letters1, target1));

        char[] letters2 = {'c', 'f', 'j'};
        char target2 = 'c';
        System.out.println("The smallest letter greater than '" + target2 + "' is: " + solution.nextGreatestLetter(letters2, target2));
    }
}