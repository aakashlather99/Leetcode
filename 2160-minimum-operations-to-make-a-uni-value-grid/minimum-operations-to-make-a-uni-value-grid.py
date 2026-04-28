class Solution:
    def minOperations(self, grid: List[List[int]], x: int) -> int:
        nums = []

        rem = grid[0][0] % x

        for row in grid:
            for num in row:
                if num % x != rem:
                    return -1
                nums.append(num)

        nums.sort()

        median = nums[len(nums)//2]

        ops = 0

        for num in nums:
            ops += abs(num-median)//x

        return ops