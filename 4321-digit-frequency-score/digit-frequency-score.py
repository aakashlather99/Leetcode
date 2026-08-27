class Solution:
    def digitFrequencyScore(self, n: int) -> int:
        freq = [0] * 10
        while n:
            freq[n % 10] += 1
            n //= 10
        return sum(d * freq[d] for d in range(10))