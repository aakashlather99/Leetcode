class Solution:
    def validDigit(self, n: int, x: int) -> bool:
        s = str(n)
        return s[0] != str(x) and str(x) in s