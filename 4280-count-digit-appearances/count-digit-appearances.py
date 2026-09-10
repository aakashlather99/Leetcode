class Solution:
    def countDigitOccurrences(self, nums: list[int], digit: int) -> int:
        return sum(str(x).count(str(digit)) for x in nums)