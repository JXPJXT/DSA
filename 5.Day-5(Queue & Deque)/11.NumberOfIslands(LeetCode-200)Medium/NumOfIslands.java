class NumIsIslands {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        int numIslands=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    numIslands++;
                    dfs(grid,i,j);
                }
            }
        }
        return numIslands;
    }
    private void dfs(char[][] grid, int i,int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] grid1 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        System.out.println("Number of islands in grid 1: " + solution.numIslands(grid1));

        char[][] grid2 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of islands in grid 2: " + solution.numIslands(grid2));
    }
}
