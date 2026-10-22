class Solution:
    def countSymmetricIntegers(self, low: int, high: int) -> int:
        ans = 0
        for x in range(low, high + 1):
            s = str(x)
            n = len(s)
            if n % 2 == 0 and sum(map(int, s[:n // 2])) == sum(map(int, s[n // 2:])):
                ans += 1
        return ans