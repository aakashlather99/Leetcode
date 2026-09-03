class Solution:
    def uniformArray(self, nums1: list[int]) -> bool:
        minOdd = float('inf')
        minEven = float('inf')

        for x in nums1:
            if x & 1:
                minOdd = min(minOdd, x)
            else:
                minEven = min(minEven, x)

        return minOdd < minEven or minOdd == float('inf')