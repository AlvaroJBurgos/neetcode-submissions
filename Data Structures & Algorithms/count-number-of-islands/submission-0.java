class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        if (grid == null)
            return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    dfsNeighbors(grid, i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }
    private void dfsNeighbors(char[][] grid, int i, int j) {
        // Down
        if (i + 1 < grid.length && grid[i + 1][j] == '1') {
            grid[i + 1][j] = '0';
            dfsNeighbors(grid, i + 1, j);
        }
        // Right
        if (j + 1 < grid[i].length && grid[i][j + 1] == '1') {
            grid[i][j + 1] = '0';
            dfsNeighbors(grid, i, j + 1);
        }
        // Up
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            grid[i - 1][j] = '0';
            dfsNeighbors(grid, i - 1, j);
        }
        // Left
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            grid[i][j - 1] = '0';
            dfsNeighbors(grid, i, j - 1);
        }
    }
}
