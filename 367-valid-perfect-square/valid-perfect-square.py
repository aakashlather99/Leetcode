class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        l, r = 1, num

        while l <= r:
            m = l + (r - l) // 2
            sq = m * m

            if sq == num:
                return True
            if sq < num:
                l = m + 1
            else:
                r = m - 1

        return False