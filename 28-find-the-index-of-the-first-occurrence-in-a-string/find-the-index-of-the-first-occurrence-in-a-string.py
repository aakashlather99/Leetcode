class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        m = len(needle)
        n = len(haystack)
        
        if m > n:
            return -1
        
        for i in range(n - m + 1):
            if haystack[i:i + m] == needle:
                return i
                
        return -1