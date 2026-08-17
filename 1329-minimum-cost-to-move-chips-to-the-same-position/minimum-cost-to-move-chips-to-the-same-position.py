class Solution:
    def minCostToMoveChips(self, position: List[int]) -> int:
        even = sum(x % 2 == 0 for x in position)
        odd = len(position) - even
        return min(even, odd)