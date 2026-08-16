class Solution:
    def isThree(self, n: int) -> bool:
        r = int(n ** 0.5)
        return r * r == n and self.isPrime(r)

    def isPrime(self, n: int) -> bool:
        if n < 2:
            return False
        for i in range(2, int(n ** 0.5) + 1):
            if n % i == 0:
                return False
        return True