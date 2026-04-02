class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][] prev = new int[n][3];
        int[][] curr = new int[n][3];
        
        int MIN_INF = -1000000000; 
        
        // Initialization
        for (int j = 0; j < n; j++) {
            for(int k = 0; k < 3; k++) {
                prev[j][k] = MIN_INF;
                curr[j][k] = MIN_INF;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Base Case: Starting point
                if (i == 0 && j == 0) {
                    curr[0][0] = coins[0][0];
                    curr[0][1] = coins[0][0] < 0 ? 0 : coins[0][0];
                    curr[0][2] = coins[0][0] < 0 ? 0 : coins[0][0];
                    continue;
                }
                
                int val = coins[i][j];
                
                for (int k = 0; k < 3; k++) {
                    int maxPrev = MIN_INF;
                    if (i > 0) maxPrev = Math.max(maxPrev, prev[j][k]);
                    if (j > 0) maxPrev = Math.max(maxPrev, curr[j - 1][k]);
                    curr[j][k] = maxPrev == MIN_INF ? MIN_INF : maxPrev + val;

                    if (k > 0 && val < 0) {
                        int maxPrev_k_1 = MIN_INF;                       
                        if (i > 0) maxPrev_k_1 = Math.max(maxPrev_k_1, prev[j][k - 1]);
                        if (j > 0) maxPrev_k_1 = Math.max(maxPrev_k_1, curr[j - 1][k - 1]);
                        
                        if (maxPrev_k_1 != MIN_INF) {
                            curr[j][k] = Math.max(curr[j][k], maxPrev_k_1);
                        }
                    }
                }
            }
            
            // Swap references
            int[][] temp = prev;
            prev = curr;
            curr = temp;
        }
        
        return Math.max(prev[n - 1][0], Math.max(prev[n - 1][1], prev[n - 1][2]));
    }
}