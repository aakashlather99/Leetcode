class Solution:
    def minimumSum(self, num: int) -> int:
        d = sorted(map(int, str(num)))
        return 10 * (d[0] + d[1]) + d[2] + d[3]