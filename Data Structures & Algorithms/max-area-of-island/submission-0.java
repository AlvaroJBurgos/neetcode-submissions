class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i= 0; i< grid.length; i++){
            for(int j = 0; j< grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    max = Math.max(max, maxArea(grid, i, j) +1);
                }
            }
        }
        return max;
    }
    private int maxArea(int[][] grid, int i, int j) {
        int up = 0, down = 0, right = 0, left = 0;
        if (i - 1 >= 0 && grid[i-1][j] == 1) {
            up++;
            grid[i-1][j] = 0;
            up +=  maxArea(grid, i-1, j);
        }
        if (i + 1 < grid.length && grid[i+1][j] == 1) {
            down++;
            grid[i+1][j] = 0;
            down += maxArea(grid, i+1, j); 
        }
        if (j - 1 >= 0 && grid[i][j-1] == 1) {
            left++;
            grid[i][j-1] = 0;
            left += maxArea(grid, i, j-1); 
        }
        if (j + 1 < grid[i].length && grid[i][j+1] == 1) {
            right++;
            grid[i][j+1] = 0;
            right += maxArea(grid, i, j+1); 
        }
        return up+down+left+right;
    }
}
