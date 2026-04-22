class Solution:
    def romanToInt(self, s: str) -> int:
        total = 0
        prev = 0

        for c in reversed(s):
            if c == 'I': val = 1
            elif c == 'V': val = 5
            elif c == 'X': val = 10
            elif c == 'L': val = 50
            elif c == 'C': val = 100
            elif c == 'D': val = 500
            else: val = 1000  # 'M'

            if val < prev:
                total -= val
            else:
                total += val
                prev = val

        return total