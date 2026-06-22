class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        counts = [0] * 26
        
        for char in text:
            counts[ord(char) - ord('a')] += 1
            
        return min(
            counts[1],
            counts[0],
            counts[11] // 2,
            counts[14] // 2,
            counts[13]
        )