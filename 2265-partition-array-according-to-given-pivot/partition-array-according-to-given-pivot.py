class Solution:
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:
        n = len(nums)
        ans = [0] * n
        left, right = 0, n - 1
        
        for i in range(n):
            if nums[i] < pivot:
                ans[left] = nums[i]
                left += 1
            if nums[n - 1 - i] > pivot:
                ans[right] = nums[n - 1 - i]
                right -= 1
                
        while left <= right:
            ans[left] = pivot
            left += 1
            
        return ans 