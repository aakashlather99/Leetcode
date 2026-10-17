class Solution:
    def minSwaps(self, nums: List[int]) -> int:
        def digit_sum(x):
            s = 0
            while x:
                s += x % 10
                x //= 10
            return s

        arr = sorted(nums, key=lambda x: (digit_sum(x), x))
        pos = {x: i for i, x in enumerate(nums)}
        ans = 0

        for i, x in enumerate(arr):
            if nums[i] != x:
                j = pos[x]
                pos[nums[i]] = j
                pos[x] = i
                nums[i], nums[j] = nums[j], nums[i]
                ans += 1

        return ans
