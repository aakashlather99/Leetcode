class Solution:
    def findClosest(self, x: int, y: int, z: int) -> int:
        a = abs(x - z)
        b = abs(y - z)
        if a < b:
            return 1
        if b < a:
            return 2
        return 0