class Solution:
    def maxCoins(self, piles: List[int]) -> int:
        piles.sort()
        n = len(piles) // 3
        ans = 0
        i = len(piles) - 2

        for _ in range(n):
            ans += piles[i]
            i -= 2

        return ans