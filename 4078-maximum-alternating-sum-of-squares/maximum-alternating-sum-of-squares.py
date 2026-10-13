class Solution:
    def maxAlternatingSum(self, nums: List[int]) -> int:
        nums.sort(key=lambda x: x * x)
        n = len(nums)
        m = (n + 1) // 2
        return sum(x * x for x in nums[n - m:]) - sum(x * x for x in nums[:n - m])