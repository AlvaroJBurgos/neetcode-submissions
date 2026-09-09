class Solution {
    public int orangesRotting(int[][] grid) {
        int result = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }                    
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size(); 
            for(int k = 0; k < size; k++) {
                int[] current = queue.poll();
                int i = current[0];
                int j = current[1];
                if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    queue.offer(new int[] {i + 1, j});
                }
                if (j + 1 < grid[i].length && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    queue.offer(new int[] {i, j + 1});
                }
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    queue.offer(new int[] {i - 1, j});
                }
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    queue.offer(new int[] {i, j-1});
                }
            }
            if(!queue.isEmpty()) {
                result++;
            }
            
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) return -1;
            }
        }
        return result;
    }

}
