class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int numLayers = Math.min(m, n) / 2;
        
        for (int layer = 0; layer < numLayers; layer++) {
            int top = layer;
            int bottom = m - 1 - layer;
            int left = layer;
            int right = n - 1 - layer;
            
            int len = 2 * (bottom - top + 1) + 2 * (right - left + 1) - 4;
            int[] vals = new int[len];
            int idx = 0;
            
            for (int j = left; j < right; j++) vals[idx++] = grid[top][j];
            for (int i = top; i < bottom; i++) vals[idx++] = grid[i][right];
            for (int j = right; j > left; j--) vals[idx++] = grid[bottom][j];
            for (int i = bottom; i > top; i--) vals[idx++] = grid[i][left];
            
            int effK = k % len;
            idx = effK;
            
            for (int j = left; j < right; j++) { 
                grid[top][j] = vals[idx % len]; 
                idx++; 
            }
            for (int i = top; i < bottom; i++) { 
                grid[i][right] = vals[idx % len]; 
                idx++; 
            }
            for (int j = right; j > left; j--) { 
                grid[bottom][j] = vals[idx % len]; 
                idx++; 
            }
            for (int i = bottom; i > top; i--) { 
                grid[i][left] = vals[idx % len]; 
                idx++; 
            }
        }
        
        return grid;
    }
}