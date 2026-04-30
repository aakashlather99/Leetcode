from typing import List

class Solution:
    def maxPathScore(self, grid: List[List[int]], k: int) -> int:
        m, n = len(grid), len(grid[0])
        
        k = min(k, m + n - 1)
        
        costs = [0, 1, 1]
        scores = [0, 1, 2]
        
        dp = [[-1] * (k + 1) for _ in range(n)]
        
        start_val = grid[0][0]
        start_cost = costs[start_val]
        start_score = scores[start_val]
        
        if start_cost <= k:
            dp[0][start_cost] = start_score
            
        for i in range(m):
            next_dp = [[-1] * (k + 1) for _ in range(n)]
            
            for j in range(n):
                if i == 0 and j == 0:
                    if start_cost <= k:
                        next_dp[0][start_cost] = start_score
                    continue
                    
                cell_val = grid[i][j]
                cost = costs[cell_val]
                score = scores[cell_val]
                
                for c in range(k + 1 - cost):
                    if dp[j][c] != -1:
                        next_dp[j][c + cost] = max(
                            next_dp[j][c + cost], 
                            dp[j][c] + score
                        )
                        
                if j > 0:
                    for c in range(k + 1 - cost):
                        if next_dp[j-1][c] != -1:
                            next_dp[j][c + cost] = max(
                                next_dp[j][c + cost], 
                                next_dp[j-1][c] + score
                            )
                            
            # Move to the next row
            dp = next_dp
         
        max_final_score = max(dp[-1])
        return max_final_score if max_final_score != -1 else -1