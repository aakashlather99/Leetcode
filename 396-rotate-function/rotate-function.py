class Solution:
    def maxRotateFunction(self, nums: List[int]) -> int:
        total_sum = sum(nums)
        n = len(nums)
        current_f = sum(i * num for i, num in enumerate(nums))
        max_f = current_f
        
        for i in range(1, n):
            current_f += total_sum - n * nums[n - i]
            if current_f > max_f:
                max_f = current_f
                
        return max_f