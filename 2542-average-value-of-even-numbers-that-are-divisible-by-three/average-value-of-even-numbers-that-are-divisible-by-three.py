class Solution:
    def averageValue(self, nums: List[int]) -> int:
        total = count = 0

        for x in nums:
            if x % 6 == 0:
                total += x
                count += 1

        return total // count if count else 0