from typing import List

class Solution:
    def maximumScore(self, grid: List[List[int]]) -> int:
        n = len(grid)
        if n <= 1:
            return 0

        # pref[c][r] will store the sum of the first r elements in column c
        pref = [[0] * (n + 1) for _ in range(n)]
        for c in range(n):
            for r in range(n):
                pref[c][r + 1] = pref[c][r] + grid[r][c]

        # prev_dp[j][k] = max score for cols 0..i-1 given h_{i-1} = j, h_i = k
        prev_dp = [[0] * (n + 1) for _ in range(n + 1)]
        
        # Initialize for i = 1 (column 0's score based on h_{-1}=0, h_0=j, h_1=k)
        for j in range(n + 1):
            for k in range(n + 1):
                if k > j:
                    prev_dp[j][k] = pref[0][k] - pref[0][j]

        # Process columns i from 1 to n - 2
        for i in range(1, n - 1):
            curr_dp = [[0] * (n + 1) for _ in range(n + 1)]
            pref_i = pref[i]

            for k in range(n + 1):
                prev_dp_k = [prev_dp[j][k] for j in range(n + 1)]
                pref_i_k = pref_i[k]

                # Precompute prefix maximums
                pref_max_F = [0] * (n + 1)
                cur_max = prev_dp_k[0]
                pref_max_F[0] = cur_max
                for j in range(1, n + 1):
                    if prev_dp_k[j] > cur_max:
                        cur_max = prev_dp_k[j]
                    pref_max_F[j] = cur_max

                # Precompute suffix maximums
                H = [0] * (n + 1)
                for j in range(n + 1):
                    diff = pref_i[j] - pref_i_k
                    H[j] = prev_dp_k[j] + (diff if diff > 0 else 0)

                suff_max_H = [0] * (n + 2)
                cur_max = H[n]
                suff_max_H[n] = cur_max
                for j in range(n - 1, -1, -1):
                    if H[j] > cur_max:
                        cur_max = H[j]
                    suff_max_H[j] = cur_max

                # Calculate transitions in O(1) time using the precomputations
                curr_dp_k = curr_dp[k]
                for nxt in range(n + 1):
                    diff = pref_i[nxt] - pref_i_k
                    term1 = (diff if diff > 0 else 0) + pref_max_F[nxt]
                    term2 = suff_max_H[nxt + 1] if nxt < n else -float('inf')
                    curr_dp_k[nxt] = term1 if term1 > term2 else term2

            prev_dp = curr_dp

        # Final score calculation for the last column (column n - 1)
        ans = 0
        pref_last = pref[n - 1]
        for j in range(n + 1):
            for k in range(n + 1):
                diff = pref_last[j] - pref_last[k]
                score_last = diff if diff > 0 else 0
                val = prev_dp[j][k] + score_last
                if val > ans:
                    ans = val

        return ans