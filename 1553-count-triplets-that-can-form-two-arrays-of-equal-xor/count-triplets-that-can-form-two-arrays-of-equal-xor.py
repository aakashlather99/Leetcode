class Solution:
    def countTriplets(self, arr: List[int]) -> int:
        ans = 0
        xor = 0
        count = {0: 1}
        total = {0: 0}

        for j, x in enumerate(arr):
            xor ^= x
            if xor in count:
                ans += count[xor] * j - total[xor]
            count[xor] = count.get(xor, 0) + 1
            total[xor] = total.get(xor, 0) + j + 1

        return ans