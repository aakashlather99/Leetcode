class Solution:
    def subsetXORSum(self, nums: List[int]) -> int:
        x = 0
        for n in nums:
            x |= n
        return x << (len(nums) - 1)