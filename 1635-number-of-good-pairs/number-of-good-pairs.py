class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        freq = {}
        ans = 0
        for x in nums:
            ans += freq.get(x, 0)
            freq[x] = freq.get(x, 0) + 1
        return ans