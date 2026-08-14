class Solution:
    def maximumLengthSubstring(self, s: str) -> int:
        freq = [0] * 26
        left = ans = 0

        for right, c in enumerate(s):
            i = ord(c) - 97
            freq[i] += 1

            while freq[i] > 2:
                freq[ord(s[left]) - 97] -= 1
                left += 1

            ans = max(ans, right - left + 1)

        return ans