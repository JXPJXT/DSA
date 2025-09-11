class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] != color) {
            fill(image, sr, sc, color, image[sr][sc]);
        }
        return image;
    }

    public void fill(int[][] image, int i, int j, int color, int prev) {
        if (i < 0 || j < 0 || i > image.length - 1 || j > image[0].length - 1) {
            return;
        }
        if (image[i][j] != prev) {
            return;
        }
        image[i][j] = color;
        fill(image, i - 1, j, color, prev);
        fill(image, i + 1, j, color, prev);
        fill(image, i, j - 1, color, prev);
        fill(image, i, j + 1, color, prev);
    }

    public static void main(String[] args) {
        FloodFill solution = new FloodFill();
        int[][] image1 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr1 = 1, sc1 = 1, color1 = 2;
        int[][] result1 = solution.floodFill(image1, sr1, sc1, color1);
        System.out.println("Result for image1:");
        for (int[] row : result1) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
        // Expected output:
        // 2 2 2 
        // 2 2 0 
        // 2 0 1 

        System.out.println();

        int[][] image2 = {{0, 0, 0}, {0, 0, 0}};
        int sr2 = 0, sc2 = 0, color2 = 0;
        int[][] result2 = solution.floodFill(image2, sr2, sc2, color2);
        System.out.println("Result for image2:");
        for (int[] row : result2) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
        // Expected output:
        // 0 0 0 
        // 0 0 0 
    }
}